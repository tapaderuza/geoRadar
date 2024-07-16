pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build') {
            steps {
                script {
                    def gradleHome = tool name: 'Gradle 7', type: 'Gradle'
                    sh "${gradleHome}/bin/gradle clean build"
                }
            }
        }
    }
}



