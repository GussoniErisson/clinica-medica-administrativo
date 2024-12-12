package br.edu.imepac.administrativo.entidades;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "funcionarios")
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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



    @ManyToOne
    @JoinColumn(name = "perfil")
    private Perfil perfil;

    @ManyToOne
    @JoinColumn(name = "especialidade")
    private Especialidade especialidade;
}
