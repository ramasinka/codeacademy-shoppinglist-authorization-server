package lt.codeacademy.handler;

//import lt.codeacademy.dao.UserRepository;
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

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        StringBuffer requestURL = request.getRequestURL();
        System.out.println(requestURL);

        HttpSession session = request.getSession();
        User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String userName = authUser.getUsername();
//        long userId = userRepository.findUserByNameAndPassword(userName, authUser.getPassword()).getId();

        session.setAttribute("username", userName);
//        session.setAttribute("userid", userId);
        session.setAttribute("user", authUser);

        response.sendRedirect(request.getHeader("referer"));
    }
}