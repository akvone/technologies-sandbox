# Why does this project exist?

The main purpose of the `sandbox` project is to give a starting point with an existing code base to play with different
frameworks, libraries, and technologies.

# Prerequisites

* Maven
* JDK v8 (v11 for some modules)

Installed Docker is preferable but is not required 

# Credentials

Most services use `sandbox`/`sandbox` as user/password pairs

# Modules
## Sandbox modules:
* [kotlin sandbox](sandboxes/kotlin)
* [spring-boot sandbox](sandboxes/spring-boot)
* [spring-boot-postgresql sandbox](sandboxes/spring-boot-postgresql)
* [spring-boot-security sandbox](sandboxes/spring-boot-security)
* [spring-cloud sandbox](sandboxes/spring-cloud)
* [spring-cloud-gateway sandbox](sandboxes/spring-cloud-gateway)
  
## Other modules
* infrastructure - useful scripts and docker-compose.yaml files
* maven-parents - sandbox modules use them
* shared
    * shared-resources
    * shared-utils

# Setup minikube (for Windows only)

To set up everything, execute:
0. [Install winget](https://docs.microsoft.com/en-us/windows/package-manager/winget/) if needed
1. [install-or-upgrade-all.ps1](infrastructure/minikube/install-or-upgrade-all.ps1) (May require restarting terminal)
2. [start.ps1](infrastructure/minikube/start.ps1)

To stop minikube, execute: 
1. [stop.ps1](infrastructure/minikube/stop.ps1)

## Developer documentation
See [developer documentation](docs/DEV.md)
