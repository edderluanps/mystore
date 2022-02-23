package com.eluanps.mystore.controller;

import com.eluanps.mystore.entity.Usuario;
import com.eluanps.mystore.service.UsuarioService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView getUser() {
        ModelAndView mv = new ModelAndView("usuario");
        List<Usuario> usuario = usuarioService.findAll();
        mv.addObject("usuario", usuario);
        return mv;
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ModelAndView getUserPage(@PathVariable("id") long id) {
        ModelAndView mv = new ModelAndView("usuariopage");
        Usuario usuario = usuarioService.findById(id);
        mv.addObject("usuario", usuario);
        return mv;
    }

    @RequestMapping(value = "/novouser", method = RequestMethod.GET)
    public String getUserForm() {
        return "novousuario";
    }

    @RequestMapping(value = "/novouser", method = RequestMethod.POST)
    public String saveUser(@Valid Usuario usuario, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
            return "redirect:/novousuario";
        }
        usuarioService.save(usuario);
        return "redirect:/usuario";
    }

}
