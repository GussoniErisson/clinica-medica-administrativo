package br.edu.imepac.administrativo.dtos.Perfil.FuncionarioDTO;


import br.edu.imepac.administrativo.entidades.Especialidade;
import br.edu.imepac.administrativo.entidades.Perfil;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreatedFuncionarioDTO {
    private String usuario;
    private int senha;
    private int idPaciente;
    private String nome;
    private int idade;
    private String sexo;
    private String cpf;
    private String rua;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String contato;
    private String email;
    private Date dataNascimento;

    private Perfil perfil;

    private Especialidade especialidade;
}


