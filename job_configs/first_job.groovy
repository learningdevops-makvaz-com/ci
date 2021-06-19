pipelineJob('first_job') {
    definition {
        cpsScm {
	    scm{
	      git('https://github.com/danpaldev/phase02_task04', 'master')
	      scriptPath('jobs/first_job.groovy')
	    }
        }
    }
}
