package br.com.ufrpe.devtraining.negocio.entidades;

public class Exercicio {
    private String nome;
    private int series;
    private int repeticoes;

    public Exercicio(String nome, int series, int repeticoes){
        this.nome = nome;
        this.series = series;
        this.repeticoes = repeticoes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }

    @Override
    public String toString() {
        return "Exercicio{" +
                "nome='" + nome + '\'' +
                ", series=" + series +
                ", repeticoes=" + repeticoes +
                '}';
    }
}