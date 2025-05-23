@Library('jenkins-shared-library')_
def gv

pipeline {
    agent any
    tools {
        maven "maven 3.9.9"
    }
    environment {
        IMAGE_NAME = "shivakumarreddy1/demo-app:jma-4.0"
        AWS_HOST = "ec2-user@ec2-13-203-223-210.ap-south-1.compute.amazonaws.com"
    }
    stages {
        stage ("test") {
            steps {
                script {
                    echo "Testing the branch"
                    echo "Current branch is $BRANCH_NAME"
                }
            }
        }
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("build jar") {
            
            steps {
                script {
                    echo "building jar"
                    buildJar()
                    //gv.buildJar()
                }
            }
        }
        stage("build image") {
            
            steps {
                script {
                    echo "building image"
                    buildImage(env.IMAGE_NAME)
                    //gv.buildImage()
                }
            }
        }
        stage("deploy") {
            
            steps {
                script {
                    
                    echo "deploying"
                    //def dockerCmd = "docker run -d -p3000:3080 shivakumarreddy1/demo-app:react-nodejs"
                    def dockerComposeCmd = "docker-compose -f docker-compose.yaml up -d"
                    sshagent(['awskey']) {
                        // def host = AWS_HOST.split('@')[1]
                    
                        // // Add EC2 host key to Jenkins container's known_hosts
                        // sh "mkdir -p ~/.ssh && ssh-keyscan -H ${host} >> ~/.ssh/known_hosts"
                        // sh "scp docker-compose.yaml ${AWS_HOST}:/home/ec2-user"
                        // sh "ssh -o StrictHostKeyChecking=no ${AWS_HOST} ${dockerComposeCmd}"
                        sh "ssh -o StrictHostKeyChecking=no ${AWS_HOST} docker-compose --version"
                    }
                    //gv.deployApp()
                }
            }
        }
    }   
}
