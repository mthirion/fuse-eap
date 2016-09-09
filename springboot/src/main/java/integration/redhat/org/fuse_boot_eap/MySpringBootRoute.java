package integration.redhat.org.fuse_boot_eap;



import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;


@Component
public class MySpringBootRoute extends RouteBuilder {

    @Override
    public void configure() {
        from("timer://myTimer?fixedRate=true&period=2000&repeatCount=10")
        .bean("myBean", "writeMessage")
        .log("the camel spring boot app is running");

    }


}
