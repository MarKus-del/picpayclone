package br.com.markusdel.picpayclone.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class ErrorDTO {

    private String campo;
    private String mensagen;

    public ErrorDTO(String campo, String mensagen) {
        this.campo = campo;
        this.mensagen = mensagen;
    }
}
