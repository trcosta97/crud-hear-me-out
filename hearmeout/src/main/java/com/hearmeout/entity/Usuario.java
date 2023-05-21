package com.hearmeout.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name ="table_user")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario")
    private Long id;
    @Column(name = "tipo_usuario")
    private TipoUsuario tipoUsuario;
    @Column(name = "nome_usuario")
    private  String nome;
    @Column(name = "email_usuario")
    private  String email;
    @Column(name = "senha_usuario")
    private  String senha;

}
