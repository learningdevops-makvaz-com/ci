pipelineJob('job-dsl-artifactory-pipeline-example') {
    parameters {
        stringParam('SERVER_ID', 'default server id', '')
    }

    definition {
        cps {
            script(readFileFromWorkspace('jenkins-examples/pipeline-examples/scripted-examples/declarative-example/Jenkinsfile'))
            sandbox()
        }
    }
}
