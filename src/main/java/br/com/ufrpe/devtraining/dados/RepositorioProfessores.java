package br.com.ufrpe.devtraining.dados;

import java.io.*;
import java.nio.charset.StandardCharsets;

import br.com.ufrpe.devtraining.negocio.entidades.Professor;

public class RepositorioProfessores implements Serializable {
    private Professor[]professores ;
    private int proxima;
    private String arquivo = "professores.txt";

    public RepositorioProfessores(int tamanho) {
        this.professores = new Professor[tamanho];
        this.proxima = 0;
    }

    // Método para cadastrar
    public void cadastrar(Professor professor) {
        if (existeProfessorComId(professor.getIdDoProfessor())) {
            System.out.println("ID já existe. Não é possível cadastrar o professor.");
            return;
        }
        this.professores[this.proxima] = professor;
        this.proxima++;
        salvarDados();

    }

    private boolean existeProfessorComId(int id) {
        return buscar(id) != null;
    }



    // Método para buscar
    public Professor buscar(int id_professor) {
        int i = 0;

        while (i < this.proxima) {
            if (id_professor==this.professores[i].getIdDoProfessor()) {
                return this.professores[i];
            }
            i++;
        }
        return null;
    }

    // Método para remover
    public void remover(int id_professor) {
        int i = 0;
        boolean achou = false;
        while ((!achou) && (i < this.proxima)) {
            if (id_professor == this.professores[i].getIdDoProfessor()) {
                achou = true;
            } else {
                i++;
            }
        }

        if (achou) {
            this.professores[i] = this.professores[this.proxima - 1];
            this.professores[this.proxima - 1] = null;
            this.proxima--;
            salvarDados();

            System.out.println("Professor " + id_professor + " removido com sucesso.");
        } else {
            System.out.println("Professor não encontrado.");
        }
    }

    // Método para alterar as informações de um professor
    public void alterar(int id_professor, Professor novoProfessor) {
        int i = 0;
        boolean achou = false;
        // Procura o professor com o ID fornecido
        while ((!achou) && (i < this.proxima)) {
            if (id_professor == this.professores[i].getIdDoProfessor()) {
                achou = true;
            } else {
                i++;
            }
        }

        // Se encontrou o professor, realiza a alteração
        if (achou) {
            this.professores[i] = novoProfessor;
            System.out.println("Professor " + id_professor + " alterado com sucesso.");

        } else {
            System.out.println("Professor não encontrado.");
        }
        salvarDados();
    }
    void salvarDados() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(arquivo))) {
            objectOutputStream.writeObject(professores);
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
            professores = (Professor[]) objectInputStream.readObject();
            proxima = professores.length;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}










