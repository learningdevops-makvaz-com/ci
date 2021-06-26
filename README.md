## What is Jenkins Pipeline?

Jenkins Pipeline (or simply "Pipeline" with a capital "P") is a **suite of plugins** which supports implementing and integrating continuous delivery pipelines into Jenkins.

Pipeline provides an extensible set of tools **for modeling simple-to-complex delivery pipelines "as code" via the Pipeline domain-specific language (DSL) syntax.** 
[Source](https://www.jenkins.io/doc/book/pipeline/)

[See Docs for Pipeline DSL syntax](https://www.jenkins.io/doc/book/pipeline/syntax/)

---


## What's a JobDSL Script?

A Job DSL script consists of API methods provided by the Job DSL plugin; you can use these **API methods to configure different aspects of a job.**

[Source](https://www.digitalocean.com/community/tutorials/how-to-automate-jenkins-job-configuration-using-job-dsl)

---

## What's a Seed Job

The seed job is a **normal Jenkins job that runs the Job DSL script;** in turn, the script contains instructions that create additional jobs. **In short, the seed job is a job that creates more jobs.** In this step, you will construct a Job DSL script and incorporate it into a seed job. The Job DSL script that you’ll define will create a single freestyle job that prints a 'Hello World!' message in the job’s console output.

[Source](https://www.digitalocean.com/community/tutorials/how-to-automate-jenkins-job-configuration-using-job-dsl)

---
## JobDSL Plugin Vs Pipeline Plugin

**Job DSL Plugin** was Netflix's open source solution for Jenkins CasC. 

However, **Jenkins Pipeline (2.0) Plugin** is a new incarnation of a Jenkins job, entirely based on a DSL as well, that <ins> eliminate the need to stitch together multiple jobs to fill a single pipeline </ins> which was by far the most common use of Job DSL.

Today, **Job DSL** is not as popular because **Pipeline** is the Jenkins-supported mechanism for scripting Jenkins pipelines and it has met or surpassed much of the functionality of Job DSL. Even more, new plugins are being developed natively for Pipeline.

#### Pipeline Plugin advantages over JobDSL

  * There is **no need to "seed" jobs** using Pipeline as there is with Job DSL since the Pipeline is the job itself. With Job DSL, it's just a script that creates other jobs.

  * With Pipeline, you have features such as a parameterized manual input step, allowing you specify logic midstream within the pipeline

  * The logic that can be included in a **Job DSL is limited to creating the jobs** themselves ; whereas with **Pipeline you can include logic directly inside the job.**

  * Smaller syntax.

[Source](https://stackoverflow.com/a/39214771/13954598)

## When (and how) to use BOTH?
Pipeline is the new native Jenkins feature to have jobs as code. However, if building Jenkins from scratch, those **jobs still need to be created**. This means <ins> Jenkins [natively] can't be 100% truly scripted and built from code. </ins>

What you can do is **use Job DSL to build the skeleton structure of all the jobs, then use pipeline for the implementation of the jobs.** This will allow you to 100% script Jenkins, minus the initial seed job to be created.

Maybe, eventually we will be able to use pipeline to fully control Jenkins (security, configuration and even plugins). But until then, is a good approach to use DSL and Pipeline.

[Source](https://stackoverflow.com/a/44832942/13954598)

[Visit this link to see examples of using JobDSL + Pipeline job ](https://stackoverflow.com/a/40468185/13954598)



