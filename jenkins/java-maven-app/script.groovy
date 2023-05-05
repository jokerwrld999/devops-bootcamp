def deployApp() {
    echo "Deploying app on the server..."
    def dockerStop ="docker stop $appName"
    def dockerRun = "docker run --rm -d --name $appName -p 4444:8080 $imageName:${versionTag}"
    sshagent(credentials: ['ec2-private-key']) {
      sh "ssh -o StrictHostKeyChecking=no ec2-user@18.197.109.37 ${dockerStop}"
      sh "ssh -o StrictHostKeyChecking=no ec2-user@18.197.109.37 ${dockerRun}"
    }
}

return this