pipeline{
    agent any
    environment {
        DOCKER_IMAGE_NAME = 'scientific-calculator'
        GITHUB_REPO_URL = 'https://github.com/Vinay-Manjunath/Scientific-Calculator.git'
        DOCKER_HUB_USERNAME = 'vinayksm86'
    }

    stages {
        stage('Clone Git') {
            steps {
                script {
                    git branch: 'master',
                        credentialsId: 'github_credentials',
                        url: "${GITHUB_REPO_URL}"
                }
            }
        }

        stage('Build the Maven Project') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Test the Maven project') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Verify JAR Existence') {
            steps {
                sh 'ls -lh target/'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh "docker build -t ${DOCKER_IMAGE_NAME} ."
            }
        }
        
        stage('Push Docker Image to Docker Hub') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub-creds',
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
                )]) {
        
                    sh """
                        docker tag ${DOCKER_IMAGE_NAME} ${DOCKER_USER}/${DOCKER_IMAGE_NAME}:latest
                        echo \$DOCKER_PASS | docker login -u \$DOCKER_USER --password-stdin
                        docker push ${DOCKER_USER}/${DOCKER_IMAGE_NAME}:latest
                    """
                }
            }
        }

        stage('Deploy with Ansible') {
            steps {
                script {
                    ansiblePlaybook(
                        playbook: 'deploy.yml',
                        inventory: 'inventory'
                    )
                }
            }
        }
    }
}
