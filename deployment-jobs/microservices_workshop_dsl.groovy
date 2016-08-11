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

        def poms = ['quote-generator', 'portfolio-service', 'audit-service', 'compulsive-traders']
        poms.each { moduleName ->
            maven {
                goals('-e package')
                mavenInstallation(mvnInst)
                rootPOM("solution/${moduleName}/pom.xml") // substitute module name in path
                localRepository(LocalRepositoryLocation.LOCAL_TO_WORKSPACE)
            }
        }

      	ansiblePlaybook('/ansible/playbook.yml') {
        	inventoryPath('/ansible/hosts')
	        ansibleName('Ansible2.0')
	        credentialsId('vagrant-key')
            colorizedOutput(true)
	    }
    }
}