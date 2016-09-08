package integration.redhat.org.fuse_cdi_eap;

import java.io.File;
import java.io.InputStream;

import javax.inject.Inject;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.osgi.metadata.OSGiManifestBuilder;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.Asset;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osgi.framework.Bundle;


@RunWith(Arquillian.class)
public class MyTest {

    @Inject
    CamelContext camelContext;
    
    @Deployment
    public static JavaArchive createDeployment() {
        
        final JavaArchive archive = ShrinkWrap.create(JavaArchive.class, "camel-tests.jar");
        archive.addPackage(MyRouteBuilder.class.getPackage());
        archive.addAsResource(new File("src/main/resources/META-INF/beans.xml"), "beans.xml");
        
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
    public void testMyRoute() {
        Assert.assertTrue(true);
    }
}
