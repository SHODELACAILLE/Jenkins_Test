pipeline {
    agent any
    
        triggers {
        pollSCM('*/3 * * * *') 
    }

    tools {
      
        maven 'maven-3.5.2'
    }
    
    stages {
        stage('Clone repo') {
            steps {
                
                git branch: 'devops', url: 'https://github.com/SHODELACAILLE/Jenkins_Test.git'
            }
        }

        stage('Build project') {
            steps {
                dir('demo') { 
                   
                    sh "'${tool 'maven-3.5.2'}/bin/mvn' -B -DskipTests clean package"
                    
                    // Génère le Javadoc
                    sh "'${tool 'maven-3.5.2'}/bin/mvn' javadoc:javadoc"
                }
            }
        }

        stage('Publish Javadoc') {
            steps {
               
                dir('demo/target/site/apidocs') {
                   
                    publishHTML(target: [
                        reportDir: '.', 
                        reportFiles: 'index.html', 
                        reportName: "Javadoc", 
                        keepAll: true, 
                        allowMissing: false 
                    ])
                }
            }
        }
    }
}



/*
pipeline {
    agent any 

    tools {
        // Spécifier l'installation de Maven
        maven 'maven-3.5.2'
    }

    stages {
        stage('Build project') {
            steps {
                // Naviguer vers le répertoire du projet
                dir('demo') {
                   sh 'chmod +x mvnw'

                    sh './mvnw -DskipTests  clean package'
                    sh './mvnw javadoc:javadoc'
                }
            }
        }
    }
*/
/*
pipeline {
    agent any
     tools {
        
        maven 'maven-3.5.2'
    }
    environment {
        SONAR_TOKEN = credentials('1')
        SONAR_HOST_URL = 'http://localhost:9000'
    }
    stages {
        stage('SonarQube analysis') {
            steps {
                sh "mvn sonar:sonar -Dsonar.host.url=${SONAR_HOST_URL} -Dsonar.login=${SONAR_TOKEN}"
            }
        }
    }







*/