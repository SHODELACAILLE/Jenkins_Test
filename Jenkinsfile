 node {  
   
    def mvnHome = tool 'maven-3.5.2'

    stage('Clone repo'){
        git branch: 'devops', url: 'https://github.com/SHODELACAILLE/Jenkins_Test.git'
    }

    stage('Build project'){
        dir('demo') { // Change le répertoire courant en 'demo' où se trouve le pom.xml.
            // Compile le projet sans exécuter les tests
            sh "'${mvnHome}/bin/mvn' -B -DskipTests clean package"
            
            // Génère le Javadoc
            sh "'${mvnHome}/bin/mvn' javadoc:javadoc"
        }
    }

    stage('Publish Javadoc') {
        // Assume que le Javadoc est généré dans 'target/site/apidocs' dans le répertoire 'demo'
        dir('demo/target/site/apidocs') {
            // Utilisez un plugin ou une méthode pour publier le Javadoc ici.
            // Par exemple, si vous utilisez le plugin HTML Publisher dans Jenkins:
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