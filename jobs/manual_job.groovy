pipelineJob('manual_job') {
    definition {
        cps {
            script('''
	    node(){
	      sh 'hello'
	    }
	    ''')
            sandbox()
        }
    }
}
