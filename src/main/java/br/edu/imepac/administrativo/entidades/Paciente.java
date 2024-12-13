package br.edu.imepac.administrativo.entidades;

import java.util.Date;

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
}
