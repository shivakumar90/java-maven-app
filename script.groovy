def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def buildImage() {
    echo "building the application..."
                    withCredentials([usernamePassword(credentialsId: 'dockerhub-repo', usernameVariable: "USER", passwordVariable: "PASS")]) {
                        sh "docker build -t shivakumarreddy1/demo-app:jma-2.0 ."
                        sh "echo $PASS | docker -login -u $USER --password-stdin"
                        sh "doker push shivakumarreddy1/demo-app:jam-2.0"
                    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this
