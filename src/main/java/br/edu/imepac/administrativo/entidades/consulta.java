package br.edu.imepac.administrativo.entidades;

import jakarta.persistence.Column;

import jakarta.persistence.*;
import jakarta.time.LocalDateTime;

@Entity
@Table(name = "consultas") // Nome da tabela no banco de dados (opcional)
public class Consulta {

    @Id // Define o campo 'id' como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração automática do valor de 'id', com base no banco de dados (Auto Increment)
    private int id;

    @Column(name = "data_horario", nullable = false) // Nome da coluna e obrigatoriedade do campo
    private LocalDateTime dataHorario;

    @Column(name = "sintomas", length = 255) // Define o nome da coluna e o tamanho máximo do texto
    private String sintomas;

    @Column(name = "e_retorno") // Nome da coluna
    private boolean eRetorno;

    @Column(name = "esta_ativa") // Nome da coluna
    private boolean estaAtiva;