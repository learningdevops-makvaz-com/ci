node()
{
    stage('Checkout repository') {
      dir('scripts') {
	scmVars = checkout scm
      }
      dir('code') {
	git url: 'github.com/learningdevops-makvaz-com/phase01_task03'
      }
    }
    stage('count number of sudo commands') {
        sh 'grep sudo setup_wordpress.sh'
    }
}
