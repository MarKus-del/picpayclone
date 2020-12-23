package br.com.markusdel.picpayclone.service.impl;

import br.com.markusdel.picpayclone.conversor.CartaoCreditoConversor;
import br.com.markusdel.picpayclone.dto.CartaoCreditoDTO;
import br.com.markusdel.picpayclone.modelo.CartaoCredito;
import br.com.markusdel.picpayclone.repository.CartaoCreditoRepository;
import br.com.markusdel.picpayclone.service.ICartaoCreditoService;
import br.com.markusdel.picpayclone.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;

public class CartaoCreditoService implements ICartaoCreditoService {
    @Autowired
    private CartaoCreditoRepository cartaoCreditoRepository;

    @Autowired
    private CartaoCreditoConversor cartaoCreditoConversor;

    @Autowired
    private IUsuarioService usuarioService;

    @Override
    public CartaoCreditoDTO salvar(CartaoCreditoDTO cartaoCreditoDTO) {
        CartaoCreditoDTO cartaoCreditoRetorno = null;
        if (cartaoCreditoDTO.getIsSalva()) {
            CartaoCredito cartaoCredito = cartaoCreditoConversor.converterDtoParaEntidade(cartaoCreditoDTO);
            usuarioService.validar(cartaoCredito.getUsuario());
            CartaoCredito cartaoCreditoSalvo = cartaoCreditoRepository.save(cartaoCredito);
            cartaoCreditoRetorno = cartaoCreditoConversor.converterEntidadeParaDto(cartaoCreditoSalvo);
        }

        return cartaoCreditoRetorno;
    }
}
