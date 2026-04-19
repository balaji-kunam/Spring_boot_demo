pipeline {
agent any


tools {
    jdk 'jdk21'
    maven 'maven3'
}

environment {
    IMAGE_NAME = "balajikunamgari/springboot-demo:${BUILD_NUMBER}"
}

stages {

    stage('Build') {
        steps {
            sh 'java -version'
            sh 'echo JAVA_HOME=$JAVA_HOME'
            sh 'which java || true'
            sh 'which javac || true'
            sh 'java -version'
            sh 'javac -version'
            sh 'mvn -version'
            sh 'mvn clean package'
        }
    }

    stage('Test') {
        steps {
            sh 'mvn test'
        }
    }

    stage('Docker Build') {
        steps {
            sh 'docker build -t $IMAGE_NAME .'
        }
    }

    stage('Docker Push') {
        steps {
            sh 'docker push $IMAGE_NAME'
        }
    }

    stage('Deploy Kubernetes') {
        steps {
            sh 'kubectl set image deployment/springboot-demo springboot-demo=$IMAGE_NAME'
        }
    }
}


}
