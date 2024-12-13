package br.edu.imepac.administrativo.controller.dtos.Convenio;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConvenioCreateDto {

    private String nome;
    private String descricao;
}
