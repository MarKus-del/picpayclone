package br.com.markusdel.picpayclone.service;

import br.com.markusdel.picpayclone.dto.CartaoCreditoDTO;
import br.com.markusdel.picpayclone.modelo.CartaoCredito;

public interface ICartaoCreditoService {

    CartaoCreditoDTO salvar(CartaoCreditoDTO cartaoCredito);
}
