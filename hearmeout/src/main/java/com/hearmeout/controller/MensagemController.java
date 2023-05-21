package com.hearmeout.controller;


import com.hearmeout.entity.Mensagem;
import com.hearmeout.service.MensagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MensagemController {

    @Autowired
    MensagemService mensagemService;

    @PostMapping("/mensagem")
    public ResponseEntity<Mensagem> cadastrarMensagem(@RequestBody Mensagem mensagem){
        Mensagem mensagemSalva = mensagemService.salvarMensagem(mensagem);
        return ResponseEntity.ok(mensagemSalva);
    }

    @GetMapping("/mensagem/{id}")
    public ResponseEntity<Mensagem> pesquisarMensagem(@PathVariable Long id){
        Mensagem mensagemPesquisada = mensagemService.pesquisarMensagem(id);
        return ResponseEntity.ok(mensagemPesquisada);
    }

    @PutMapping("/mensagem/{id}")
    public ResponseEntity<Mensagem> atualizarMensagem(@PathVariable Long id, @RequestBody Mensagem mensagem){
        Mensagem mensagemAtualizada = mensagemService.atualizarMensagem(mensagem, id);
        return ResponseEntity.ok(mensagemAtualizada);
    }

    @DeleteMapping("/mensagem/{id}")
    public ResponseEntity<Mensagem> deletarMensagem(@PathVariable Long id){
        Mensagem mensagemDeletada = mensagemService.pesquisarMensagem(id);
        mensagemService.deletarMensagem(mensagemDeletada.getId());
        return ResponseEntity.ok(mensagemDeletada);
    }
}
