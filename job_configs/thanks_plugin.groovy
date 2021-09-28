/* groovylint-disable-next-line CompileStatic */
pipelineJob('thanks_plugin') {
    definition {
      cpsScm {
        scm {
          git {
            remote {
              github('danpaldev/thank-after-post-plugin', 'ssh')
              credentials('git-auth')
            }
          }
        }
        scriptPath('thanks_plugin.jenkinsfile')
      }
    }
}
