package com.hzfelipe.vendas.controller;

import com.hzfelipe.vendas.model.dto.VendaIn;
import com.hzfelipe.vendas.model.dto.VendaOut;
import com.hzfelipe.vendas.service.VendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class VendaController {

    private final VendaService vendaService;


    @PostMapping("/venda")
    public ResponseEntity<VendaOut> salvaVenda(@Valid @RequestBody VendaIn vendaIn){
        VendaOut vendaOut = vendaService.salvaVenda(vendaIn);
        return ResponseEntity.status(HttpStatus.CREATED).body(vendaOut);
    }

    @GetMapping("/buscarVendas/{idVendedor}")
    public List<VendaOut> buscaVendasPorIdVendedor(@PathVariable Long idVendedor){
        return vendaService.buscaVendasPorIdVendedor(idVendedor);
    }
}
