// Save.java
package br.com.ufrpe.devtraining.dados;

import java.io.Serializable;

public class Save implements Serializable {
    private RepositorioClientes repCliente;
    private RepositorioExercicios repExercicio;
    private RepositorioUsuarios repUsuario;
    private RepositorioTreinos repTreino;
    private RepositorioProfessores repProfessor;

    public Save(RepositorioClientes repositorioClientes, RepositorioExercicios repositorioExercicios, RepositorioUsuarios repositorioUsuarios, RepositorioTreinos repositorioTreinos, RepositorioProfessores repositorioProfessores) {
        this.repCliente = repositorioClientes;
        this.repExercicio = repositorioExercicios;
        this.repUsuario = repositorioUsuarios;
        this.repTreino = repositorioTreinos;
        this.repProfessor = repositorioProfessores;
    }

    public RepositorioClientes getRepCliente() {
        return repCliente;
    }

    public RepositorioExercicios getRepExercicio() {
        return repExercicio;
    }

    public RepositorioUsuarios getRepUsuario() {
        return repUsuario;
    }

    public RepositorioTreinos getRepTreino() {
        return repTreino;
    }

    public RepositorioProfessores getRepProfessor() {
        return repProfessor;
    }
}
