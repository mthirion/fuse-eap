package integration.redhat.org.fuse_boot_eap;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MySpringBootMain //extends SpringBootServletInitializor //implements WebApplicationInitializer
{

    public static void main(String[] args) {
        SpringApplication.run(MySpringBootMain.class, args);
    }

}

