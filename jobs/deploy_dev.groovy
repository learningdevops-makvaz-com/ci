node()
{
  // stage('Checkout repository') {
  //   git url: 'https://github.com/korney4eg/thank-after-post-plugin/'

  // }
  stage("Checkout repository") {
    steps {
      checkout(scm: [
	  $class: 'GitSCM',
	  branches: [
	  [name: "refs/tags/${params.GIT_BRANCH}"],
	  ],
	  userRemoteConfigs: [
	  [
	  url: params.GIT_URL,
	  ],
	  ],
      ])
    }
  }
  stage('count number of sudo commands') {
    sh 'ls -l'
  }
}
