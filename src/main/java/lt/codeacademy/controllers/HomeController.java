package lt.codeacademy.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RestController
@RequestMapping("/rest/hello")
public class HomeController {

    @GetMapping("/principal")
    public Principal user(HttpServletRequest httpServletRequest, Principal principal) {
        String name = principal.getName();
        httpServletRequest.getSession().setAttribute("username", name);
        return principal;
    }

    @GetMapping
    public String hello() {
        return "Hello World";
    }

}

