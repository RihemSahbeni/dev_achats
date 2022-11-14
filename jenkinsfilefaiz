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
			 withSonarQubeEnv('sonarqube-8.9.7'){
			sh 'mvn sonar:sonar'
			 }
			
			  }
		  }
		stage('Nexus') {
		 steps {
			sh 'mvn deploy -DskipTests'
			  }
		  }
		  
		  stage('Build Docker'){
           	  steps{
               		 sh 'docker build -t dhiarekik/devops .'
            	}
      		  }
		stage('Docker Login'){
            	steps{
			
                sh 'docker login -u dhiarekik -p 203JMT2209'
            }
        }
		 stage('Docker Push'){
            	 steps{	
                	sh 'docker push dhiarekik/devops'
          	  }
     		   }
		stage('Start container') {
            	 steps {
                sh 'docker-compose up --build --force-recreate -d '
     		 }
     		   }
		
  }
  
   
}
