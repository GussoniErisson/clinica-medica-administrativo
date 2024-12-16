package br.edu.imepac.administrativo.dtos.Convenio;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConvenioDTO {

    private int id;
    private String nome;
    private String descricao;
}
