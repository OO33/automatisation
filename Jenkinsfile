node {

    stage 'Checkout'
    checkout scm

    stage('Clean') {
        bat 'gradlew clean'
    }


    stage('Test') {
            bat 'gradlew test'
    }
}

