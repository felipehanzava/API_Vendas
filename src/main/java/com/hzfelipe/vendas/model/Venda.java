package com.hzfelipe.vendas.model;

import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@Entity
public class Venda {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idVenda;

    @ManyToOne
    @JoinColumn(name ="idVendedor", nullable = false)
    private Vendedor vendedor;

    @NotNull
    private String nomeVendededor;

    @NotBlank
    @DateTimeFormat
    private String data;

    @NotNull
    private Long valor;


}
