package br.com.ufrpe.devtraining.negocio.entidades;

import java.io.Serializable;

public class Usuario extends Pessoa
        implements Serializable {

    private String nomeUsuario;
    private int idUsuario;
    private String senha;
    public Usuario(int id, String nomeUsuario, String senha) {
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.idUsuario= id;



    }

    public void login() {
        System.out.println("Usuário logado: " + nomeUsuario);//coloquei, mas talvez seja inútil.1
    }

    public void deslogar() {
        System.out.println("Usuário deslogado: " + nomeUsuario);//coloquei, mas talvez seja inútil.2
    }

    public void alterarLogin(String novoNomeUsuario, String novaSenha) {
        this.nomeUsuario = novoNomeUsuario;
        System.out.println("Login alterado para: " + nomeUsuario);//coloquei, mas talvez seja inútil.3
    }

    public Object getId_usuariosRepositorio() {
        return null;
    }



    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    @Override
    public int getId() {
        return idUsuario;
    }
}