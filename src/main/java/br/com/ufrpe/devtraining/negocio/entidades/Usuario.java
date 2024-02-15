// Usuario.java
package br.com.ufrpe.devtraining.negocio.entidades;

import br.com.ufrpe.devtraining.dados.IDManager;

import java.io.Serializable;

public class Usuario implements Serializable {
    private static final IDManager idManager = new IDManager();

    private int idUsuario;
    private String nomeUsuario;
    private String senha;

    public Usuario(String nomeUsuario, String senha) {
        this.idUsuario = proximoId();
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
    }

    private static int proximoId() {
        int proximoId = idManager.getLastUsuarioID() + 1;
        idManager.setLastUsuarioID(proximoId); // Atualiza o IDManager com o próximo ID
        return proximoId;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    @Override
    public String toString(){
        return "Usuário-Id:"+idUsuario+", Nome:"+nomeUsuario+", Senha:"+senha;
    }
}
