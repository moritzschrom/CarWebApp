pipeline {
	agent any

	tools {
		jdk "JDK 16"   /* may need to be adapted */
		maven "Maven 3.8"   /* may need to be adapted */
	}

	stages {
	    stage("Build with tests") {
            steps {
                sh "mvn clean package"
            }
        }

        stage("Build without tests") {
            steps {
                sh "mvn clean package -DskipTests"
            }
        }
	}

	post {
        always {
            junit allowEmptyResults: true, testResults: "target/surefire-reports/*.xml,target/failsafe-reports/*.xml"
        }
    }
}
