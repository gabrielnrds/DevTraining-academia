package br.com.ufrpe.devtraining.dados;


import br.com.ufrpe.devtraining.negocio.entidades.Usuario;

import java.io.Serializable;

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

//    // Buscar por idUsuario
//    public Usuario buscar(int idUsuario) {
//        int i = 0;
//        boolean achou = false;
//        while ((!achou) && (i < this.proxima)) {
//
//            //if (this.usuariosRepositorio[i].getId_usuariosRepositorio() == idUsuario) {
//                achou = true;
//            } else {
//                i = i + 1;
//            }
//        }
//
//        Usuario resultado = null;
//        if (i != this.proxima) {
//            resultado = this.usuariosRepositorio[i];
//        }
//        return resultado;
//    }

    // Remover
    public void remover(int idUsuario) {
        int i = 0;
        boolean achou = false;
        while ((!achou) && (i < this.proxima)) {
            // if (idUsuario == this.usuariosRepositorio[i].getId_usuariosRepositorio()) {
            achou = true;
            //   } else {
            i = i + 1;
            //  }
        }

        if (i != this.proxima) {
            this.usuariosRepositorio[i] = this.usuariosRepositorio[this.proxima - 1];
            this.usuariosRepositorio[this.proxima - 1] = null;
            this.proxima = this.proxima - 1;
            System.out.println("Avaliação " + idUsuario + " removida com sucesso.");
        } else {
            System.out.println("Avaliação não existe.");
        }
    }

    // Alterar
    public void alterar(int idUsuario, Usuario novoUsuario) {
        int i = 0;
        boolean achou = false;

        // Procura o professor com o ID fornecido
        while ((!achou) && (i < this.proxima)) {
            int idUsuarioRepo = (int)this.usuariosRepositorio[i].getId_usuariosRepositorio();
            if (idUsuario == idUsuarioRepo) {
                achou = true;
            } else {
                i = i + 1;
            }
        }

        // Se encontrou o Usuário, realiza a alteração
        if (achou) {
            this.usuariosRepositorio[i] = novoUsuario;
            System.out.println("Professor " + idUsuario + " alterado com sucesso.");
        } else {
            System.out.println("Professor não encontrado.");
        }
    }

    public Usuario[] getUsuariosRepositorio() {
        return usuariosRepositorio;
    }
}
