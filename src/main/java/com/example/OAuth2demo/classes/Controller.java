package com.example.OAuth2demo.classes;

import com.example.OAuth2demo.DemoApplication;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class Controller {
    private static final Log logger = LogFactory.getLog(DemoApplication.class);

    @RequestMapping("/user")
    public Principal user(Principal user) {
        logger.info("AS /user has been called");
        logger.debug("user info: "+user.toString());
        return user;
    }
}
