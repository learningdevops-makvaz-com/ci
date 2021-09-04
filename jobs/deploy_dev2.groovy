node()
{
  stage('debugging') {
    echo 'I work!'
    echo "${params.TAG_VERSION}"
    // TODO -> Learn how to read environment variables (from .env file?) in order to do this task
      // It seems that I have to pass env values to docker!
  }
}
