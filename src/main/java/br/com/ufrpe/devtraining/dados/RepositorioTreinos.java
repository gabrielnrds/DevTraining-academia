package br.com.ufrpe.devtraining.dados;

import br.com.ufrpe.devtraining.negocio.entidades.FichaTreino;

import java.io.*;

public class RepositorioTreinos implements Serializable {
    private FichaTreino[] fichasTreino;
    private String arquivo ="Ficha_Treino.txt";
    private int proximo;

    public RepositorioTreinos(int tamanho) {
        this.fichasTreino = new FichaTreino[tamanho];
        this.proximo = 0;
    }

    public void cadastrar(FichaTreino fichaTreino) {
        if (this.proximo < this.fichasTreino.length) {
            this.fichasTreino[this.proximo] = fichaTreino;
            this.proximo++;
            System.out.println("Ficha de treino cadastrada com sucesso.");
        } else {
            System.out.println("Não é possível cadastrar mais fichas. Repositório cheio.");
        }
    }

    public FichaTreino buscar(int idTreino) {
        for (int i = 0; i < this.proximo; i++) {
            if (idTreino == this.fichasTreino[i].getIdTreino()) {
                return this.fichasTreino[i];
            }
        }
        System.out.println("Ficha de treino não encontrada.");
        return null;
    }

    public void remover(int idTreino) {
        int indiceRemover = -1;
        for (int i = 0; i < this.proximo; i++) {
            if (idTreino == this.fichasTreino[i].getIdTreino()) {
                indiceRemover = i;
                break;
            }
        }

        if (indiceRemover != -1) {
            this.proximo--;
            this.fichasTreino[indiceRemover] = this.fichasTreino[this.proximo];
            this.fichasTreino[this.proximo] = null;
            System.out.println("Ficha de treino removida com sucesso.");
        } else {
            System.out.println("Ficha de treino não encontrada.");
        }
        salvarDados();
    }

    public void alterar(int idTreino, FichaTreino novaFichaTreino) {
        int indiceAlterar = -1;

        // Encontrar o índice da ficha de treino a ser alterada
        for (int i = 0; i < this.proximo; i++) {
            if (idTreino == this.fichasTreino[i].getIdTreino()) {
                indiceAlterar = i;
                break;
            }
        }

        if (indiceAlterar != -1) {
            // Atualizar os dados da ficha de treino no índice encontrado
            this.fichasTreino[indiceAlterar] = novaFichaTreino;
            System.out.println("Ficha de treino alterada com sucesso.");
        } else {
            System.out.println("Ficha de treino não encontrada. Não foi possível realizar a alteração.");
        }
        salvarDados();
    }

    void salvarDados() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(arquivo))) {
            objectOutputStream.writeObject(fichasTreino);
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
    }
}