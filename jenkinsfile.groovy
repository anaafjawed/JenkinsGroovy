pipeline{

    agent any
        stages{
            stage('Checkout Code'){
                steps {
                    git branch: 'main', url: 'https://github.com/aliamjad94/TradeApp.git'
                }
            }
            
            stage('Build'){
                steps {
                    bat "\"${tool 'MSBuildLocal'}\" TradeNowApp/TradeNow.sln /p:Configuration=Debug /p:ProductVersion=1.3.0.${env.BUILD_NUMBER}"
                }
            }
        }
        
        post{
            always{
                mail to: 'smaaz1994@gmail.com',
                subject: "Job '${JOB_NAME}' (${BUILD_NUMBER}) is ${currentBuild.result}",
                body: "Please go to ${BUILD_URL} and verify the build!\n\nRegards,\nAmjad"
            }
        }
    }
