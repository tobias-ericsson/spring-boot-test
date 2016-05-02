Spring Boot Actuator
--------------------
Spring Boot includes a number of additional features to help you monitor and manage your application when it’s pushed to production.
You can choose to manage and monitor your application using HTTP endpoints, with JMX or even by remote shell (SSH or Telnet).
Auditing, health and metrics gathering can be automatically applied to your application.

Definition of Actuator
----------------------
An actuator is a manufacturing term, referring to a mechanical device for moving or controlling something.
Actuators can generate a large amount of motion from a small change.

How to
------

Add dependency:

dependencies {
    compile("org.springframework.boot:spring-boot-starter-actuator")
}


for git info add plugin:

plugins {
    id "com.gorylenko.gradle-git-properties" version "1.4.16"
}


