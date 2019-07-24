package com.startx.ssodemo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * A Sample controller used to expose Keycloak Secured routes
 */
@RestController
public class SsodemoController {

    @RequestMapping(path = {"/", "/unsecured"})
    public String noSecuredEndpoint(){
        return "This is an unsecured endpoint payload";
    }

    @RequestMapping(
            name = "/admin",
            method = RequestMethod.GET, // @RequestMapping default assignment
            produces = MediaType.APPLICATION_JSON_VALUE // TIP : use org.springframework.http.MediaType for MimeType instead of hard coded value
    )
    public String adminSecuredEndpoint(){
        return "{\"message\": \"This is an ADMIN endpoint payload\"}";
    }

    @RequestMapping("/user")
    public String userSecuredEndpoint(){
        return "This is a USER endpoint payload";
    }

    @RequestMapping("/public")
    public String publicNoSecuredEndpoint(){
        return "This is a PUBLIC endpoint payload";
    }
}