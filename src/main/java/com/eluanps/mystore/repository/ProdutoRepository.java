package com.eluanps.mystore.repository;

import com.eluanps.mystore.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
