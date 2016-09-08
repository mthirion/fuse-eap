CDI-based Camel Application
===========================

This is a CDI-based Camel application, intended to demonstrate the portability of FUSE between the Karaf and the EAP runtime.


Description
-----------
The camel route is defined using CDI in plain Java with a customer RouteBuilder implementation.

The corresponding (empty) beans.xml is located in src/main/resources/META-INF

The route simply writes a message in the logs 10 times using the Camel Timer component.


Portability considerations
--------------------------
On EAP:

  The maven package type is "jar", but it could actually be a bundle
  
  The default camel version is 2.17
  
  The following annotations are not portable to karaf: <br>
    @Startup <br>
    @CamelAware <br>
    @ApplicationScope <br>
  
  Instead, use: <br>
    @ContextName("myCamelContext")

<br>
On Karaf:

  The maven package type is "bundle".
  
  The default camel version is 2.15 <br>
  However, CDI requires camel-core and camel-cdi in version 2.17+ <br>
  Those bundles are installed on the Karaf container during deployment time thanks to the <fabric8.bundles> declaration in the pom.xml
 
  The OSGI version of the CDI container is reprensented by "pax-cdi-weld" feature and the "deltaspike" extension. <br>
  Those features are also installed during deployment time.

  The CDI framework needs to be activated at the bundle level. <br>
  This is done in the configuration of the bundle dependencies: <br>
            &lt;Require-Capability&gt; <br>
              osgi.extender;filter:="(osgi.extender=pax.cdi)", <br>
              org.ops4j.pax.cdi.extension;filter:="(extension=camel-cdi-extension)" <br>
            &lt;/Require-Capability&gt;  <br>


Getting started
---------------

Install Fuse on EAP and Fuse on Karaf.

To run the example on EAP:

  - Start the EAP server ($EAP_HOME/bin/standalone.sh)

  - Build the application  (mvn clean install)

  - Deploy the application to the EAP server (mvn jboss-as:deploy).   <br>
    The jboss-as maven plugin is already present in the pom.xml

  - Check the logs to see that the Camel route is running


To switch to the Karaf runtime (Fabric):

  - Make sure the package type is set to "bundle".  <br>
    The felix bundle plugin is already declared in the pom.xml

  - Start the Fabric runtime ($FUSE_HOME/bin/fuse)

  - Create a karaf container

  - Build the application (mvn clean install)

  - Deploy the application to Fabric (mvn fabric8:deploy).   <br>
    The fabrci8 maven plugin is already present in the pom.xml. <br>
    The pom.xml also contains the proper declaration for installing the bundles and features dependencies

  - Assign the profile to a Karaf container (fabric:container-add-profile "container" "profile")

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




