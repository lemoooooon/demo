package org.example.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Secured("ROLE_admin")
    @GetMapping("/say")
    public String sayHello() {
        return "Hello World!";
    }
}
