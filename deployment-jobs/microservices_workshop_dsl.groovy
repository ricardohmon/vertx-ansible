job('vertx-microservices-workshop-job') {
    jdk('JDK8')
    wrappers {
        colorizeOutput('xterm')
    }
    scm {
        git('git://github.com/ricardohmon/vertx-microservices-workshop.git','without-docker')
    }
    triggers {
        scm('*/15 * * * *')
    }
    steps {
        def mvnInst = 'M3.3.9'
    	maven {
    		goals('-e clean package install')
            mavenInstallation(mvnInst)
            localRepository(LocalRepositoryLocation.LOCAL_TO_WORKSPACE)
    	}
        maven {
            goals('-e package')
            mavenInstallation(mvnInst)
            rootPOM('solution/quote-generator/pom.xml')
            localRepository(LocalRepositoryLocation.LOCAL_TO_WORKSPACE)
        }
        maven {
            goals('-e package')
            mavenInstallation(mvnInst)
            rootPOM('solution/portfolio-service/pom.xml')
            localRepository(LocalRepositoryLocation.LOCAL_TO_WORKSPACE)
        }
        maven {
            goals('-e package')
            mavenInstallation(mvnInst)
            rootPOM('solution/audit-service/pom.xml')
            localRepository(LocalRepositoryLocation.LOCAL_TO_WORKSPACE)
        }
        maven {
            goals('-e package')
            mavenInstallation(mvnInst)
            rootPOM('solution/compulsive-traders/pom.xml')
            localRepository(LocalRepositoryLocation.LOCAL_TO_WORKSPACE)
        }

      	ansiblePlaybook('/ansible/playbook.yml') {
        	inventoryPath('/ansible/hosts')
	        ansibleName('Ansible2.0')
	        credentialsId('vagrant-key')
            colorizedOutput(true)
	    }
    }
}