package br.com.ufrpe.devtraining.dados;

import br.com.ufrpe.devtraining.negocio.entidades.Usuario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RepositorioGeral implements Serializable {
    private RepositorioProfessores repositorioProfessores;
    private List<Usuario> repositorioUsuarios;
    private RepositorioClientes repositorioClientes;
    private RepositorioExercicios repositorioExercicios;
    private RepositorioTreinos repositorioTreinos;
    public RepositorioGeral(){
        this.repositorioClientes= new RepositorioClientes(100);
        this.repositorioExercicios= new RepositorioExercicios(100);
        this.repositorioProfessores = new RepositorioProfessores(100);
        this.repositorioTreinos =new RepositorioTreinos(100);
        this.repositorioUsuarios = new ArrayList<>();
    }

    public RepositorioProfessores getRepositorioProfessores() {
        return repositorioProfessores;
    }

    public List<Usuario> getRepositorioUsuarios() {

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
}