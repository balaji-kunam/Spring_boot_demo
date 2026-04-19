pipeline {
agent any

```
environment {
    IMAGE_NAME = "balajikunamgari/springboot-demo:${BUILD_NUMBER}"
}

stages {

    stage('Build') {
        steps {
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
```

}
