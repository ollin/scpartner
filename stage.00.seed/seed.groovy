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

        downstreamParameterized {
            trigger("${projectName}-02-componenttest", '') {
                predefinedProp('GIT_COMMIT', '$GIT_COMMIT')
                predefinedProp('ARTIFACT_BUILD_NUMBER', '$BUILD_NUMBER')

                currentBuild()
            }
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

nestedView("${projectName}") {
    views {
        listView("${projectName}-overview") {
            jobs {
                regex("${projectName}-.*")
            }
            columns {
                status()
                weather()
                name()
                lastSuccess()
                lastFailure()
            }
        }
        buildPipelineView('scpartner-pipeline') {
            title('scpartner - Pipeline')
            selectedJob("${projectName}-01-compile")
            showPipelineParameters()
        }
    }
}

