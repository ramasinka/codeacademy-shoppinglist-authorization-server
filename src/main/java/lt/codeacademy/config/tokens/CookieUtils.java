package lt.codeacademy.config.tokens;

import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {
    public static String getvalue(HttpServletRequest httpServletRequest, String jwtTokenName) {
        Cookie cookie = WebUtils.getCookie(httpServletRequest, jwtTokenName);

        return cookie != null ? cookie.getValue() : null;

    }

    public static void createTokenCookie(HttpServletResponse httpServletResponse, String jwtCokkiename, String token, String domain) {
        Cookie cookie = new Cookie(jwtCokkiename, token);
        cookie.setSecure(false);
        cookie.setHttpOnly(true);
        cookie.setMaxAge(-1);
        cookie.setDomain(domain);
        cookie.setPath("/");
        httpServletResponse.addCookie(cookie);
    }

    public static void clear(HttpServletResponse httpServletResponse, String jwtTokenName) {
        Cookie cookie = new Cookie(jwtTokenName, null);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(0);
        httpServletResponse.addCookie(cookie);

    }


}