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
    sh 'docker container stop deploydev_wordpress_1 && docker container rm deploydev_wordpress_1'
    sh 'docker container stop deploydev_database_1 && docker container rm deploydev_database_1'
    // 'run docker-compose in detached mode with provided version of wordpress image'
    sh "python3 yaml_modifier.py docker-compose.yml danpaldev/wp-jenkins:${params.PLUGIN_TAG_VERSION}"
    sh 'docker-compose up -d'
    sh '''
      until docker container exec deploydev_database_1 mysql -P 3306 -u wp_user --password=wp_password --execute="SHOW DATABASES;" | grep "wordpress" ; do
        >&2 echo "MySQL is unavailable - waiting for it... 😴"
        sleep 3
      done
    '''
  }

  stage('testing') {
    echo 'run test container that you created on task02 phase 02 to check that your wordpress is running correctly and pluin is set to actual version'
    sh 'echo I am doing noting'
  }
  stage('destroy dev enivronment') {
    echo 'make docker-compose to stop and clean up after it'
    sh 'echo I am doing noting'
  }
  stage('trigger deploy to prod pipeline') {
    echo 'Here you need to trigger pipeline "deploy_prod" and path name of the image to docker-compose'
    sh 'echo I am doing noting'
  }
}
