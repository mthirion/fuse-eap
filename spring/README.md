Spring-based Camel Application
==============================

This is a Spring XML based Camel application, intended to demonstrate the portability of FUSE between the Karaf and the EAP runtime.


Description
-----------
The camel route is defined using Spring XML.

The spring file is located in src/main/resources/META-INF/spring/jboss-camel-context.xml.

The route simply writes a message in the logs 10 times using the Camel Timer component.

The route uses a bean defined in /src/main/java


Portability considerations
--------------------------
On EAP:
 - a file named "*-camel-context.xml" located under META-INF will be auto-discovered at runtime
 - the maven package type is "jar", but it could actually be a bundle
 - the default camel version is 2.17 (EAP 6.4), but basically it will work with the v2.15 as well

On Karaf
 - camel-spring will look for the Spring file under META-INF/spring
 - the maven package type is "bundle"
 - there are additional fabric properties to bring features suck as camel-core and camel-spring
 - the default camel version is 2.15


Getting started
---------------

Starting with EAP, install Fuse on EAP and Fuse on Karaf

To run the example on EAP:

  - Start the server ($EAP_HOME/bin/standalone.sh)

  - Build the application  'mvn clean install)

  - Deploy the application to the EAP server (mvn jboss-as:deploy).  The jboss-as maven plugin is already present in the pom.xml

  - Check the logs to see that the Camel route is running

To switch to the Karaf runtime (Fabric):
  - Make sure the package type is set to "bundle".  The felix bundle plugin is already declared in the pom.xml

  - Start the Fabric runtime ($FUSE_HOME/bin/fuse)

  - Create a karaf container

  - Build the application (mvn clean install)

  - Deploy the application to Fabric (mvn fabric8:deploy).  The fabrci8 maven plugin is already present in the pom.xml, and the pom.xml also contains the proper declaration for installing the camel-core and camel-spring features during the deployment

  - Assign the profile to a Karaf container (fabric:container-add-profile <container> <profile>)

  - Look at the logs of the Karaf container to check that the application is working



Tests
-----

A basic test has been created using Arquillian (the test actually always returns true)

This test has been created only to demonstrate the Arquillian framework.

Arquillian is defined in src/test/resources/arquillian.xml

The description file contains 4 containers definitions:
 - EAP local
 - EAP remote
 - Fabric local
 - fabric remote

Within maven, the "default" profile is configured to skip the tests.

There are then 4 additionnal profiles that you can use to trigger tests for one of the 4 defined Arquillian containers

The profiles corresponds to:
 -  mvn test -Peap-arquillian-local
 -  mvn test -Peap-arquillian-remote
 -  mvn test -Pfabric-arquillian-local
 -  mvn test -Pfabric-arquillian-remote

The Arquillian definition uses 2 custom environment variables for the local tests, pointing to the install location of the product:
 - JBOSS_HOME points to the install dir of EAP
 - KARAF_INSTALL_HOME points to the install dir of FUSE Fabric




