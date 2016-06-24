# Configuration management of a Vert.x application using Ansible.

This repository exemplifies a basic system configuration for a Vert.x application using Ansible. It is accompanied by a Vagrant description file to deploy it locally in a CentOS 7-based VM.

The example application used for this demo ([Simple REST Micro-service](https://github.com/vert-x3/vertx-examples/blob/master/web-examples/README.adoc#user-content-simple-rest-micro-service)) belongs to the set of examples of the [Vert.x Web Module](https://github.com/vert-x3/vertx-examples/blob/master/web-examples/README.adoc).
##Requirements:
- Ansible 2.0
- Vagrant
- Virtualbox

## Instructions:
- Clone this repository.
- Separately, clone Vert.x examples [repository](https://github.com/vert-x3/vertx-examples) and build it (`mvn install`).
- Pack (`mvn package`) the Web examples [module](https://github.com/vert-x3/vertx-examples/tree/master/web-examples) into a jar file and place it in the previously cloned repository (`/provisioning/roles/vertx-standalone/files/web-examples-X.X.X.jar`).
- Update the *app_jar* universal variable in `/provisioning/group_vars/all` accordingly.
- Launch the configured VM with `vagrant up`.
- The example's REST endpoint is accesable at `http://localhost:8081/products`.

