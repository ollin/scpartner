def projectName = 'scpartner'


job("${projectName}-01-compile"){
    scm {
        git {
            remote {
                github 'ollin/scpartner'
            }
            createTag false
        }
    }
    triggers {
        scm('*/15 * * * *')
    }
    steps {
        gradle('build')
    }
    publishers {
        buildPipelineTrigger("${projectName}-02-componenttest")
    }
}

job("${projectName}-02-componenttest"){
    scm {
        git {
            remote {
                github 'ollin/scpartner'
            }
            createTag false
        }
    }
    triggers {
        scm('*/15 * * * *')
    }
    steps {
        gradle('tasks')
    }
}

buildPipelineView('scpartner-pl') {
    title('scpartner - Pipeline')
    selectedJob('scpartner-jdsl-test')
    showPipelineParameters()
}