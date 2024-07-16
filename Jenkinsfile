pipeline {
    agent any

    tools {
        gradle 'Gradle 7'  // Este nombre debe coincidir con el nombre que le diste a la instalación de Gradle en Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build') {
            steps {
                script {
                    // Usa el comando gradle para construir tu proyecto
                    bat './gradlew clean build'
                }
            }
        }
    }
}




