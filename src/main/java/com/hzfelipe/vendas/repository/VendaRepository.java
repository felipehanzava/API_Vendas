package com.hzfelipe.vendas.repository;

import com.hzfelipe.vendas.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long > {

    @Query(value = "SELECT * FROM Venda WHERE id_vendedor =?", nativeQuery = true)
    List<Venda> findByIdVendedor(@Param("idVendedor") Long idVendedor);
}
