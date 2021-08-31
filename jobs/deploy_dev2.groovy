node()
{
  stage('debugging') {
    echo 'I work!'
    echo "${params.tag_version}"
  }
}
