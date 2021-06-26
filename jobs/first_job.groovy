OK="ahjdklaeijdks"
def lastCommiterEmail = sh(returnStdout: true, script: 'git log --format="%ae" | head -1').trim()

node()
{
  stage('Probando probando'){
    echo OK 
    // git branch: master
    //   credentialsId: 
    //   url: params.git_url
    // sh(returnStdout: true, script: "git tag --sort version:refname | tail -1").trim()
    git url: params.git_url
    sh "echo ${WORKSPACE}"
    // lastCommiterEmail
  }
}
