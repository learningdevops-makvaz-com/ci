pipelineJob('deploy_dev') {
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
      scriptPath('jobs/deploy_dev2.groovy')
    }
  }
  parameters {
    stringParam('plugin_version', 'v0.10.0', 'thank-after-post plugin version. Got from git tag.')
    stringParam('git_url', 'https://github.com/korney4eg/thank-after-post-plugin/', 'thank-after-post plugin repo url')
  }
}
