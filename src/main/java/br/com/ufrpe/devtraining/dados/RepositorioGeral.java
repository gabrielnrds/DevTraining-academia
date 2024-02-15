package br.com.ufrpe.devtraining.dados;

import br.com.ufrpe.devtraining.negocio.entidades.Usuario;

import java.io.Serializable;


public class RepositorioGeral implements Serializable {
    private RepositorioProfessores repositorioProfessores;
    private RepositorioUsuarios repositorioUsuarios;
    private RepositorioClientes repositorioClientes;
    private RepositorioExercicios repositorioExercicios;
    private RepositorioTreinos repositorioTreinos;
    public RepositorioGeral(){
        this.repositorioClientes= new RepositorioClientes(1000);
        this.repositorioExercicios= new RepositorioExercicios(1000);
        this.repositorioProfessores = new RepositorioProfessores(1000);
        this.repositorioTreinos =new RepositorioTreinos(1000);
        this.repositorioUsuarios = new RepositorioUsuarios(1000);
    }

    public RepositorioProfessores getRepositorioProfessores() {
        return repositorioProfessores;
    }

    public RepositorioUsuarios getUsuarioRepositorio() {

        return repositorioUsuarios;
    }

    public RepositorioClientes getRepositorioClientes() {

        return repositorioClientes;
    }

    public RepositorioExercicios getRepositorioExercicios() {

        return repositorioExercicios;
    }

    public RepositorioTreinos getRepositorioTreinos() {

        return repositorioTreinos;
    }

    public void setRepositorioProfessores(RepositorioProfessores repositorioProfessores) {
        this.repositorioProfessores = repositorioProfessores;
    }

    public void setRepositorioUsuarios(RepositorioUsuarios repositorioUsuarios) {
        this.repositorioUsuarios = repositorioUsuarios;
    }

    public void setRepositorioClientes(RepositorioClientes repositorioClientes) {
        this.repositorioClientes = repositorioClientes;
    }

    public void setRepositorioExercicios(RepositorioExercicios repositorioExercicios) {
        this.repositorioExercicios = repositorioExercicios;
    }

    public void setRepositorioTreinos(RepositorioTreinos repositorioTreinos) {
        this.repositorioTreinos = repositorioTreinos;
    }
}
