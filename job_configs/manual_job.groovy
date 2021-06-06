pipelineJob('manual_job') {
    definition {
        cpsScm {
	    scm{
	      git('https://github.com/learningdevops-makvaz-com/ci/', 'master')
	      scriptPath('jobs/manual_job.groovy')
	    }
        }
    }
}
