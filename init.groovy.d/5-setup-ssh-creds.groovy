/*
 * Install ssh key (in /usr/share/jenkins/keys/$SEED_CREDS_ID).
 */
import jenkins.model.*
import com.cloudbees.plugins.credentials.*
import com.cloudbees.plugins.credentials.common.*
import com.cloudbees.plugins.credentials.domains.*
import com.cloudbees.plugins.credentials.impl.*
import com.cloudbees.jenkins.plugins.sshcredentials.impl.*

println '--> setting ssh creds'


println '@@@@@@@ Creating Git Credentials @@@@@@@'

    global_domain = Domain.global()

    credentialsStore =
    Jenkins.instance.getExtensionList(
    'com.cloudbees.plugins.credentials.SystemCredentialsProvider'
    )[0].getStore()

    id = 'git-auth'
    username = 'admin'
    passphrase = ''
    privateKey = '/usr/share/jenkins/keys/git_ssh_private_key'
    keySource = new BasicSSHUserPrivateKey.FileOnMasterPrivateKeySource(privateKey)
    description = ''

    privateKeyFile = new File(privateKey)

    if (!privateKeyFile.exists()) {
      println 'WARNING: ' + privateKey + " doesn't exist"
    }

   credentials = new BasicSSHUserPrivateKey(
      CredentialsScope.GLOBAL,
      id,
      username,
      keySource,
      passphrase,
      description
      )

    credentialsStore.addCredentials(global_domain, credentials)


println '%%%%%%% Creating DockerHub Credentials %%%%%%%'

    id_docker = 'dockerhub-auth'
    description_docker = 'Username and Password for Dockerhub'
    username_docker = System.getenv('DOCKERHUB_USER')
    password_docker = System.getenv('DOCKERHUB_PASS')

    /* groovylint-disable-next-line BrokenNullCheck, UnnecessaryGetter */
    if (password_docker == null && password_docker.isEmpty()) {
      println 'WARNING: No credentials for DockerHub were provided'
    }

    dockerCredentials = new UsernamePasswordCredentialsImpl(
      CredentialsScope.GLOBAL,
      id_docker,
      description_docker,
      username_docker,
      password_docker,
      )

    credentialsStore.addCredentials(global_domain, dockerCredentials)

