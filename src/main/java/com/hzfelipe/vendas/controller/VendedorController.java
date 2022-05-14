package com.hzfelipe.vendas.controller;

import com.hzfelipe.vendas.model.dto.VendedorIn;
import com.hzfelipe.vendas.model.dto.VendedorOut;
import com.hzfelipe.vendas.service.VendedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class VendedorController {

    private final VendedorService vendedorService;

    @PostMapping("/vendedor")
    public ResponseEntity salvarVendedor(@Valid @RequestBody VendedorIn vendedorIn){
       vendedorService.salvaVendedor(vendedorIn);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
