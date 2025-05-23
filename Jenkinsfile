def gv

pipeline {
    agent any
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
                    //gv.buildJar()
                }
            }
        }
        stage("build image") {
            
            steps {
                script {
                    echo "building image"
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
                        sh "ssh docker-compose.yaml ec2-user@ec2-35-154-211-37.ap-south-1.compute.amazonaws.com:/home/ec2-user"
                        sh "ssh -o StrictHostKeyChecking=no ec2-user@ec2-35-154-211-37.ap-south-1.compute.amazonaws.com ${dockerComposeCmd}"
                    }
                    //gv.deployApp()
                }
            }
        }
    }   
}
