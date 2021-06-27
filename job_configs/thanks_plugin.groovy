pipelineJob('thanks_plugin') {
    definition {
      cpsScm {
        scm {
           git('https://github.com/danpaldev/thank-after-post-plugin', 'master')
           scriptPath('Jenkinsfile')
          }
      }
    }
    
    parameters {
      stringParam('git_url', 'https://github.com/danpaldev/thank-after-post-plugin', 'main repo url')
    }
}
