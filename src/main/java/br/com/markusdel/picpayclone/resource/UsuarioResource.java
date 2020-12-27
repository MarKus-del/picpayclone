package br.com.markusdel.picpayclone.resource;

import br.com.markusdel.picpayclone.dto.UsuarioDTO;
import br.com.markusdel.picpayclone.resource.swagger.IUsuarioResource;
import br.com.markusdel.picpayclone.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/usuarios")
public class UsuarioResource extends ResourceBase<UsuarioDTO> implements IUsuarioResource {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/{login}")
    public ResponseEntity<UsuarioDTO> consultar(@PathVariable String login) {
        UsuarioDTO usuario = usuarioService.consultar(login);
        return responderSucessoComItem(usuario);
    }

    @GetMapping("/contatos")
    @Override
    public ResponseEntity<List<UsuarioDTO>> listar(@RequestParam String login) {
        List<UsuarioDTO> usuario = usuarioService.listar(login);
        return responderListaDeItens(usuario);
    }

    @GetMapping("/{login}/saldo")
    public ResponseEntity<UsuarioDTO> consultarSaldo(@PageableDefault(page = 0, size = 20) Pageable paginacao,
                                                     @PathVariable String login) {
        UsuarioDTO usuarioDTO = usuarioService.consultar(login);
        return responderSucessoComItem(usuarioDTO);
    }


}
