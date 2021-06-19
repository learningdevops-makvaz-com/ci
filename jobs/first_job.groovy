OK="ahjdklaeijdks"
node()
{
  stage('Probando probando'){
    echo OK 
    sh(returnStdout: true, script: "git tag --sort version:refname | tail -1").trim()
  }
}
