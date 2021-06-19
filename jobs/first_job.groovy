OK="ahjdklaeijdks"
node()
{
  stage('Probando probando'){
    echo OK 
    git url: params.git_url
    sh(returnStdout: true, script: "git tag --sort version:refname | tail -1").trim()
  }
}
