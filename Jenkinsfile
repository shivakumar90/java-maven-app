def gv

pipeline {
    agent any
    stages {
        // stage ("test") {
        //     steps {
        //         script {
        //             echo "Testing the branch"
        //             echo "Current branch is $BRANCH_NAME"
        //         }
        //     }
        // }
        stage("init") {
            // when {
            //     expression {
            //         BRANCH_NAME == "main"
            //     }
            // }
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("build jar") {
            // when {
            //     expression {
            //         BRANCH_NAME == "main"
            //     }
            // }
            steps {
                script {
                    echo "building jar"
                    //gv.buildJar()
                }
            }
        }
        stage("build image") {
            // when {
            //     expression {
            //         BRANCH_NAME == "main"
            //     }
            // }
            steps {
                script {
                    echo "building image"
                    //gv.buildImage()
                }
            }
        }
        stage("deploy") {
            // when {
            //     expression {
            //         BRANCH_NAME == "main"
            //     }
            // }
            steps {
                script {
                    echo "deploying"
                    //gv.deployApp()
                }
            }
        }
    }   
}
