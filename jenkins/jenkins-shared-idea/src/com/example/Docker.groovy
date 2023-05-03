package com.example

class Docker implements Serializable {

    def script

    Docker(script) {
        this.script = script
    }

    def buildDockerImage(String imageName) {
        script.echo "Building Docker image..."
        script.withCredentials([script.usernamePassword(credentialsId: 'docker-creds', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
            script.sh "docker build -t $imageName ."
            script.sh "echo $script.DOCKER_PASSWORD | docker login -u $script.DOCKER_USERNAME --password-stdin "
            script.sh "docker push $imageName"
        }
    }
}
