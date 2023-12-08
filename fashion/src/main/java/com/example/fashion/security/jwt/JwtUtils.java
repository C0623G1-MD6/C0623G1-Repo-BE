package com.example.fashion.security.jwt;


import com.example.fashion.model.MyUserDetail;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {
    private static final String SECRET_KEY = "======================C0623G1===========================";
    private static final long EXPIRE_TIME = 86400000000L;

    public String createToken(MyUserDetail userPrincipal) {
        String jwt = generateTokenFromUsername(userPrincipal.getUsername());
        return jwt;
    }


    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET_KEY));
    }
    public String generateTokenFromUsername(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + EXPIRE_TIME))
                .signWith(key(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(key()).build()
                .parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(key()).build().parse(authToken);
            return true;
        } catch (MalformedJwtException e) {
            System.out.println("Invalid JWT token: {}" + e.getMessage());
        } catch (ExpiredJwtException e) {
            System.out.println("Invalid JWT token: {}" + e.getMessage());
        } catch (UnsupportedJwtException e) {
            System.out.println("Invalid JWT token: {}" + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid JWT token: {}" + e.getMessage());
        }
        return false;
    }
}
