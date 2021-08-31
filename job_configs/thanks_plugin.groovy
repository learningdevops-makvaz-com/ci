/* groovylint-disable-next-line CompileStatic */
pipelineJob('thanks_plugin') {
    authenticationToken('git-auth')
    definition {
      cpsScm {
        scm {
          github('danpaldev/thank-after-post-plugin', 'master', 'ssh')
          scriptPath('Jenkinsfile')
          }
      }
    }
}
//TODO -> Find how to use credentials in JobDSL (if possible) ?
