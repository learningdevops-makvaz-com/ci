node()
{

  stage('Checkout to phase02_task02 repo') {
    // TODO -> Checkout to phase02_task02 (Maybe I don't need to worry about git credentials
    // because I won't modify the repository, I will just use the files inside it to do docker stuff)
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
    // echo 'In this step you should checkout your repository from one of your previous tasks.
    // Build docker image for wordpress with tag = plugin version

    //Extracting minor version from the Tag to pass the arg to Dockefile
    currentTag = params.PLUGIN_TAG_VERSION
    tagChunks = currentTag.tokenize('.')
    strippedTagVersion = tagChunks[1] as int
    echo "Stripped Tag Version --> ${strippedTagVersion}"

    //Building docker image
    dockerfile = 'Dockerfile'
    wordpressImage = docker.build(
      "wp-jenkins:${params.PLUGIN_TAG_VERSION}",
      "--build-arg PLUGIN_VERSION=${strippedTagVersion} -f ${dockerfile} .")

    // TODO -> Create credential for docker hub in order to push the build image
    // docker.withRegistry('', dockerhubCredentials) {
      // wordpressImage.push("${params.PLUGIN_TAG_VERSION}")
    }
  }
  stage('deploy dev enivronment') {
    echo 'run docker-compose in detached mode with provided version of wordpress image'
    sh 'echo I am doing noting'
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
