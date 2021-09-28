node()
{

  stage('Checkout to phase02_task02 repo') {
    checkout(scm: [
        $class: 'GitSCM',
        branches: [[name: '*/master']],
        userRemoteConfigs: [[
        url: params.git_url,
        credentialsId: 'git-auth'
        ]],
    ])
  }

  stage('build_wp_image') {

    //Extracting minor version from the Tag to pass the arg to Dockerfile
    currentTag = params.PLUGIN_TAG_VERSION
    tagChunks = currentTag.tokenize('.')
    strippedTagVersion = tagChunks[1] as int
    echo "Stripped Tag Version --> ${strippedTagVersion}"

    //Building docker image
    dockerfile = 'Dockerfile'
    wordpressImage = docker.build(
      "danpaldev/wp-jenkins:${params.PLUGIN_TAG_VERSION}",
      "--build-arg PLUGIN_VERSION=${strippedTagVersion} -f ${dockerfile} .")

    //Pushing docker image to Dockerhub
    docker.withRegistry('', 'dockerhub-auth') {
      wordpressImage.push("${params.PLUGIN_TAG_VERSION}")
    }

  }
  stage('deploy dev enivronment') {
    //Deleting containers from previous task attemps
    sh 'docker-compose stop'
    sh 'docker-compose down --volumes'

    // 'run docker-compose in detached mode with provided version of wordpress image'
    sh "python3 yaml_modifier.py --dev docker-compose.yml danpaldev/wp-jenkins:${params.PLUGIN_TAG_VERSION}"
    sh 'docker-compose up -d'
    sh '''
      until docker container exec deploydev_database_1 mysql -P 3306 -u wp_user --password=wp_password --execute="SHOW DATABASES;" | grep "wordpress" ; do
        >&2 echo "MySQL is unavailable - waiting for it... 😴"
        sleep 3
      done
    '''
  }

  stage('testing') {
    sh "docker run --network=host --rm -e WP_URL='http://localhost:81' -e WP_PLUGIN_VERSION=${params.PLUGIN_TAG_VERSION} danpaldev/wp-testing:v2"
    //TODO -> Add a way to exit pipeline if any ERROR message apears on stdout
  }

  stage('destroy dev enivronment') {
    sh 'docker-compose down -v'
  }

  stage('trigger deploy to prod pipeline') {
    build(job: 'deploy_prod',
    parameters: [ string(name: 'PLUGIN_TAG_VERSION', value: "${params.PLUGIN_TAG_VERSION}") ])
  }
}
