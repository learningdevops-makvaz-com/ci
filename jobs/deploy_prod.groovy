node()
{
  stage('Trying job') {
    echo "${params.PLUGIN_TAG_VERSION}"
    sh 'cat docker-compose.yml'
    //TODO-> Create .prod.env with the prod url: localhost:81,
    //TODO-> Create Py Script that swaps port 80 for 81 in compose file.
      // I could modify the existing one that accepts a flag --production, and auto-swapping the port
  }
}
