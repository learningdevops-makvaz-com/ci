pipelineJob('deploy_dev') {
  definition {
    cpsScm {
      scm{
	git('https://github.com/learningdevops-makvaz-com/ci/', 'master')
	  scriptPath('jobs/deploy_dev.groovy')
      }
    }
  }
  parameters {
    gitParam('plugin_version'){
      description('version of thank-after-post plugin. Get from git tags')
	sortMode('DESCENDING_SMART')
	type('TAG')
    }
  }
}
