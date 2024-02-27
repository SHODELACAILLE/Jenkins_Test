pipeline {
    agent any
    
    triggers {
        pollSCM('*/3 * * * *')
    }
    
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/SHODELACAILLE/Jenkins_Test.git'
            }
        }
        stage('Compile') {
            steps {
                script {
                    def mvnHome = tool 'Maven'
                    if (mvnHome) {
                        sh "${mvnHome}/bin/mvn compile"
                    } else {
                        error "Maven n'est pas configuré sur ce noeud"
                    }
                }
            }
        }
        stage('Publish Javadoc') {
            steps {
                script {
                    def mvnHome = tool 'Maven'
                    if (mvnHome) {
                        sh "${mvnHome}/bin/mvn javadoc:javadoc"
                    } else {
                        error "Maven n'est pas configuré sur ce noeud"
                    }
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