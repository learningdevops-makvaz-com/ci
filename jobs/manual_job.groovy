pipelineJob('manual_job') {
    definition {
        cps {
            script('''
	    node(){
	      sh 'echo hello world'
	    }
	    ''')
            sandbox()
        }
    }
}
