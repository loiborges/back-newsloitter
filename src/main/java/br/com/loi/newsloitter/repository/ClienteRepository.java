package br.com.loi.newsloitter.repository;

import br.com.loi.newsloitter.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query(nativeQuery = true, value = "" +
            "SELECT * FROM loi.cliente WHERE ID_CATEGORIA = :idCategoria")
    List<Cliente> findAllClientesByCategoria(@Param("idCategoria") Integer idCategoria);
}
