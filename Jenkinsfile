@Library('jenkins-shared-library')_
def gv

pipeline {
    agent any
    tools {
        maven "maven 3.9.9"
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
                    buildImage()
                    //gv.buildImage()
                }
            }
        }
        stage("deploy") {
            
            steps {
                script {
                    echo "deploying"
                    //gv.deployApp()
                }
            }
        }
    }   
}
