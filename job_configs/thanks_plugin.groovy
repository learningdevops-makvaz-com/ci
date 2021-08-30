/* groovylint-disable-next-line CompileStatic */
pipelineJob('thanks_plugin') {
    definition {
      cpsScm {
        scm {
          github('danpaldev/thank-after-post-plugin', 'master', 'ssh')
          scriptPath('thanks_plugin.jenkinsfile')
          }
      }
    }
}
