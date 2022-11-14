pipeline {
	agent any
	stages {
		stage('Checkout GIT') {
		 steps {
			echo 'Pulling...';
			 git branch: 'faiz-daoud',
			 url : 'https://github.com/RihemSahbeni/dev_achats.git',
			 credentialsId:'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';
			  }
		  }
		stage('maven clean') {
		 steps {
			sh 'mvn clean'
			  }
		  }
		stage('maven package') {
		 steps {
			sh 'mvn package'
			  }
		  }
		stage('maven compile') {
		 steps {
			sh 'mvn compile'
			  }
		  }
		stage ('maven test') {
      		 steps {
       			 sh 'mvn test'
     			  }
  		  }
		/*
		stage ('Docker Compose') {
      		 steps {
       			 sh 'docker-compose start'
     			  }
  		  }
		  */
		stage('SonarQube') {
		 steps {
			 withSonarQubeEnv('SonarQube'){
			sh 'mvn sonar:sonar \
                  -Dsonar.projectKey=devops2 \
                  -Dsonar.host.url=http://192.168.1.122:9000 \
                  -Dsonar.login=b77dd928b864593d1b88655807dff98236171182'
			 }
			
			  }
		  }
		  /*
		stage('Nexus') {
		 steps {
			sh 'mvn deploy -DskipTests'
			  }
		  }
		  */
		  stage('Build Docker'){
           	  steps{
               		 sh 'docker build -t faizdaoud/faiz .'
            	}
      		  }
		stage('Docker Login'){
            	steps{
			
                sh 'docker login -u faizdaoud -p Douda123='
            }
        }
		 stage('Docker Push'){
            	 steps{	
                	sh 'docker push faizdaoud/faiz'
          	  }
     		   }
		stage('Start container') {
            	 steps {
                sh 'docker-compose up --build --force-recreate -d '
     		 }
     		   }
		
  }
  
   
}
