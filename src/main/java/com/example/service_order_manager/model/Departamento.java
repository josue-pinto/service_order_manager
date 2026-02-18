package com.example.service_order_manager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(name = "nome_extenso")
    private String nomeExtenso;

    private String gerente;
    private String andar;

    @Column(name = "email_setor")
    private String emailSetor;
}
