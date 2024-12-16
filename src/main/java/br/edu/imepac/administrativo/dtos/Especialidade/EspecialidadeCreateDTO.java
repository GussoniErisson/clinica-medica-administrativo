package br.edu.imepac.administrativo.dtos.Especialidade;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EspecialidadeCreateDTO {

    private String nome;
    private String descricao;
}

