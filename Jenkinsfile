pipeline {
    agent any

    node {
        checkout scm

        stages {
                stage('Test') {
                    /* `make check` returns non-zero on test failures,
                    * using `true` to allow the Pipeline to continue nonetheless
                    */
                    bat './gradlew.bat clean'
                }


                stage('Test') {
                        /* `make check` returns non-zero on test failures,
                        * using `true` to allow the Pipeline to continue nonetheless
                        */
                        bat './gradlew.bat test'
                }
            }
    }

}