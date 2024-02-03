package br.com.ufrpe.devtraining.dados;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

import br.com.ufrpe.devtraining.negocio.entidades.Professor;

public class RepositorioProfessores {
    private Professor[] professores;
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

        if (this.proxima == this.professores.length) {
            this.duplicaArrayContas();
        }
        salvarDados();
    }

    private boolean existeProfessorComId(long id) {
        return buscar(id) != null;
    }

    // Método para duplicar o array caso fique cheio
    private void duplicaArrayContas() {
        if (this.professores != null && this.professores.length > 0) {
            Professor[] arrayDuplicado = new Professor[this.professores.length * 2];
            System.arraycopy(this.professores, 0, arrayDuplicado, 0, this.professores.length);
            this.professores = arrayDuplicado;
        }
    }

    // Método para buscar
    public Professor buscar(long id_professor) {
        int i = 0;
        while (i < this.proxima) {
            long idProfessorWrapper = this.professores[i].getIdDoProfessor();
            if (id_professor == idProfessorWrapper) {
                return this.professores[i];
            }
            i++;
        }
        return null;
    }

    // Método para remover
    public void remover(long id_professor) {
        int i = 0;
        boolean achou = false;
        while ((!achou) && (i < this.proxima)) {
            long idProfessorWrapper = this.professores[i].getIdDoProfessor();
            if (id_professor == idProfessorWrapper) {
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
    public void alterar(long id_professor, Professor novoProfessor) {
        int i = 0;
        boolean achou = false;

        // Procura o professor com o ID fornecido
        while ((!achou) && (i < this.proxima)) {
            long idProfessorWrapper = this.professores[i].getIdDoProfessor();
            if (id_professor == idProfessorWrapper) {
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

    // Salva os dados no arquivo
    void salvarDados() {
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(arquivo), StandardCharsets.UTF_8))) {
            for (int i = 0; i < proxima; i++) {
                writer.write(professores[i].toFormattedString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Carrega dados do arquivo
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

        // Usando try-with-resources para garantir que o BufferedReader seja fechado automaticamente
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                Professor professor = criarProfessorAPartirDaLinha(linha);
                cadastrar(professor);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para criar Professor a partir da linha
    // Método auxiliar para criar um Professor a partir de uma linha do arquivo
    private Professor criarProfessorAPartirDaLinha(String linha) {
        try {
            String[] dados = linha.split("\\s+");
            if (dados.length >= 9) {
                long id = Long.parseLong(dados[0].trim());
                String nome = dados[1].trim();
                String telefone = dados[2].trim();
                String email = dados[3].trim();
                String cpf = dados[4].trim();

                if (dados[5].matches("\\d+") && dados[6].matches("\\d+")) {
                    int idade = Integer.parseInt(dados[5].trim());
                    int codigo = Integer.parseInt(dados[6].trim());
                    String turno = dados[7].trim();

                    // Trate possíveis vírgulas em valores numéricos
                    String salarioString = dados[8].replaceAll(",", ".");
                    double salario = Double.parseDouble(salarioString);

                    return new Professor(id, nome, telefone, email, cpf, salarioString, idade, turno, salario);
                } else {
                    throw new IllegalArgumentException("Formato de linha inválido: " + linha);
                }
            } else {
                throw new IllegalArgumentException("Formato de linha inválido: " + linha);
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Erro ao converter dados da linha: " + linha, e);
        }
    }
}
