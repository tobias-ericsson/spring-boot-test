# spring-boot-test
Spring Boot test project


### To get Spring CLI (not needed)

- curl -s http://get.sdkman.io | bash 
- source "/home/tobias/.sdkman/bin/sdkman-init.sh"
- spring --version

### To run

- mvn package
- mvn spring-boot:run

### To package as fat jar and run

- mvn package
- java -jar target/myproject-0.0.1-SNAPSHOT.jar

### To run with gradle

- gradle clean bootRun

### To check health and metrics

spring-boot-starter-actuator endpoints

/info
/env
/health
/metrics
/trace