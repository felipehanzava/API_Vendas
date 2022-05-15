package com.hzfelipe.vendas.model.dto;


import com.sun.istack.NotNull;
import lombok.Getter;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Getter
public class ConsultaIn {


    private Long idVendedor;
    @NotBlank
    private String dataInicial;
    @NotBlank
    private String dataFinal;

    public Long getIdVendedor() {
        return idVendedor;
    }
}
