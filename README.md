# System configuration management and software deployment automation for Vert.x applications using Ansible and Jenkins.

This demo builds on the Vert.x Microservices [workshop](http://vertx-lab.dynamis-technologies.com/) enhancing it by embracing system configuration (Ansible) and application deployment deployment(Jenkins) tasks practices, characteristic of DevOps environments.

##Folders contents:
- ansible. The Ansible playbook and configuration necessary to provision the machines hosting the Vert.x Microservices.
- deployment-jobs. A sample DSL-based Jenkins job description to build and deploy our services to running machines.
- demo. An environment configuration based on Vagrant and Ansible to set up a Jenkins instance and the Virtualbox VMs hosting the Vert.x Microservices.

##Requirements:
- Ansible 2.0
- Vagrant
- Virtualbox


