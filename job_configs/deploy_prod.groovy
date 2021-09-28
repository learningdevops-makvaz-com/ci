pipelineJob('deploy_prod') {
  definition {
    cpsScm {
      scm {
        git {
          remote {
            github('danpaldev/phase02_task04', 'ssh')
            credentials('git-auth')
          }
        }
      }
      scriptPath('jobs/deploy_prod.groovy')
    }
  }
  parameters {
    stringParam('git_url', 'git@github.com:danpaldev/phase02_task02.git', 'task02 ssh repo')
  }
}
