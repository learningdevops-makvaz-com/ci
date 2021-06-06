node()
{
    stage('Checkout repository') {
      scmVars = checkout scm
    }
    stage('count number of sudo commands') {
        sh 'ls -l'
    }
}
