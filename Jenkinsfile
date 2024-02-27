 /* 
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
*/
node {
    agent any
    stages {
        stage('Build') {
            steps {
                // Commande pour lancer Maven. Assurez-vous que Maven est configuré dans Jenkins.
                sh 'mvnw clean package'
            }
        }
        stage('Test') {
            steps {
                // Commande pour exécuter les tests Maven. Les rapports de tests seront générés.
                sh 'mvnw test'
            }
        }
        // D'autres étapes peuvent être ajoutées ici si nécessaire.
    }
    post {
        // Actions à effectuer après les étapes, comme publier les rapports de tests.
        always {
            junit '**/target/surefire-reports/*.xml'
        }
    }
}
