package com.hzfelipe.vendas.service;

import com.hzfelipe.vendas.model.Vendedor;
import com.hzfelipe.vendas.model.dto.VendedorIn;
import com.hzfelipe.vendas.repository.VendedorRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class VendedorService {

    private final VendedorRepository vendedorRepository;
    private final ModelMapper modelMapper;

    public void salvaVendedor(VendedorIn vendedorIn){
        Vendedor vendedor = modelMapper.map(vendedorIn, Vendedor.class);
        vendedorRepository.save(vendedor);
    }

}
