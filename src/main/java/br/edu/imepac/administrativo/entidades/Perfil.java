package br.edu.imepac.administrativo.entidades;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "perfis")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;

    @Column(name = "cadastrar_funcionario")
    private boolean cadastrarFuncionario;
    @Column(name = "ler_funcionario")
    private boolean lerFuncionario;
    @Column(name = "atualizar_funcionario")
    private boolean atualizarFuncionario;
    @Column(name = "deletar_funcionario")
    private boolean deletarFuncionario;
    @Column(name = "listar_funcionario")
    private boolean listarFuncionario;
    @Column(name = "cadastrar_paciente")
    private boolean cadastrarPaciente;
    @Column(name = "ler-paciente")
    private boolean lerPaciente;
    @Column(name = "atualizar-paciente")
    private boolean atualizarPaciente;
    @Column(name = "deletar-paciente")
    private boolean deletarPaciente;
    @Column(name = "listar-paciente")
    private boolean listarPaciente;
    @Column(name = "cadastrar-formulario")
    private boolean cadastrarFormulario;
    @Column(name = "ler-formulario")
    private boolean lerFormulario;
    @Column(name = "atualizar-formulario")
    private boolean atualizarFormulario;
    @Column(name = "deletar-formulario")
    private boolean deletarFormulario;
    @Column(name = "listar-formulario")
    private boolean listarFormulario;
    @Column(name = "cadastrar-especialidade")
    private boolean cadastrarEspecialidade;
    @Column(name = "ler-especialidade")
    private boolean lerEspecialidade;
    @Column(name = "atualizar-especialidade")
    private boolean atualizarEspecialidade;
    @Column(name = "deletar-especialidade")
    private boolean deletarEspecialidade;
    @Column(name = "listar-especialidade")
    private boolean listarEspecialidade;
    @Column(name = "cadastrar-convenio")
    private boolean cadastrarConvenio;
    @Column(name = "ler-convenio")
    private boolean lerConvenio;
    @Column(name = "atualizar-convenio")
    private boolean atualizarConvenio;
    @Column(name = "deletar-convenio")
    private boolean deletarConvenio;
    @Column(name = "listar-convenio")
    private boolean listarConvenio;

}
