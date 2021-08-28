pipelineJob('thanks_plugin') {
    definition {
      cpsScm {
        scm {
          git('https://github.com/danpaldev/phase02_task04', 'master')
          scriptPath('jobs/thanks_plugin.jenkinsfile')
          }
      }
    }
    
    parameters {
      stringParam('git_url', 'git@github.com:danpaldev/thank-after-post-plugin.git', 'main repo url')
    }
}
