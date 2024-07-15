pipeline {
    agent any
    
    stages {
     
        
        stage('build') {
            steps {
                echo 'Building and testing'
                bat 'mvn clean test'
            }
        }
    }
    
    post {
        success {
            echo 'Pipeline succeeded! Archiving artifacts...'
            archiveArtifacts 'target/*.jar'
        }
        
        always {
            echo 'Pipeline finished!'
            // Optionally, you can perform cleanup or notification tasks
        }
    }
}
