package br.edu.imepac.administrativo.entidades;

import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Funcionario {
    @Id
    
    private long id;
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
