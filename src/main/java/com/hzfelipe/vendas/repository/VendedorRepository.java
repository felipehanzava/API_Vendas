package com.hzfelipe.vendas.repository;

import com.hzfelipe.vendas.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendedorRepository extends JpaRepository <Vendedor, Long> {
}
