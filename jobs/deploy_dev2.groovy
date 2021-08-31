node()
{
  stage('debugging') {
    echo 'I work!'
    echo '${params.demo}'
  }
}
