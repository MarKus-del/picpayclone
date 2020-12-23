package br.com.markusdel.picpayclone.repository;

import br.com.markusdel.picpayclone.modelo.CartaoCredito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoCreditoRepository extends JpaRepository<CartaoCredito, Long> {
}
