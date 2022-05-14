package com.hzfelipe.vendas.service;

import com.hzfelipe.vendas.model.Venda;
import com.hzfelipe.vendas.model.Vendedor;
import com.hzfelipe.vendas.model.dto.VendaIn;
import com.hzfelipe.vendas.model.dto.VendaOut;
import com.hzfelipe.vendas.model.dto.VendedorOut;
import com.hzfelipe.vendas.repository.VendaRepository;
import com.hzfelipe.vendas.repository.VendedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class VendaService {

    private final VendedorRepository vendedorRepository;
    private final VendaRepository vendaRepository;

    public VendaOut salvaVenda(VendaIn vendaIn){
        VendaOut vendaOut = null;
        try{Optional<Vendedor> vendedor = vendedorRepository.findById(vendaIn.getIdVendedor());
            String data = vendaIn.getData();
            String valor = vendaIn.getValor();
            Venda venda = new Venda(null, vendedor.get(), vendedor.get().getNome(),data, valor);
            venda = vendaRepository.save(venda);

            vendaOut = new VendaOut(venda.getIdVenda(), vendedor.get().getId(), vendedor.get().getNome(),data, valor);
        } catch (NoSuchElementException exception){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return vendaOut;
    }

    public List<VendaOut> buscaVendasPorIdVendedor(Long idVendedor){
        List<Venda> vendaList = vendaRepository.findByIdVendedor(idVendedor);
        List<VendaOut> list = new ArrayList<>();

         vendaList.forEach(vendas -> {
             VendaOut vendaOut = new VendaOut();
             vendaOut.setIdVendedor(vendas.getVendedor().getId());
             vendaOut.setNomeVendendor(vendas.getVendedor().getNome());
             vendaOut.setValor(vendas.getValor());
             vendaOut.setData(vendas.getData());
             vendaOut.setIdVenda(vendas.getIdVenda());
             list.add(vendaOut);
         });

        return list;
    }
}
