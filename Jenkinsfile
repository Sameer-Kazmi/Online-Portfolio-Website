pipeline {
 
    agent any
 
    tools {
        jdk 'JDK25'
        maven 'Maven 3.9.16'
    }
 
    environment {
        IMAGE_NAME = "onlineportfolio"
        IMAGE_TAG = "v1"
    }
 
    stages {
 
        stage('Checkout Source Code') {
            steps {
                echo "Checking out source code from GitHub..."
                // Links directly to your repository matching step 38
                git branch: 'main', url: 'git@github.com:Sameer-Kazmi/Online-Portfolio-Website.git'
            }
        }
 
        stage('Verify Tools') {
            steps {
                echo "Verifying Java..."
                sh 'java -version'
 
                echo "Verifying Maven..."
                sh 'mvn -version'
 
                echo "Verifying Docker..."
                sh 'docker --version'
 
                echo "Verifying Kubernetes..."
                sh 'kubectl version --client'
            }
        }
 
        stage('Clean Project') {
            steps {
                echo "Cleaning project..."
                sh 'mvn clean'
            }
        }
 
        stage('Compile Project') {
            steps {
                echo "Compiling project..."
                sh 'mvn compile'
            }
        }
 
        stage('Run Unit Tests') {
            steps {
                echo "Running unit tests..."
                sh 'mvn test'
            }
        }
 
        stage('Package Application') {
            steps {
                echo "Packaging Spring Boot application..."
                sh 'mvn package'
            }
        }
 
        stage('Build Docker Image') {
            steps {
                echo "Building Docker image..."
                // Swapped to Mac/Linux variable syntax parsing
                sh 'docker build -t ${IMAGE_NAME}:${IMAGE_TAG} .'
            }
        }
 
        stage('List Docker Images') {
            steps {
                echo "Available Docker Images"
                sh 'docker images'
            }
        }
 
        stage('Deploy to Kubernetes') {
            steps {
                echo "Deploying application to Kubernetes..."
                sh 'kubectl apply -f k8s/deployment.yaml'
                sh 'kubectl apply -f k8s/service.yaml'
            }
        }
 
        stage('Verify Deployment') {
            steps {
                echo "Checking Deployment..."
                // Pointed explicitly to your portfolio deployment name
                sh 'kubectl rollout status deployment/onlineportfolio-deployment'
 
                sh 'kubectl get deployments'
                sh 'kubectl get pods'
                sh 'kubectl get svc'
            }
        }
 
    }
 
    post {
        always {
            echo "Pipeline Finished."
        }
        success {
            echo "======================================="
            echo "BUILD SUCCESSFUL"
            echo "Application Deployed Successfully"
            echo "======================================="
        }
        failure {
            echo "======================================="
            echo "BUILD FAILED"
            echo "Check Jenkins Console Output"
            echo "======================================="
        }
    }
}