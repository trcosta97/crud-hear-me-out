package com.hearmeout.service;

import com.hearmeout.entity.Mensagem;
import com.hearmeout.entity.repository.MensagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MensagemService {

    @Autowired
    MensagemRepository mensagemRepository;

    public Mensagem salvarMensagem(Mensagem mensagem){
        return mensagemRepository.save(mensagem);
    }

    public Mensagem atualizarMensagem(Mensagem mensagem, Long id){
        Optional<Mensagem> mensagemOptional = mensagemRepository.findById(id);
        if(mensagemOptional.isPresent()){
            Mensagem mensagemAtualizado = mensagemOptional.get();
            mensagemAtualizado.setUsuario(mensagem.getUsuario());
            mensagemAtualizado.setTipo(mensagem.getTipo());
            mensagemAtualizado.setConteudo(mensagem.getConteudo());
            mensagemAtualizado.setConversa(mensagem.getConversa());
            mensagemAtualizado.setDataEnvio(mensagem.getDataEnvio());
            mensagemRepository.save(mensagem);
            return mensagemAtualizado;
        }
        return null;
    }

    public Mensagem pesquisarMensagem(Long id){
        Optional<Mensagem> mensagemOptional = mensagemRepository.findById(id);
        if(mensagemOptional.isPresent()){
            return mensagemOptional.get();
        }
        return null;
    }

    public Mensagem deletarMensagem(Long id){
        Optional<Mensagem> mensagemOptional = mensagemRepository.findById(id);
        if(mensagemOptional.isPresent()){
            Mensagem mensagemDeletado = mensagemOptional.get();
            mensagemRepository.delete(mensagemDeletado);
            return mensagemDeletado;
        }
        return null;
    }

}
