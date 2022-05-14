package com.hzfelipe.vendas.model.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class VendaIn {

    private Long idVendedor;
    @NotBlank
    private String data;
    @NotBlank
    private String valor;

    public Long getIdVendedor() {
        return idVendedor;
    }
}
