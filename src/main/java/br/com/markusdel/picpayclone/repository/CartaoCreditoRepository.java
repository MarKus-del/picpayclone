package br.com.markusdel.picpayclone.repository;

import br.com.markusdel.picpayclone.modelo.CartaoCredito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

public interface CartaoCreditoRepository extends JpaRepository<CartaoCredito, Long> {
}
