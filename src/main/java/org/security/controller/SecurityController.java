package org.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {
    @GetMapping("/user")
    public String user(){
        System.out.println("USerAccessd");
        return "hello user";
    }
    @GetMapping("/admin")
    public String admin(){
        System.out.println("admin Accessd");
        return "admin user";
    }
}
