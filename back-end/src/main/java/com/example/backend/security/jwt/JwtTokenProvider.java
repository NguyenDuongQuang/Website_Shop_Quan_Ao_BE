package com.example.backend.security.jwt;


import com.example.backend.core.security.config.custom.CustomUserDetails;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j // ghi log cua lombok
public class JwtTokenProvider {
    private String jWT_SECRET="aasdasdasdasdasdasdqweqeqwe";
    private int jWT_EXPIRATION= 300000;
    //tao jwt tu thong tin user
    public String generateToken(CustomUserDetails customUserDetails){
        Date now = new Date();
        String tokenUser = customUserDetails.toString();
        Date dateExpieed = new Date(now.getTime()+jWT_EXPIRATION);
        // tao chuoi token
        return Jwts.builder().setSubject(tokenUser)
                .setIssuedAt(now)
                .setExpiration(dateExpieed)
                .signWith(SignatureAlgorithm.HS512,jWT_SECRET)
                .compact();
    }
    // ham lay thong tin user tu jwt
    public String getUserNameFromJwt(String token){
        Claims claims = Jwts.parser().setSigningKey(jWT_SECRET)
                .parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
    public boolean validateToken(String token){
        try {
            Jwts.parser().setSigningKey(jWT_SECRET)
                    .parseClaimsJws(token);
            return true;
        }catch (MalformedJwtException ex){
            log.error("Invalid JWT Token");
        }catch (ExpiredJwtException ex){
            log.error("Expired JWT Token");
        }catch (UnsupportedJwtException ex){
            log.error("Unsupported JWT Token");
        }catch (IllegalArgumentException ex){
            log.error("JWT claims String is empty");
        }
        return false;
    }
}

