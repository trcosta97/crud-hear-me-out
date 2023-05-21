package com.hearmeout.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name ="table_mensagem")
public class Mensagem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_mensagem", nullable = false)
    private Long id;
    @JoinColumn(name = "id_conversa", nullable = false)
    @ManyToOne
    private Conversa conversa;
    @JoinColumn(name = "id_usuario", nullable = false)
    @ManyToOne
    private Usuario usuario;
    @Column(name = "tipo", nullable = false)
    private String conteudo;
    @Column(name = "tipo", nullable = false)
    private String tipo;
    @Column(name="data_envio", nullable = false)
    @CreationTimestamp
    private LocalDate dataEnvio;

}
