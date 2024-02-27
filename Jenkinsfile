 /* node {  
   
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
pipeline {
    agent any // Assurez-vous que cette ligne est présente pour spécifier sur quel agent Jenkins le pipeline doit être exécuté

    tools {
        // Spécifie la version de Maven utilisée dans le pipeline
        maven 'maven-3.5.2'
    }

    stages {
        stage('Build project') {
            steps {
                // Change le répertoire courant en 'demo' où se trouve le pom.xml
                dir('demo') {
                    // Compile le projet sans exécuter les tests
                    sh 'mvn -B -DskipTests clean package'
                    
                    // Génère le Javadoc
                    sh 'mvn javadoc:javadoc'
                }
            }
        }
    }

    post {
        // Actions à effectuer après les étapes, comme publier les rapports de tests
        // Cette action est maintenant conditionnelle à la présence de rapports de tests
        success {
            script {
                // Vérifie si les rapports de tests existent avant de tenter de les publier
                if (fileExists('**/target/surefire-reports/*.xml')) {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
            // Vous pouvez également ajouter des étapes pour publier le Javadoc ici si nécessaire
        }
        // D'autres conditions de post-traitement peuvent être ajoutées ici (failure, always, etc.)
    }
}

