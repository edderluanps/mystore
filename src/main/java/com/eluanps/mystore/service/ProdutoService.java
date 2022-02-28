package com.eluanps.mystore.service;

import com.eluanps.mystore.entity.Produto;
import com.eluanps.mystore.repository.ProdutoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Produto findById(Long id) {
        return produtoRepository.findById(id).get();
    }

    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

}