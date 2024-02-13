// SaveManager.java
package br.com.ufrpe.devtraining.dados;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

public class SaveManager {
    private RepositorioGeral repositorioGeral;
    private Path caminhoSave;

    public SaveManager(RepositorioGeral repositorioGeral) {
        this.repositorioGeral = repositorioGeral;
        definirCaminhoSave();
    }

    private void definirCaminhoSave() {
        String caminhoAppData = System.getenv("AppData");
        caminhoSave = Paths.get(caminhoAppData, "..", "Local", "DadosRepositorio", "Saves", "Save.dat").normalize();

        try {
            Files.createDirectories(caminhoSave.getParent());
            System.out.println("Diretório criado em: " + caminhoSave.getParent());
        } catch (IOException e) {
            System.out.println("Não foi possível criar o diretório: " + e.getMessage());
        }
    }

    public void salvar() {
        Save save = new Save(
                repositorioGeral.getRepositorioClientes(),
                repositorioGeral.getRepositorioExercicios(),
                repositorioGeral.getUsuarioRepositorio(),
                repositorioGeral.getRepositorioTreinos(),
                repositorioGeral.getRepositorioProfessores()
        );

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(caminhoSave.toFile()))) {
            out.writeObject(save);
            System.out.println("Dados salvos com sucesso em: " + caminhoSave);
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    public void carregar() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(caminhoSave.toFile()))) {
            Save save = (Save) in.readObject();

            repositorioGeral.setRepositorioClientes(save.getRepCliente());
            repositorioGeral.setRepositorioExercicios(save.getRepExercicio());
            repositorioGeral.setRepositorioUsuarios(save.getRepUsuario());
            repositorioGeral.setRepositorioTreinos(save.getRepTreino());
            repositorioGeral.setRepositorioProfessores(save.getRepProfessor());
            System.out.println("Dados carregados com sucesso de: " + caminhoSave);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar os dados: " + e.getMessage());
        }
    }
}

