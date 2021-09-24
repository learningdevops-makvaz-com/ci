node()
{
  stage('Checkout to phase02_task02 repo') {
    checkout(scm: [
        $class: 'GitSCM',
        branches: [[name: '*/master']],
        userRemoteConfigs: [[
        url: params.git_url,
        credentialsId: 'git-auth'
        ]],
    ])
  }

  stage('deploy prod enivronment') {
    // 'run docker-compose in detached mode with provided version of wordpress image'
    sh "python3 yaml_modifier.py --prod docker-compose.yml danpaldev/wp-jenkins:${params.PLUGIN_TAG_VERSION}"
    sh 'docker-compose up -d'
    sh '''
      until docker container exec deploydev_database_1 mysql -P 3306 -u wp_user --password=wp_password --execute="SHOW DATABASES;" | grep "wordpress" ; do
        >&2 echo "MySQL is unavailable - waiting for it... 😴"
        sleep 3
      done
    '''
  }

}
