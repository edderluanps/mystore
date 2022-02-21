package com.eluanps.mystore.service;

import com.eluanps.mystore.entity.Produto;
import java.util.List;

public interface GenericService {

    List<Produto> findAll();

    Produto findById(Long id);

    Produto save(Produto produto);

}
