package lt.codeacademy.config.tokens;
//
//import io.jsonwebtoken.JwtBuilder;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class JwtUtil {
//    public static String generateToken(String signinkey, String username) {
//        long date = System.currentTimeMillis();
//        Date now = new Date(date);
//
//        JwtBuilder jwtBuilder = Jwts.builder().setSubject(username)
//                .setIssuedAt(now).signWith(SignatureAlgorithm.HS256, signinkey);
//
//        return jwtBuilder.compact();
//    }
//
//    public static String getUserTokenSubject(HttpServletRequest httpServletRequest, String jwtTokenName, String signinkey){
//        String token = CookieUtils.getvalue(httpServletRequest, jwtTokenName);
//        if (token==null) return null;
//        return  Jwts.parser().setSigningKey(signinkey).parseClaimsJws(token).getBody().getSubject();
//
//    }
}
