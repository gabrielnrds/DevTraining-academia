package br.com.ufrpe.devtraining.dados;

import br.com.ufrpe.devtraining.negocio.entidades.Exercicio;

public class RepositorioExercicios {
    private Exercicio[] exercicios;
    private int proxima;
    public RepositorioExercicios(int tamanho) {
        this.exercicios = new Exercicio[tamanho];
        this.proxima = 0;
    }

    public void cadastrar(Exercicio c) {
        this.exercicios[this.proxima] = c;
        this.proxima = this.proxima + 1;
    }

    public Exercicio procurar(String num) {
        int i = 0;
        boolean achou = false;
        while ((!achou) && (i < this.proxima)) {
            if (num.equals(this.exercicios[i].getClass())) {
                achou = true;
            } else {
                i = i + 1;
            }
        }
        Exercicio resultado = null;
        if (i != this.proxima) {
            resultado = this.exercicios[i];
        }
        return resultado;
    }
    public void remover(String num) {
        int i = 0;
        boolean achou = false;
        while ((!achou) && (i < this.proxima)) {
            if (num.equals(this.exercicios[i].getClass())) {
                achou = true;
            } else {
                i = i + 1;
            }
        }
        if (i != this.proxima) {
            this.exercicios[i] = this.exercicios[this.proxima - 1];
            this.exercicios[this.proxima - 1] = null;
            this.proxima = this.proxima - 1;
            System.out.println("Exercicio " + num + " removido com sucesso.");
        } else {
            System.out.println("Exercicio não existe.");
        }
    }

    public Exercicio[] getExercicios() {
        return exercicios;
    }
}
