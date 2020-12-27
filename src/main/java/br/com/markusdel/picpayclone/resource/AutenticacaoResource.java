package br.com.markusdel.picpayclone.resource;

import br.com.markusdel.picpayclone.dto.LoginDTO;
import br.com.markusdel.picpayclone.dto.TokenDTO;
import br.com.markusdel.picpayclone.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autenticacao")
public class AutenticacaoResource extends ResourceBase<TokenDTO>{

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;

    public ResponseEntity<TokenDTO> autenticar(LoginDTO login) {
        try {
            UsernamePasswordAuthenticationToken dadosLogin = login.converter();

            Authentication authenticate = authManager.authenticate(dadosLogin);
            String token = tokenService.gerarToken(authenticate);

            return responderSucessoComItem(new TokenDTO(token, "Bearer"));
        }catch(AuthenticationException e){
            return responderRequisicaoMalSucedida();
        }
    }
}
