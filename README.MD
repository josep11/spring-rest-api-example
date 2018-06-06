# Introduction
This is a tutorial for a project that uses hibernate to create a DB automatically and exposes a REST API por Paciente Model.
Working with MySQL DB

# Installation
1. Clone
`git clone https://github.com/josep11/spring-rest-api-example.git .`
2. Generate Eclipse Project & Download dependencies
`mvn eclipse:eclipse`
3. Run
`mvn spring-boot:run`

# Notes
For spring-dev-tools to work autobuild of the project should be enabled

# Deployment instructions
Deployment tested to Heroku
To select the profile:
`spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=local"`
java -jar file.jar --spring.profiles.active=production