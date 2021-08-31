node()
{
  stage('debugging') {
    echo 'I work!'
    echo "${params.TAG_VERSION}"
  }
}
