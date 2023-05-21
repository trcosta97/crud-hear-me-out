package com.hearmeout.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name ="table_conversa")
public class Conversa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_conversa")
    private Long id;
    @ManyToOne
    @JoinColumn(name="id_usuario1", nullable = false)
    private Usuario usuario1;
    @ManyToOne
    @JoinColumn(name="id_usuario2", nullable = false)
    private Usuario usuario2;
    @Column(name="data_inicio", nullable = false)
    @CreatedDate
    private LocalDate dataInicio;
    @Column(name="data_fim")
    private LocalDate dataFinal;

}
