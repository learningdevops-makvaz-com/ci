pipelineJob('job-dsl-artifactory-pipeline-example') {
    parameters {
        stringParam('SERVER_ID', 'default server id', '')
    }

    definition {
        cps {
            script('''
	    node()
	    {
	      sh 'echo hello world!'
	    }
	    ''')
            sandbox()
        }
    }
}
