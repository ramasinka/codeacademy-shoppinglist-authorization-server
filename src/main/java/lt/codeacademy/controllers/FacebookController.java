package lt.codeacademy.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FacebookController {

    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }

}
