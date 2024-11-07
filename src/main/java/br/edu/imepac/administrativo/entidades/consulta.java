package br.edu.imepac.administrativo.entidades;

import jakarta.persistence.Id;

import java.time.LocalDateTime;

public class consulta {
    private int id;
    private LocalDateTime dataHorario;

    private String sintomas;

    private boolean eRetorno;

    private boolean estaAtiva;
}
