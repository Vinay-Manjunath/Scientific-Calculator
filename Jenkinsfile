pipeline {
    agent any

    environment {
        DOCKER_IMAGE_NAME = 'scientific-calculator'
        GITHUB_REPO_URL = 'https://github.com/Vinay-Manjunath/Scientific-Calculator.git'
        DOCKER_HUB_USERNAME = 'vinayksm86'
    }

    stages {

        stage('Clone Git') {
            steps {
                git branch: 'master',
                    credentialsId: 'github_credentials',
                    url: "${GITHUB_REPO_URL}"
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
                ansiblePlaybook(
                    playbook: 'deploy.yml',
                    inventory: 'inventory.ini'
                )
            }
        }
    }

    post {

        success {
            emailext(
                subject: "Jenkins Build SUCCESS - ${JOB_NAME} #${BUILD_NUMBER}",
                body: """
Jenkins pipeline completed successfully.

Job Name: ${JOB_NAME}
Build Number: ${BUILD_NUMBER}

View Build Details:
${BUILD_URL}
""",
                to: "vinayksm86@gmail.com"
            )
        }

        failure {
            emailext(
                subject: "Jenkins Build FAILURE - ${JOB_NAME} #${BUILD_NUMBER}",
                body: """
Jenkins pipeline has failed.

Job Name: ${JOB_NAME}
Build Number: ${BUILD_NUMBER}

Check Logs:
${BUILD_URL}

""",
                to: "vinayksm86@gmail.com"
            )
        }
    }
}
