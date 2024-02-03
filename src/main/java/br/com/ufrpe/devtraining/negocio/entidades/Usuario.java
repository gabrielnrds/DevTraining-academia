package br.com.ufrpe.devtraining.negocio.entidades;

public class Usuario {

    private String nomeUsuario;
    public Usuario(int idUsuario, String nomeUsuario, String senha) {
        this.nomeUsuario = nomeUsuario;
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
}