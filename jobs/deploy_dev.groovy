node()
{
  stage("Checkout repository") {
    checkout(scm: [
        $class: 'GitSCM',
        branches: [
        [name: "refs/tags/${params.plugin_version}"],],
        userRemoteConfigs: [
        [
        url: params.git_url,
        ],
        ],
    ])
  }
  stage('build_wp_image') {
    echo 'In this step you should checkout your repository from one of your previous tasks. Build docker image for wordpress with tag = plugin version. Plugin should be downloaded `git_url` repo.'
    sh 'echo I am doing noting'
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
