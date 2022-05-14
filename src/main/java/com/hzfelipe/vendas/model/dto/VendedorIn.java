package com.hzfelipe.vendas.model.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;


@Getter
public class VendedorIn {

    @NotBlank
    private String nome;


}
