package br.com.markusdel.picpayclone.service;

import br.com.markusdel.picpayclone.dto.UsuarioDTO;
import br.com.markusdel.picpayclone.modelo.Transacao;
import br.com.markusdel.picpayclone.modelo.Usuario;

import java.util.List;

public interface IUsuarioService {

    Usuario consultarEntidade(String login);

    UsuarioDTO consultar(String login);

    void atualizarSaldo(Transacao transacaoSalva, Boolean isCartaoCredito);

    void validar(Usuario... usuarios);

    List<UsuarioDTO> listar(String login);

}
