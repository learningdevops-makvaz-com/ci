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
	  url: params.GIT_URL,
	  ],
	  ],
      ])
  }
  stage('count number of sudo commands') {
    sh 'ls -l'
  }
}
