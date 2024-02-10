// SaveManager.java
package br.com.ufrpe.devtraining.dados;

import java.io.*;

public class SaveManager {
    private RepositorioGeral repositorioGeral;

    public SaveManager(RepositorioGeral repositorioGeral) {
        this.repositorioGeral = repositorioGeral;
    }

    public void salvar() {
        Save save = new Save(
                repositorioGeral.getRepositorioClientes(),
                repositorioGeral.getRepositorioExercicios(),
                repositorioGeral.getUsuarioRepositorio(),
                repositorioGeral.getRepositorioTreinos(),
                repositorioGeral.getRepositorioProfessores()
        );
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("save.dat"))) {
            out.writeObject(save);
            System.out.println("Dados salvos com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    public void carregar() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("save.dat"))) {
            Save save = (Save) in.readObject();

            repositorioGeral.setRepositorioClientes(save.getRepCliente());
            repositorioGeral.setRepositorioExercicios(save.getRepExercicio());
            repositorioGeral.setRepositorioUsuarios(save.getRepUsuario());
            repositorioGeral.setRepositorioTreinos(save.getRepTreino());
            repositorioGeral.setRepositorioProfessores(save.getRepProfessor());
            System.out.println("Dados carregados com sucesso.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar os dados: " + e.getMessage());
        }
    }
}
