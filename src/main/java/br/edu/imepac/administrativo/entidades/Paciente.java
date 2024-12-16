package br.edu.imepac.administrativo.entidades;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {

    private String nome, sexo, rua, numero, complemento, bairro, cidade, estado, contato, email;
    private Float id, idade, cpf;
    private Date data_nascimento;

    @Enumerated(EnumType.STRING)
    @Column(name = "Paciente")
    private Paciente Paciente;

    @ManyToOne
    private Paciente paciente;

    @ManyToOne
    private consulta consulta;

    @ManyToOne
    private Convenio convenio;

    @ManyToOne
    private Prontuario prontuario;

}
