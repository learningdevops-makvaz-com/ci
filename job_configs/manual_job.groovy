pipelineJob('manual_job') {
    definition {
        cpsScm {
	    scm{
	      git('https://github.com/learningdevops-makvaz-com/ci/', 'master')
	      // git('github.com/learningdevops-makvaz-com/phase01_task03', 'master)
	      scriptPath('jobs/manual_job.groovy')
	    }
        }
    }
}
