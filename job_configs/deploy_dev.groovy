pipelineJob('deploy_dev') {
  definition {
    cpsScm {
      scm{
	      git('https://github.com/danpaldev/phase02_task04', 'master')
	      scriptPath('jobs/deploy_dev.groovy')
      }
    }
  }
  parameters {
    stringParam('plugin_version', 'v0.10.0', 'thank-after-post plugin version. Got from git tag.')
    stringParam('git_url', 'https://github.com/korney4eg/thank-after-post-plugin/', 'thank-after-post plugin repo url')
  }
}
