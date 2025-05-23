pipeline {
    agent any

    tools {
        maven 'Maven'
        jdk 'JDK'
    }

    environment {
        ALLURE_RESULTS = 'target/allure-results'
    }
    triggers {
        githubPush()
    }

    stages {
        stage('Checkout') {
            steps {
                git credentialsId: '3c28bc63-a8d3-4bd6-9efd-9362c96a1480', url: 'https://github.com/fundorin94/bddtry.git', branch: 'main'
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean test'
            }
        }

        stage('Build & Test') {
            steps {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    bat 'mvn clean test'
                }
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'target/surefire-reports/*.xml', allowEmptyArchive: true
        }
    }
}
