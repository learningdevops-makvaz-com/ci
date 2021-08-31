/* groovylint-disable-next-line CompileStatic */
pipelineJob('thanks_plugin') {
    definition {
      cpsScm {
        scm {
          github('danpaldev/thank-after-post-plugin', 'master', 'ssh')
          credentials('git-auth')
          scriptPath('Jenkinsfile')
          }
      }
    }
}
//TODO -> Find how to use credentials in JobDSL (if possible) ?
