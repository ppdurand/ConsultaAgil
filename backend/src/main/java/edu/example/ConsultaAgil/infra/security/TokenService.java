package edu.example.ConsultaAgil.infra.security;

import java.time.Instant;
import java.time.ZoneOffset;

import edu.example.ConsultaAgil.domain.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

@Service
public class TokenService {

    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            String token = JWT.create()
                    .withIssuer("ThunderSound")
                    .withSubject(user.getEmail())
                    .withExpiresAt(this.generateExpTime())
                    .sign(algorithm);

            return token;
        } catch (JWTCreationException e) {
            throw new RuntimeException("Error generating token", e);
        }
    }

    public String validateToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm).withIssuer("ThunderSound").build().verify(token).getSubject();
        } catch (JWTCreationException e){
            return null;
        }
    }

    private Instant generateExpTime(){
        return Instant.now().plus(1, java.time.temporal.ChronoUnit.HOURS);
    }
}
