#!/usr/bin/env groovy

def call() {
    echo "Building Docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-creds', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
        sh "docker build -t $REPOSITORY ."
        sh "echo $DOCKER_PASSWORD | docker login -u $DOCKER_USERNAME --password-stdin "
        sh "docker push $REPOSITORY"
    }
}