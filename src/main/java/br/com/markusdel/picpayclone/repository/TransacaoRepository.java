package br.com.markusdel.picpayclone.repository;

import br.com.markusdel.picpayclone.modelo.Transacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    Page<Transacao> fingByOrigen_LoginOrDestinoLogin(String login, String login1, Pageable paginacao);
}
