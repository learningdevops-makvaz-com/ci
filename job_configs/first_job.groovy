
pipelineJob('first_job') {
    definition {
        cpsScm {
	    scm{
	      git('https://github.com/danpaldev/phase02_task04', 'master')
	      scriptPath('jobs/first_job.groovy')
	    }
        }
    }
    parameters{
      stringParam('git_url', 'https://github.com/danpaldev/thank-after-post-plugin', 'thank-after-post plugin repo url')
      stringParam('plugin_version', 'v0.10.0', 'thank-after-post plugin version. Got from git tag.')    }
}
