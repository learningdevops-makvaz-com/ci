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

