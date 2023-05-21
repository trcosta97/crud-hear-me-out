package com.hearmeout.controller;

import com.hearmeout.entity.Conversa;
import com.hearmeout.service.ConversaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ConveraController {

    @Autowired
    ConversaService conversaService;

    @PostMapping("/conversa")
    public ResponseEntity<Conversa> cadastrarConversa(@RequestBody Conversa conversa){
        Conversa conversaSalva = conversaService.salvarConversa(conversa);
        return ResponseEntity.ok(conversaSalva);
    }

    @GetMapping("/conversa/{id}")
    public ResponseEntity<Conversa> pesquisarConversa(@PathVariable Long id){
        Conversa conversaPesquisada = conversaService.pesquisarConversa(id);
        return ResponseEntity.ok(conversaPesquisada);
    }

    @PutMapping("/conversa/{id}")
    public ResponseEntity<Conversa> atualizarConversa(@PathVariable Long id, @RequestBody Conversa conversa){
        Conversa conversaAtualizada = conversaService.atualizarConversa(conversa, id);
        return ResponseEntity.ok(conversaAtualizada);
    }

    @DeleteMapping("/conversa/{id}")
    public ResponseEntity<Conversa> deletarConversa(@PathVariable Long id){
        Conversa conversaDeletada = conversaService.pesquisarConversa(id);
        conversaService.deletarConversa(conversaDeletada.getId());
        return ResponseEntity.ok(conversaDeletada);
    }
}
