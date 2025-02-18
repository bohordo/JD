pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'dev', url: 'https://github.com/bohordo/JD.git'
            }
        }
        
        stage('Build Docker Image') {
            steps {
                sh 'docker-compose build'
            }
        }
        
        stage('Deploy') {
            steps {
                sh 'docker-compose down'
                sh 'docker-compose up -d'
            }
        }
    }

    post {
        success {
            echo '¡Deployment successful!'
        }
        failure {
            echo 'There was an error in the deployment.'
        }
    }
}
