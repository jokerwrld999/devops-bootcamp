def buildApp() {
    sh "mvn package"
}

def buildImage() {
    withCredentials([usernamePassword(credentialsId: 'docker-creds', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
        sh "docker build -t $REPOSITORY ."
        sh "echo $DOCKER_PASSWORD | docker login -u $DOCKER_USERNAME --password-stdin "
        sh "docker push $REPOSITORY"
    }
}

return this