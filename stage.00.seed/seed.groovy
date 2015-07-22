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

        downstreamParameterized("${projectName}-02-componenttest") {
            currentBuild()
        }
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
    selectedJob("${projectName}-01-compile")
    showPipelineParameters()
}