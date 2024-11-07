package br.edu.imepac.administrativo.entidades;

public class Prontuario {
    private int id;
    private String receituario;
    private String exames;
    private String observacoes;


    public Prontuario(int id, String receituario, String exames, String observacoes) {
        this.id = id;
        this.receituario = receituario;
        this.exames = exames;
        this.observacoes = observacoes;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReceituario() {
        return receituario;
    }

    public void setReceituario(String receituario) {
        this.receituario = receituario;
    }

    public String getExames() {
        return exames;
    }

    public void setExames(String exames) {
        this.exames = exames;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }


    @Override
    public String toString() {
        return "br.edu.imepac.administrativo.entidades.prontuarios{" +
                "id=" + id +
                ", receituario='" + receituario + '\'' +
                ", exames='" + exames + '\'' +
                ", observacoes='" + observacoes + '\'' +
                '}';
    }
}