pipelineJob('manual_job') {

    description('Job that would be driggered manually')

    // triggers {
    //     githubPush()
    // }

    definition {
        cps {
            properties {
                githubProjectUrl('https://github.com/learningdevops-makvaz-com/ci')
            }

            logRotator {
                numToKeep(20)
                daysToKeep(30)
            }

            scm {
                git {
                    remote {
                        url('https://github.com/learningdevops-makvaz-com/ci')
                        // credentials('public')
                    }
                    branches('*/master')
                }
            }

            sandbox()
            script('''
            sh ' ls -l' 
            ''')
        }
 
}
