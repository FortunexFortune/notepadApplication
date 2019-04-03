pipeline { 
    agent any  
    stages { 
        stage('Build') { 
            steps { 
               sh 'mvn clean install'
            }
        }

        stage('Build Docker Image') {
            when {
                branch 'master'
            }
            steps {
                script {
                    try {
                        sh 'docker rmi fortunexfortune/notepadApplication'
                        } catch (err) {
                            echo: 'caught error: $err'
                        }
                    app = docker.build("fortunexfortune/notepadApplication")
                    app.inside {
                        sh 'echo $(curl localhost:8080)'
                    }
                }
            }
        }

        stage('Push Docker Image') {
            when {
                branch 'master'
            }
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', 'docker_hub') {
                        app.push("${env.BUILD_NUMBER}")
                        app.push("latest")
                    }
                }
            }
        }

            
        stage('DeployToProduction') {
            when {
                branch 'master'
            }
            steps {
                input 'Deploy to Production?'
                milestone(1)
                withCredentials([usernamePassword(credentialsId: 'deployment_server_login', usernameVariable: 'USERNAME', passwordVariable: 'USERPASS')]) {
                    script {
                        sh "sshpass -p '$USERPASS' -v ssh -o StrictHostKeyChecking=no $USERNAME@$deployment_ip \"docker pull fortunexfortune/notepadApplication:${env.BUILD_NUMBER}\""
                        try {
                            sh "sshpass -p '$USERPASS' -v ssh -o StrictHostKeyChecking=no $USERNAME@$deployment_ip \"docker stop notepadApplication\""
                            sh "sshpass -p '$USERPASS' -v ssh -o StrictHostKeyChecking=no $USERNAME@$deployment_ip \"docker rm notepadApplication\""
                        } catch (err) {
                            echo: 'caught error: $err'
                        }
                        sh "sshpass -p '$USERPASS' -v ssh -o StrictHostKeyChecking=no $USERNAME@$deployment_ip \"docker run --restart always --name notepadApplication -p 8081:8080 -d fortunexfortune/notepadApplication:${env.BUILD_NUMBER}\""
                    } 
                } 
            }
        }
    }
}