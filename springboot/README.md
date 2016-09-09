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
The camel route is defined in MySpringBootRoute.java, autodiscovered thanks to the @Component annotation <br>
The route uses a Bean defined and autodiscoverd in MySpringBootBean.java

When the route class is separated from the main class, there is no need to define a "spring.main.sources" property in the application.yaml file <br>
Otherwise, if they are both in the same class, this property should point to this class.

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



