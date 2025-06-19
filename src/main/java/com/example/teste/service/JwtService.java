package com.example.teste.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private long expirationTime;

    private Algorithm getSigningAlgorithm() {
        return Algorithm.HMAC256(secretKey);
    }

    private JWTVerifier getVerifier() {
        return JWT.require(getSigningAlgorithm()).build();
    }

    /**
     * Gera um token JWT com subject e claims.
     */
    public String generateToken(String username, String role) {
        return JWT.create()
                .withSubject(username)
                .withClaim("role", role)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + expirationTime))
                .sign(getSigningAlgorithm());
    }

    /**
     * Valida o token com base na assinatura e expiração.
     */
    public boolean validateToken(String token) {
        try {
            getVerifier().verify(token);
            return true;
        } catch (JWTVerificationException e) {
            System.err.println("Erro na validação do token: " + e.getMessage());
            return false;
        }
    }

    /**
     * Extrai o username (subject) do token.
     */
    public String getUsernameFromToken(String token) {
        try {
            return getVerifier().verify(token).getSubject();
        } catch (JWTVerificationException e) {
            return null;
        }
    }

    /**
     * Extrai todas as claims do token como Map.
     */
    public Map<String, Object> getAllClaimsFromToken(String token) {
        try {
            DecodedJWT jwt = getVerifier().verify(token);
            return jwt.getClaims().entrySet().stream()
                    .collect(HashMap::new, (map, entry) -> map.put(entry.getKey(), entry.getValue().as(Object.class)), HashMap::putAll);
        } catch (JWTVerificationException e) {
            return new HashMap<>();
        }
    }

    /**
     * (Opcional) Extrai a role do token JWT.
     */
    public String getRoleFromToken(String token) {
        try {
            return getVerifier().verify(token).getClaim("role").asString();
        } catch (JWTVerificationException e) {
            return null;
        }
    }
}
