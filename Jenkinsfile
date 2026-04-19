pipeline {
    agent any

    environment {
        IMAGE_NAME = "kunambalu/springboot-demo:${BUILD_NUMBER}"
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                url: 'https://github.com/balaji-kunam/Spring_boot_demo.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Docker Build') {
            steps {
                bat 'docker build -t %IMAGE_NAME% .'
            }
        }

        stage('Docker Push') {
            steps {
                bat 'docker push %IMAGE_NAME%'
            }
        }

        stage('Deploy Kubernetes') {
            steps {
                bat 'kubectl set image deployment/springboot-demo springboot-demo=%IMAGE_NAME%'
            }
        }
    }
}