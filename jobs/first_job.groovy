// @Field def OK = "Hola a todos"
LATEST_TAG = sh(returnStdout: true, script: "git tag --sort version:refname | tail -1").trim()
// def bar = "Hola Mundo"

node()
{
  //   stage("Checkout repository") {
  //   checkout(scm: [
  //       $class: 'GitSCM',
  //       branches: [
  //       [name: "refs/tags/${params.plugin_version}"],],
  //       userRemoteConfigs: [
  //       [
  //       url: params.git_url,
  //       ],
  //       ],
  //   ])
  // }
  
  stage('Probando probando'){
    echo LATEST_TAG  
  }
}
