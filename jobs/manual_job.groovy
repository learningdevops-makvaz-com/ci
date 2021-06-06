node()
{
    stage('Checkout repository') {
      git url: 'github.com/learningdevops-makvaz-com/phase01_task03'
    }
    stage('count number of sudo commands') {
        sh 'grep sudo setup_wordpress.sh'
    }
}
