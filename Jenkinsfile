pipeline{
    agent any
    
  
        stages {
        stage('Git') {
            steps {
                echo "git";
                git branch : 'dorsafsaadi',
                url: 'https://github.com/RihemSahbeni/dev_achats.git'
            }
        }
     
        stage('MVN CLEAN') {
            steps {
                sh 'mvn clean '
            }
        }
       
        stage('MVN COMPILE') {
            steps {
                sh 'mvn compile'
            }
        }
         
      stage ('SonarQube :Quality Test')
        {
         steps{
             withSonarQubeEnv(installationName: 'sonar'){
                sh 'mvn sonar:sonar'
             }
            }
        }
          stage('Build Docker'){
           	  steps{
               		 sh 'docker build -t dorsafsaadi/spring .'
            	}
      		  }
		stage('Docker Login'){
            	steps{
			
                sh 'docker login -u dorsafsaadi -p 22043417Moi**'
            }
        }
		 stage('Docker Push'){
            	 steps{	
                	sh 'docker push dorsafsaadi/spring'
          	  }
     		   }
		stage('Start container') {
            	 steps {
                sh 'docker-compose up --build --force-recreate -d '
     		 }
     		   }
        
        }
    }

