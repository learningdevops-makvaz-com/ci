pipelineJob('manual_job') {
    definition {
        cps {
            script(readFileFromWorkspace('jobs/manual_job.groovy'))
            sandbox()
        }
    }
}
