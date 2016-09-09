SpringBoot Camel Application
============================

This is an example of a Camel application developped using Spring Boot


Description
-----------
A Spring Boot application is an executable jar or war. <br>
It requires a "main" method that will be used to launch the Spring Boot app --> SpringApplication.run <br>
The executable is build by a maven plugin that requires the spring-boot-starter-actuator dependency. <br>
It's recommended to specify the mainClass in the maven springboot plugin, reponsible for building the executable.

The main class of the Spring Boot application is MySpringBootMain.java <br>
The routes are here defined in separated xml files stored under the "resources" folder. <br>
The location of the routes files is defined in the application.yml file.

Once build, the application can be run using:
 - mvn spring-boot:run
 - java -jar target/app.jar

The camel.springboot.main-run-controller property is needed to ensure the camel thread stays alive.


Portability considerations
--------------------------
On EAP: <br>
  The SpringApplication.run can be attached to the servlet thread. <br>
  In that case the result would be an executable and deployable war. <br>
  The required steps are:
   - spring-boot-starter-web dependency
   - org.springframework.boot.web.support.SpringBootServletInitializer in the web.xml
   - main class extending SpringBootServletInitializer

<br>
On Karaf: <br>
  The SpringApplication has to be instanciated in a BundleActivator



