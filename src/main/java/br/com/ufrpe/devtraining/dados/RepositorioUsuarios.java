package br.com.ufrpe.devtraining.dados;


import br.com.ufrpe.devtraining.negocio.entidades.Professor;
import br.com.ufrpe.devtraining.negocio.entidades.Usuario;

import java.io.*;

public class RepositorioUsuarios implements Serializable {
    private Usuario[] usuariosRepositorio;
    private int proxima;

    private String arquivo ="Usuarios.txt";

    public RepositorioUsuarios(int tamanho) {
        this.usuariosRepositorio = new Usuario[tamanho];
        this.proxima = 0;
    }

    // Cadastrar
    public void cadastrar(Usuario usuario) {
        this.usuariosRepositorio[this.proxima] = usuario;
        this.proxima = this.proxima + 1;
        salvarDados();
    }

    // Buscar por idUsuario
    public Usuario buscar(int id_Usuario) {
        int i = 0;

        while (i < this.proxima) {
            if (id_Usuario==this.usuariosRepositorio[i].getId()) {
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
            if (id_Usuario == this.usuariosRepositorio[i].getId()) {
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
        salvarDados();
    }

    // Alterar
    public void alterar(int id_Usuario, Usuario novoUsuario) {
        int i = 0;
        boolean achou = false;

        // Procura o usuário com o ID fornecido
        while ((!achou) && (i < this.proxima)) {

            if (id_Usuario == this.usuariosRepositorio[i].getId()) {
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
        salvarDados();
    }

    void salvarDados() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(arquivo))) {
            objectOutputStream.writeObject(usuariosRepositorio);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Carrega dados do arquivo usando serialização
    void carregarDados() {
        File file = new File(arquivo);

        if (!file.exists()) {
            System.out.println("Arquivo não encontrado. Criando um novo arquivo.");
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }

        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(arquivo))) {
            usuariosRepositorio = (Usuario[])  objectInputStream.readObject();
            proxima = usuariosRepositorio.length;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



    public Usuario[] getUsuariosRepositorio() {
        return usuariosRepositorio;
    }
}
