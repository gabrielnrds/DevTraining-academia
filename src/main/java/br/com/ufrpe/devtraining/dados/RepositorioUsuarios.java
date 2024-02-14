package br.com.ufrpe.devtraining.dados;


import br.com.ufrpe.devtraining.negocio.entidades.Usuario;

import java.io.*;

public class RepositorioUsuarios implements Serializable {
    private Usuario[] usuariosRepositorio;
    private int proxima;



    public RepositorioUsuarios(int tamanho) {
        this.usuariosRepositorio = new Usuario[tamanho];
        this.proxima = 0;
    }

    // Cadastrar
    public void cadastrar(Usuario usuario) {
        this.usuariosRepositorio[this.proxima] = usuario;
        this.proxima = this.proxima + 1;

    }

    // Buscar por idUsuario
    public Usuario buscar(int id_Usuario) {
        int i = 0;

        while (i < this.proxima) {
            if (id_Usuario==this.usuariosRepositorio[i].getIdUsuario()) {
                return this.usuariosRepositorio[i];
            }
            i++;
        }
        return null;
    }

    // Remover
    public void remover(int id_Usuario) {
        int i = 0;
        boolean achou = false;
        while ((!achou) && (i < this.proxima)) {
            if (id_Usuario == this.usuariosRepositorio[i].getIdUsuario()) {
                achou = true;
            } else {
                i = i + 1;
            }
        }

        if (i != this.proxima) {
            this.usuariosRepositorio[i] = this.usuariosRepositorio[this.proxima - 1];
            this.usuariosRepositorio[this.proxima - 1] = null;
            this.proxima = this.proxima - 1;
            System.out.println("Avaliação " + id_Usuario + " removida com sucesso.");
        } else {
            System.out.println("Avaliação não existe.");
        }

    }

    // Alterar
    public void alterar(int id_Usuario, Usuario novoUsuario) {
        int i = 0;
        boolean achou = false;

        // Procura o usuário com o ID fornecido
        while ((!achou) && (i < this.proxima)) {

            if (id_Usuario == this.usuariosRepositorio[i].getIdUsuario()) {
                achou = true;
            } else {
                i = i + 1;
            }
        }

        // Se encontrou o Usuário, realiza a alteração
        if (achou) {
            this.usuariosRepositorio[i] = novoUsuario;
            System.out.println("Professor " + id_Usuario + " alterado com sucesso.");
        } else {
            System.out.println("Professor não encontrado.");
        }

    }





    public void setUsuariosRepositorio(Usuario[] usuariosRepositorio) {
        this.usuariosRepositorio = usuariosRepositorio;
    }

    public Usuario[] getUsuarioRepositorio() {
        return usuariosRepositorio;
    }
}
