job('scpartner-jdsl-test'){
    scm {
        git {
            remote {
                github 'ollin/scpartner'
            }
            ignoreNotifyCommit true
        }
    }
    triggers {
        scm('*/15 * * * *')
    }
    steps {
        gradle('tasks')
    }
}