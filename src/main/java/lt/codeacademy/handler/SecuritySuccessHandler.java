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
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        HttpSession session = httpServletRequest.getSession();
        User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String userName = authUser.getUsername();
//        long userId = userRepository.findUserByNameAndPassword(userName, authUser.getPassword()).getId();

        session.setAttribute("username", userName);
//        session.setAttribute("userid", userId);
        session.setAttribute("user", authUser);

        String redirect_uri = httpServletRequest.getParameter("redirect_uri");
        httpServletResponse.sendRedirect("http://localhost:8083/main");
    }
}