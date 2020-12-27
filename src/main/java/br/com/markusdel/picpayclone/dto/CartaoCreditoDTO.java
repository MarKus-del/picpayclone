package br.com.markusdel.picpayclone.dto;

import br.com.markusdel.picpayclone.enums.BandeiraCartao;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@JsonInclude(Include.NON_NULL)
public class CartaoCreditoDTO {

    @NotBlank
    private BandeiraCartao bandeira;

    @NotBlank
    private String codigoSegurança;

    @NotBlank
    private String dataExpiração;

    @NotBlank
    private String nomeTitular;

    private String numero;

    private String numeroToken;

    @NotNull
    private UsuarioDTO usuario;

    private Boolean isSalva = false;
}