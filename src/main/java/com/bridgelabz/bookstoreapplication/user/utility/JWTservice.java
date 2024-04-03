package com.bridgelabz.bookstoreapplication.user.utility;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;
import java.util.Base64;


@Component
public class JWTservice {
    public static final String SECRET = "thesecret";

    public String generateToken(String email){
        //Token builder
        return JWT.create()
                .withClaim("email",email)
                //cryptographic algorithm
                //cryptographic hash
                .sign(Algorithm.HMAC256(Base64.getEncoder().encode(SECRET.getBytes())));
    }
    public String decodetoken(String token){
        try{
            String email = JWT.require(Algorithm.HMAC256(Base64.getEncoder().encode(SECRET.getBytes())))
                    //finilizes verifying setup
                    .build()
                    //verify the token signature is valid or not
                    .verify(token)
                    .getClaim("email")
                    //retrieves the email address from the verified JWT token
                    .asString();
            return email;
        }
        catch (Exception e){
            return null;
        }
    }
}
