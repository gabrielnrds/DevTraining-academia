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
        if (existeProfessorComId(professor.getId())) {
            System.out.println("ID já existe. Não é possível cadastrar o professor.");
            return;
        }
        this.professores[this.proxima] = professor;
        this.proxima++;


    }

    private boolean existeProfessorComId(int id) {
        return buscar(id) != null;
    }



    // Método para buscar
    public Professor buscar(int id_professor) {
        int i = 0;

        while (i < this.proxima) {
            if (id_professor==this.professores[i].getId()) {
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
            if (id_professor == this.professores[i].getId()) {
                achou = true;
            } else {
                i++;
            }
        }

        if (achou) {
            this.professores[i] = this.professores[this.proxima - 1];
            this.professores[this.proxima - 1] = null;
            this.proxima--;


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
            if (id_professor == this.professores[i].getId()) {
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

    }


    public Professor[] getProfessores() {
        return professores;
    }
}










