package br.edu.imepac.administrativo.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "funcionarios")
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
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

    @Enumerated(EnumType.STRING)
    private EnumTipoFuncionario tipoFuncionario;


    @OneToOne
    private Perfil perfil;

    @OneToOne
    private Especialidade especialidade;
}
