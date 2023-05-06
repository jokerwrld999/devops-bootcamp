def deployApp() {
    echo "Deploying app on the server..."
    def ec2InstanceIP = 'ec2-user@18.197.109.37'
    def executeScript ="bash ./deploy_app.sh $imageName:${versionTag}"
    sshagent(credentials: ['ec2-private-key']) {
      sh "scp deploy_app.sh docker-compose.yaml ${ec2InstanceIP}:/home/ec2-user"
      sh "ssh -o StrictHostKeyChecking=no ${ec2InstanceIP} ${executeScript}"
    }
}

return this