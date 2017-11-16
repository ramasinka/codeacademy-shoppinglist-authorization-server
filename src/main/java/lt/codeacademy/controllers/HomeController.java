package lt.codeacademy.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rest/hello")
public class HomeController {

    public static final String A = "c";

    @GetMapping("/principal")
    public Principal user(HttpServletRequest httpServletRequest, Principal principal) {
        String name = principal.getName();
        httpServletRequest.getSession().setAttribute("username", name);
        int[] arr = new int[10];
        Arrays.stream(arr).max().getAsInt() ;

        return principal;

    }

    @GetMapping
    public String hello() {
        return "Hello World";
    }

}

