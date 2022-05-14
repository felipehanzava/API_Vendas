package com.hzfelipe.vendas.model.dto;

import com.sun.istack.NotNull;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class VendaIn {

    private Long idVendedor;
    @NotBlank
    private String data;
    @NotNull
    private Long valor;

    public Long getIdVendedor() {
        return idVendedor;
    }
}
