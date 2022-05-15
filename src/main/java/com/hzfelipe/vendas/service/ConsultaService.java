package com.hzfelipe.vendas.service;

import com.hzfelipe.vendas.model.Venda;
import com.hzfelipe.vendas.model.dto.ConsultaIn;
import com.hzfelipe.vendas.model.dto.VendaOut;
import com.hzfelipe.vendas.repository.VendaRepository;
import com.hzfelipe.vendas.repository.VendedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor
@Service
public class ConsultaService {

    private final VendedorRepository vendedorRepository;
    private final VendaRepository vendaRepository;


    public List<VendaOut> buscarVendasPorDatas(ConsultaIn consultaIn) {
        List<Venda> vendaList = vendaRepository.findByIdVendedor(consultaIn.getIdVendedor());
        List<VendaOut> list = new ArrayList<>();
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        Calendar datavenda = Calendar.getInstance();
        Calendar dataInicial = Calendar.getInstance();
        Calendar dataFinal = Calendar.getInstance();
        try {
            dataInicial.setTime(formatoData.parse(consultaIn.getDataInicial()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            dataFinal.setTime(formatoData.parse(consultaIn.getDataFinal()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        vendaList.forEach(consulta -> {
            try {
                datavenda.setTime(formatoData.parse(consulta.getData()));
            } catch (ParseException e) {
                e.printStackTrace();
            }

           if (datavenda.after(dataInicial) && datavenda.before(dataFinal)){
               VendaOut vendaOut = new VendaOut();
               vendaOut.setIdVendedor(consulta.getVendedor().getId());
               vendaOut.setNomeVendendor(consulta.getVendedor().getNome());
               vendaOut.setValor(consulta.getValor());
               vendaOut.setData(consulta.getData());
               vendaOut.setIdVenda(consulta.getIdVenda());
               list.add(vendaOut);
           }
        });
        return list;
    }

    public Long mediaPorDatas(ConsultaIn consultaIn) {
        List<Venda> vendaList = vendaRepository.findByIdVendedor(consultaIn.getIdVendedor());
        List<VendaOut> list = new ArrayList<>();
        List<Long> media = new ArrayList<>();
        int cont = 0;
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        Calendar datavenda = Calendar.getInstance();
        Calendar dataInicial = Calendar.getInstance();
        Calendar dataFinal = Calendar.getInstance();
        try {
            dataInicial.setTime(formatoData.parse(consultaIn.getDataInicial()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            dataFinal.setTime(formatoData.parse(consultaIn.getDataFinal()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        vendaList.forEach(consulta -> {
            try {
                datavenda.setTime(formatoData.parse(consulta.getData()));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (datavenda.after(dataInicial) && datavenda.before(dataFinal)){
                VendaOut vendaOut = new VendaOut();
                vendaOut.setValor(consulta.getValor());
                media.add(consulta.getValor());
                list.add(vendaOut);
            }
        });

        int n = media.size();
        Long valor;
        Long soma = 0l;
        for (int i = 0; i<n; i++){
            soma = media.get(i) + soma;
        }
        valor = soma/ n;
        return valor;
    }
}

