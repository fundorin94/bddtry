pipeline {
    agent any

    tools {
        maven 'Maven 3.9.6'   // Имя Maven в Jenkins (настраивается в Global Tool Configuration)
        jdk 'JDK 17'          // Имя JDK, установленного в Jenkins
    }

    environment {
        ALLURE_RESULTS = 'target/allure-results'
        ALLURE_REPORT = 'allure-report'
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

        stage('Allure Report') {
            steps {
                allure includeProperties: false, jdk: '', results: [[path: "${env.ALLURE_RESULTS}"]]
            }
        }
    }


    }
}
