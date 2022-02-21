package com.eluanps.mystore.service;

import com.eluanps.mystore.entity.Produto;
import com.eluanps.mystore.repository.ProdutoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService implements GenericService{
    
    @Autowired
    ProdutoRepository produtoRepository;

    @Override
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    @Override
    public Produto findById(Long id) {
        return produtoRepository.findById(id).get();
    }

    @Override
    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }
    
}
