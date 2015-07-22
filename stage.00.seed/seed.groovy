job('scpartner-jdsl-test'){
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