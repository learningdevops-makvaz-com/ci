pipelineJob('manual_job') {
    definition {
        cpsScm {
	    scm(
	      git(env.SEED_JOBS_URL, 'master)
	      // git('github.com/learningdevops-makvaz-com/phase01_task03', 'master)
	    )
            scriptPath('jobs/manual_job.groovy')
        }
    }
}
