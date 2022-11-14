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
         
         
  stage('MVN SONARQUBE') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'
            }
        }
        stage('MVN Test') {
            steps {
                sh 'mvn test'
            }
        }}
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

