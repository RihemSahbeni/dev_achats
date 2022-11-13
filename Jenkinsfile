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
         
        
        
        }
    }

