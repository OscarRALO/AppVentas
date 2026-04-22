package com.ventas.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

//sirve para generar el token
@Component
public class JwtUtil {

    private final SecretKey secretKey;
    private final long expirate;


    //Se lee los valores del aplication.properties
    public JwtUtil(
            @Value("${jwt.secret}") String secret,
            @Value("${jwt.expiration=}") long expirate)
    {
        //Key.hmacShaKeyFor convierte el string a una clave criptografica para HS250
        this.secretKey = Keys.hmacShaKeyFor(secret.getBytes());
        this.expirate = expirate;
    }

    //Generar el token
    public String generateToken(String userName){
        return Jwts.builder()
                .subject(userName)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expirate))
                .signWith(secretKey)
                .compact();
    }

    public String extraerUsername(String token){
        return extractClaims(token).getSubject();
    }


    //Is valid
    public boolean isTokenValid(String token){
        try{
            Claims claims = extractClaims(token);
            return claims.getExpiration().after(new Date());
        }catch(Exception e){
            return false;
        }
    }

    //parsea el token y extrae el payload(claims)
    private Claims extractClaims(String token){
        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

}
