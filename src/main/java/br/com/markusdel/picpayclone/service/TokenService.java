package br.com.markusdel.picpayclone.service;

import br.com.markusdel.picpayclone.modelo.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    @Value("${picpayclone.jwt.expiration}")
    private String expiration;

    @Value("${picpayclone.jwt.secret}")
    private String secret;

    public String gerarToken(Authentication authenticate) {
        Usuario usuarioLogado = (Usuario) authenticate.getPrincipal();
        Date dataHoje = new Date();

        Date tempoExpiracao = new Date(dataHoje.getTime() + Long.parseLong(expiration));
        return Jwts.builder()
                .setIssuer("API do PicPay Clone")
                .setSubject(usuarioLogado.getId().toString())
                .setIssuedAt(tempoExpiracao)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public Boolean isTokenValido(String token) {
        try{
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public Long getIdUsuario(String token) {
        Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        return Long.parseLong(claims.getSubject());
    }
}
