package lt.codeacademy.handler;

//import lt.codeacademy.dao.UserRepository;

import lt.codeacademy.config.tokens.CookieUtils;
import lt.codeacademy.config.tokens.
        JwtUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class SecuritySuccessHandler implements AuthenticationSuccessHandler {

    //    @Resource
//    private UserRepository userRepository;
    static final String jwtCokkiename = "token";
    static final String signinkey = "signingKey";

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        StringBuffer requestURL = request.getRequestURL();
        System.out.println(requestURL);

        HttpSession session = request.getSession();
        User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String userName = authUser.getUsername();

        session.setAttribute("username", userName);
        session.setAttribute("user", authUser);

//        response.sendRedirect("http://localhost:8084/main");
    }
}