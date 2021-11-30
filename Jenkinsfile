pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building the project'
            }
        }
        stage('Unit tests') {
            steps {
                echo 'Running unit tests'
            }
        }
        stage('Integration tests') {
            steps {
                echo 'Running Integration tests'
            }
        }
        stage('Package') {
            steps {
                echo 'Packaging the project'
            }
        }
        stage('Deploy env 1') {
            steps {
                echo 'Deploying to env 1'
            }
        }
        stage('API tests') {
            steps {
                echo 'Running Api Tests'
            }
        }
        stage('UI tests') {
            steps {
                sh 'mvn clean test'
            }
        }
        stage('Deploy env 2') {
            steps {
                echo 'Deploying to env 2'
            }
        }
    }
}

