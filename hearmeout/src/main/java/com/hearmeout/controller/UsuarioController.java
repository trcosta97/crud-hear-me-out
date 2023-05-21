package com.hearmeout.controller;

import com.hearmeout.entity.Usuario;
import com.hearmeout.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/usuarios")
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario){
        Usuario usuarioSalvo = usuarioService.salvarUsuario(usuario);
        return ResponseEntity.ok(usuarioSalvo);
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> pesquisarUsuario(@PathVariable Long id){
        Usuario usuarioPesquisado = usuarioService.pesquisarUsuario(id);
        return ResponseEntity.ok(usuarioPesquisado);
    }

    @PutMapping("/usuario/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario){
        Usuario usuarioAtualizado = usuarioService.atualizarUsuario(usuario, id);
        return ResponseEntity.ok(usuarioAtualizado);
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<Usuario> deletarUsuario(@PathVariable Long id){
        Usuario usuarioDeletado = usuarioService.pesquisarUsuario(id);
        usuarioService.deletarUsuaio(usuarioDeletado.getId());
        return ResponseEntity.ok(usuarioDeletado);
    }





}
