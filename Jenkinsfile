pipeline {
    agent any
    tools {
        maven "maven 3.9.9"
    }
    stages {
        stage('build jar') {
            steps {
                script {
                    echo "Building the application..."
                    sh "mvn package"
                }
            }
        }
        stage('build image') {
            steps {
                script {
                    echo "building the application..."
                    withCredentials([usernamePassword(credentialId: 'dockerhub-repo', usernameVariable: "USER", passwordVariable: "PASS")]) {
                        sh "docker build -t shivakumarreddy1/demo-app:jma-2.0 ."
                        sh "echo $PASS | docker -login -u $USER --password-stdin"
                        sh "doker push shivakumarreddy1/demo-app:jam-2.0"
                    }
                }
            }
        }
        stage('deploy') {
            steps {
                script {
                    echo "Deploying the application..."
                }
            }
        }
    }
}
