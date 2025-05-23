@Library('jenkins-shared-library')_
def gv

pipeline {
    agent any
    tools {
        maven "maven 3.9.9"
    }
    environment {
        IMAGE_NAME = "shivakumarreddy1/demo-app:jma-4.0"
        AWS_HOST = "ec2-user@ec2-35-154-211-37.ap-south-1.compute.amazonaws.com"
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
                    def dockerCmd = "docker run -d -p8080:8080 ${IMAGE_NAME}"
                    deployAWS(env.AWS_HOST, dockerCmd)
                    // sshagent(['awskey']) {
                    //     sh "ssh -o StrictHostKeyChecking=no ${AWS_HOST} ${dockerCmd}"
                    // }
                    //gv.deployApp()
                }
            }
        }
    }   
}
