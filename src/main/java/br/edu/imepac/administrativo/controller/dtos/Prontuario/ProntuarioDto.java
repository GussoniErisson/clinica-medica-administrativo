package br.edu.imepac.administrativo.controller.dtos.Prontuario;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProntuarioDto {

    private int id;
    private String nome;
    private String descricao;
}
