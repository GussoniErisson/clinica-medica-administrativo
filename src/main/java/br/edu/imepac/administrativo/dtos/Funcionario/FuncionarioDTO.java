package br.edu.imepac.administrativo.dtos.FuncionarioDTO;

import br.edu.imepac.administrativo.entidades.EnumTipoFuncionario;
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
public class FuncionarioDTO {

    private int id;
    private String usuario;
    private int senha;
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
    private EnumTipoFuncionario tipoFuncionario;

    private Perfil perfil;

    private Especialidade especialidade;
}


