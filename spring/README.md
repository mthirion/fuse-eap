Camel Spring XML Application
============================

This is a Camel Spring application, intended to demonstrate the portability between FUSE and EAP.
The current target runtime is EAP 


Description
-----------
The camel route is defined in src/main/resources/META-INF/jboss-camel-context.xml.
A file such as "*-camel-context.xml" will be auto-discovered at runtime.

The route simply writes a message in the logs 10 times using the Camel Timer component.
The route uses a bean defined in /src/main/java


Getting started
---------------

Install Fuse on EAP

Start the server

Build the application 

Deploy the application to the EAP server

Look at the logs


Tests
-----

A basic test has been created using Arquillian.

The Arquillian framework is defined in src/test/resources/arquillian.xml and contains properties that describe the target runtime (here EAP v6)

Within maven, the "default" profile is configured to skip the tests.
There are 2 additionnal profiles to run local and remote tests.
So, the tests can be run using mvn test -Parquillian-local or mvn test -Parquillian-remote

Arquillian requires the JBOSS_HOME environment variable set to the location of the target EAP server on the filesystem


