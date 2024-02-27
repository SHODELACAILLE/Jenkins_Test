pipeline {
    agent any
    
        triggers {
        pollSCM('*/3 * * * *') // Déclenche le job toutes les 3 minutes
    }
    
    tools {
        // Définit l'outil Maven à utiliser dans ce pipeline
        maven 'maven-3.5.2'
    }
    
    stages {
        stage('Clone repo') {
            steps {
                // Cloner le dépôt Git dans la branche 'devops'
                git branch: 'devops', url: 'https://github.com/SHODELACAILLE/Jenkins_Test.git'
            }
        }

        stage('Build project') {
            steps {
                dir('demo') { // Change le répertoire courant en 'demo' où se trouve le pom.xml.
                    // Compile le projet sans exécuter les tests
                    sh "'${tool 'maven-3.5.2'}/bin/mvn' -B -DskipTests clean package"
                    
                    // Génère le Javadoc
                    sh "'${tool 'maven-3.5.2'}/bin/mvn' javadoc:javadoc"
                }
            }
        }

        stage('Publish Javadoc') {
            steps {
                // Assume que le Javadoc est généré dans 'target/site/apidocs' dans le répertoire 'demoo'
                dir('demo/target/site/apidocs') {
                    // Utilise le plugin HTML Publisher pour publier la Javadoc
                    publishHTML(target: [
                        reportDir: '.', // Le répertoire actuel contient les fichiers Javadoc
                        reportFiles: 'index.html', // Le fichier d'entrée principal du Javadoc
                        reportName: "Javadoc", // Le nom sous lequel le rapport doit être publié
                        keepAll: true, // Conserve les rapports de toutes les builds
                        allowMissing: false // Ne permet pas de signaler un build comme réussi si le dossier est manquant
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