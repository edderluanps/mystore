package com.eluanps.mystore.controller;

import com.eluanps.mystore.entity.Produto;
import com.eluanps.mystore.service.ProdutoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @RequestMapping(value = "/produtos", method = RequestMethod.GET)
    public ModelAndView getProdutos() {
        ModelAndView mv = new ModelAndView("produtos");
        List<Produto> produtos = produtoService.findAll();
        mv.addObject("produtos", produtos);
        return mv;
    }

    @RequestMapping(value = "/produtos/{id}", method = RequestMethod.GET)
    public ModelAndView getProdutosPage(@PathVariable("id") long id) {
        ModelAndView mv = new ModelAndView("produtopage");
        Produto produtos = produtoService.findById(id);
        mv.addObject("produtos", produtos);
        return mv;
    }

}
