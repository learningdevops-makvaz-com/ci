// What's a pipelineJob in JobDsl?
  //Used to create and configure a job which is of type Pipeline


// https://jenkinsci.github.io/job-dsl-plugin/#path/pipelineJob
pipelineJob('first_job') {
    //Adds a workflow definition.
    definition {
      //Loads a pipeline script from SCM.
      cpsScm {
        scm {
          git('https://github.com/danpaldev/phase02_task04', 'master')
          scriptPath('jobs/first_job.jenkinsfile')
          }
      }
    }
    
    parameters {
      stringParam('git_url', 'https://github.com/danpaldev/phase02_task04.git', 'main repo url')
      stringParam('versionTag', 'v3','commit tag')

    }

}
