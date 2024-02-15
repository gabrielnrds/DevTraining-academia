package br.com.ufrpe.devtraining.dados;

import java.io.*;
import java.nio.charset.StandardCharsets;

import br.com.ufrpe.devtraining.negocio.entidades.Professor;

public class RepositorioProfessores implements Serializable {
    private Professor[]professores ;
    private int proxima;


    public RepositorioProfessores(int tamnho) {
        this.professores = new Professor[tamnho];
        this.proxima = 0;
    }

    // Método para cadastrar
    public void cadastrar(Professor professor) {
        if (existeProfessorComCpf(professor.getCpf())) {
            System.out.println("CPF já existe. Não é possível cadastrar o professor.");
            return;
        }
        this.professores[this.proxima] = professor;
        this.proxima++;


    }

    public boolean existeProfessorComCpf(String cpf) {
        return buscar(cpf) != null;
    }



    // Método para buscar
    public Professor buscar(String cpf) {
        int i = 0;

        while (i < this.proxima) {
            if (cpf.equals(this.professores[i].getCpf())) {
                return this.professores[i];
            }
            i++;
        }
        return null;
    }

    public Professor buscarPeloNome(String nome) {
        for (int i = 0; i < this.proxima; i++) {
            if (this.professores[i].getNome().equalsIgnoreCase(nome)) {
                return this.professores[i];
            }
        }
        return null;
    }

    // Método para remover
    public void remover(String cpf) {
        int i = 0;
        boolean achou = false;
        while ((!achou) && (i < this.proxima)) {
            if (cpf.equals(this.professores[i].getId())) {
                achou = true;
            } else {
                i++;
            }
        }

        if (achou) {
            this.professores[i] = this.professores[this.proxima - 1];
            this.professores[this.proxima - 1] = null;
            this.proxima--;


            System.out.println("Professor " + cpf + " removido com sucesso.");
        } else {
            System.out.println("Professor não encontrado.");
        }
    }

    // Método para alterar as informações de um professor
    public void alterar(String cpf, Professor novoProfessor) {
        int i = 0;
        boolean achou = false;
        // Procura o professor com o ID fornecido
        while ((!achou) && (i < this.proxima)) {
            if (cpf.equals(this.professores[i].getCpf())) {
                achou = true;
            } else {
                i++;
            }
        }

        // Se encontrou o professor, realiza a alteração
        if (achou) {
            this.professores[i] = novoProfessor;
            System.out.println("Professor " + cpf + " alterado com sucesso.");

        } else {
            System.out.println("Professor não encontrado.");
        }

    }



    public Professor[] getProfessores() {
        return professores;
    }
}










