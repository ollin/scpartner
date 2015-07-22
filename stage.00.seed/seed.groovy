job('scpartner-jdsl-test'){
    scm {
        github('ollin/scpartner')
    }
    triggers {
        scm('*/15 * * * *')
    }
    steps {
        gradle('tasks')
    }
}