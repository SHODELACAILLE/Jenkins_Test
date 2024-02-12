node {  
    def mvnHome = tool 'maven-3.5.2'

    stage('Clone repo'){
        git branch: 'devops', url: 'https://github.com/SHODELACAILLE/Jenkins_Test.git'
    }

    stage('Build project'){
        dir('demo') { // Changez le répertoire courant en 'demo' où se trouve le pom.xml.
            sh "'${mvnHome}/bin/mvn' -B -DskipTests clean package"
        }
    }
}