package br.edu.imepac.administrativo.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import lombok.*;



@Entity
@Table(name = "especialidades")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class Especialidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String nome;

    @Column(nullable = true, length = 200)
    private String descricao;

    @Column(name = "api_key")
    private String apiKey;


}