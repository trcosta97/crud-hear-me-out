package com.hearmeout.service;

import com.hearmeout.entity.Usuario;
import com.hearmeout.entity.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario salvarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizarUsuario(Usuario usuario, Long id){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if(usuarioOptional.isPresent()){
            Usuario usuarioAtualizado = usuarioOptional.get();
            usuarioAtualizado.setNome(usuario.getNome());
            usuarioAtualizado.setEmail(usuario.getEmail());
            usuarioAtualizado.setSenha(usuario.getSenha());
            usuarioRepository.save(usuario);
            return usuarioAtualizado;
        }
        return null;
    }

    public Usuario pesquisarUsuario(Long id){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if(usuarioOptional.isPresent()){
            return usuarioOptional.get();
        }
        return null;
    }

    public Usuario deletarUsuaio(Long id){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if(usuarioOptional.isPresent()){
            Usuario usuarioDeletado = usuarioOptional.get();
            usuarioRepository.delete(usuarioDeletado);
            return usuarioDeletado;
        }
        return null;
    }





}
