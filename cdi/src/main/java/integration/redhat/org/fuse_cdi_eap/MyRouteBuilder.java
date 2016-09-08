package integration.redhat.org.fuse_cdi_eap;

//import javax.ejb.Startup;
//import javax.enterprise.context.ApplicationScoped;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cdi.ContextName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.wildfly.extension.camel.CamelAware;

//@Startup
//@CamelAware
//@ApplicationScoped

@ContextName("myCdiCamelContext")

public class MyRouteBuilder extends RouteBuilder {

	private static final Logger LOG = LoggerFactory.getLogger(MyRouteBuilder.class);
	
	   // @Inject
	   // private SomeBean someBean;

		//@Inject @Uri("timer:foo?period=500") Endpoint myUri;
		
		//@Inject CdiCamelContext context;	
	
	
    @Override
    public void configure() throws Exception {
        from("timer://myTimer?fixedRate=true&period=2000&repeatCount=10")
    	.setBody(simple("the camel cdi app is running"))
        .to("log:integration.redhat.org.fuse_cdi_eap?level=INFO");
    }
}
