package com.example

class Docker implements Serializable {

    def script

    Docker(script) {
        this.script = script
    }

    def buildDockerImage(String imageName) {
        script.echo "Building Docker image..."
        script.sh "docker build -t $imageName ."
    }

    def dockerLogin() {
        script.echo "Login to DockerHub..."
        script.withCredentials([script.usernamePassword(credentialsId: 'docker-creds', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
            script.sh "echo $script.DOCKER_PASSWORD | docker login -u $script.DOCKER_USERNAME --password-stdin "
        }
    }

    def pushImage(String imageName) {
        script.echo "Pushing Docker image..."
        script.sh "docker push $imageName"
    }
}
