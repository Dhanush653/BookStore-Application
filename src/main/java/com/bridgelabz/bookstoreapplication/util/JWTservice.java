package com.bridgelabz.bookstoreapplication.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;
import java.util.Base64;


@Component
public class JWTservice {
    public static final String SECRET = "thesecret";

    public String generateToken(String email){
        return JWT.create()
                .withClaim("email",email)
                .sign(Algorithm.HMAC256(Base64.getEncoder().encode(SECRET.getBytes())));
    }
    public String decodetoken(String token){
        try{
            String email = JWT.require(Algorithm.HMAC256(Base64.getEncoder().encode(SECRET.getBytes())))
                    .build()
                    .verify(token)
                    .getClaim("email")
                    .asString();
            return email;
        }
        catch (Exception e){
            return null;
        }
    }
}
