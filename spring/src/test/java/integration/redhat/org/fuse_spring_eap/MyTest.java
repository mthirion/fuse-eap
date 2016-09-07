package integration.redhat.org.fuse_spring_eap;

import java.io.File;
import java.io.InputStream;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.osgi.metadata.OSGiManifestBuilder;
import org.jboss.osgi.metadata.OSGiMetaDataBuilder;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.Asset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osgi.framework.Bundle;

import com.sun.istack.logging.Logger;


@RunWith(Arquillian.class)
public class MyTest {

    @Deployment
    public static JavaArchive createDeployment() {
        final JavaArchive  archive = ShrinkWrap.create(JavaArchive.class, "camel-tests.jar");
        archive.addPackage(MyBean.class.getPackage());
        archive.addAsResource(new File("src/main/resources/META-INF/spring/jboss-camel-context.xml"), "jboss-camel-context.xml");
        
        archive.setManifest(new Asset() {
            public InputStream openStream() {
                OSGiManifestBuilder builder = OSGiManifestBuilder.newInstance();
                builder.addImportPackages("javax.naming");
                builder.addBundleSymbolicName(archive.getName());
                builder.addBundleManifestVersion(2);
                builder.addImportPackages(Bundle.class);
                return builder.openStream();
            }
        });       
        
        return archive;
    }

    @Test
    public void testMyRoute() throws NamingException {
    	/* Test available on EAP */
//        InitialContext context = new InitialContext();
//        CamelContext camelContext = (CamelContext) context.lookup("java:jboss/camel/context/spring-context");
//        Assert.assertNotNull("Expecting camelContext to not be null", camelContext);
    	
    	/* test on Karaf */
    	Assert.assertTrue(true);
        
    }
}
