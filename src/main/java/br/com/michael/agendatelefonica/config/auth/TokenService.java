package br.com.michael.agendatelefonica.config.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    @Value("${forum.jwt.expiration}")
    private String expiration;

    @Value("${forum.jwt.secret}")
    private String secret;

    public String gerarToken(Long idUsuario) {
        Date hoje = new Date();
        Date dataExpiracaoDoToken = new Date(hoje.getTime() + Long.parseLong(expiration));
        return Jwts.builder()
                .setIssuer("API da agenda telefônica")
                .setSubject(idUsuario.toString())
                .setIssuedAt(hoje)
                .setExpiration(dataExpiracaoDoToken)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean verificarSeTokenEstaValido(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Long getIdUsuario(String token) {
        Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        return Long.parseLong(body.getSubject());
    }
}
