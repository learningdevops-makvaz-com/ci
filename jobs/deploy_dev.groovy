node()
{
  // stage('Checkout repository') {
  //   git url: 'https://github.com/korney4eg/thank-after-post-plugin/'

  // }
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
  stage('build wordpress image with needed version of plugin') {
    echo 'In this step you should checkout your repository from task 02 phase 02. Build docker image for wordpress with tag = plugin version. '
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
