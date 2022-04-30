package com.deep.springbootfacebookauthenticator;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

@RestController
public class BasicController {

    @GetMapping("/")
    public String home(Principal p){
        Map<String, Object> authDetails= (Map<String, Object>) ((OAuth2Authentication) p).getUserAuthentication().getDetails();
        String user= (String) authDetails.get("name");

        return "Hey "+ user + " Whats Up!!";
    }
}
