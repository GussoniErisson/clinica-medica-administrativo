package br.edu.imepac.administrativo.controller.dtos.Especialidade;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EspecialidadeCreateDto {

    private String nome;
    private String descricao;
}

