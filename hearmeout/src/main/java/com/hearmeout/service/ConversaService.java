package com.hearmeout.service;

import com.hearmeout.entity.Conversa;
import com.hearmeout.entity.repository.ConversaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConversaService {

    @Autowired
    ConversaRepository conversaRepository;

    public Conversa salvarConversa(Conversa conversa){
        return conversaRepository.save(conversa);
    }

    public Conversa atualizarConversa(Conversa conversa, Long id){
        Optional<Conversa> conversaOp = conversaRepository.findById(id);
        if(conversaOp.isPresent()){
            Conversa conversaAtualizada = conversaOp.get();
            conversaAtualizada.setUsuario1(conversa.getUsuario1());
            conversaAtualizada.setUsuario2(conversa.getUsuario2());
            conversaAtualizada.setDataInicio(conversa.getDataInicio());
            conversaAtualizada.setDataFinal(conversa.getDataFinal());
            conversaRepository.save(conversa);
            return conversaAtualizada;
        }
        return null;
    }

    public Conversa pesquisarConversa(Long id){
        Optional<Conversa> conversaOptional = conversaRepository.findById(id);
        if(conversaOptional.isPresent()){
            return conversaOptional.get();
        }
        return null;
    }

    public Conversa deletarConversa(Long id){
        Optional<Conversa> conversaOptional = conversaRepository.findById(id);
        if(conversaOptional.isPresent()){
            Conversa conversaDeletado = conversaOptional.get();
            conversaRepository.delete(conversaDeletado);
            return conversaDeletado;
        }
        return null;
    }
}
