package ru.wallet.AuthorizationService.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.wallet.AuthorizationService.entity.User;
import ru.wallet.AuthorizationService.service.JwtService;

import java.time.Duration;
import java.time.Instant;

@Service
public class JwtServiceImpl implements JwtService {

    @Value("${security.jwt.issuer}")
    private String issuer;
    @Value("${security.jwt.secret}")
    private String secret;

    @Override
    public String generate(User user) {
        return JWT.create()
                .withIssuer(issuer)
                .withSubject(user.getUsername())
                .withExpiresAt(Instant.now().plus(Duration.ofMinutes(15)))
                .sign(Algorithm.HMAC256(secret));
    }

}
