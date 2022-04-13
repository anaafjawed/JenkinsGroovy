node{
     stage('SCM'){                
        git branch: 'main', url: 'https://github.com/aliamjad94/TradeApp.git'
	}
            
     stage('Build'){
                    bat "\"${tool 'MSBuildLocal'}\" TradeNowApp/TradeNow.sln /p:Configuration=Debug /p:ProductVersion=1.3.0.${env.BUILD_NUMBER}"
        }
    }
