package integration.redhat.org.fuse_boot_eap;

import org.springframework.stereotype.Component;

@Component("myBean")
public class MySpringBootBean {

    private String msg="Hello my Bean";

    public String writeMessage() {
        return msg;
    }

}