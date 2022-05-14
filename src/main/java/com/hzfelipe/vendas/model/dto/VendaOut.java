package com.hzfelipe.vendas.model.dto;

import com.hzfelipe.vendas.model.Vendedor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VendaOut {

    private Long idVenda;
    private Long idVendedor;
    private String nomeVendendor;
    private Long valor;
    private String data;


   }
