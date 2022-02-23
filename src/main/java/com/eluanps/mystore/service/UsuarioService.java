package com.eluanps.mystore.service;

import com.eluanps.mystore.entity.Usuario;
import com.eluanps.mystore.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class UsuarioService {
    
    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).get();
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    
   public void delete(Long id){
        findById(id);
        usuarioRepository.deleteById(id);
   }
   
}
