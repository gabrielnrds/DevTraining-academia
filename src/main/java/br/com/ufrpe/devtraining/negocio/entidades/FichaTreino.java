package br.com.ufrpe.devtraining.negocio.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FichaTreino implements Serializable {

    private int idTreino;
    private Professor professor;
    private Cliente cliente;
    private LocalDate dataCriacao;
    private List<Exercicio> exercicios;
    private String tipoTreino;

    public FichaTreino(int idTreino, Professor professor, Cliente cliente, String tipoTreino) {
        this.idTreino = idTreino;
        this.professor = professor;
        this.cliente = cliente;
        this.dataCriacao = LocalDate.now();
        this.exercicios = new ArrayList<>();
        this.tipoTreino = tipoTreino;
    }
    public int getIdTreino() {
        return idTreino;
    }
    public Professor getProfessor() {
        return professor;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public LocalDate getDataCriacao() {
        return dataCriacao;
    }
    public List<Exercicio> getExercicios() {
        return exercicios;
    }
    public String getTipoTreino() {
        return tipoTreino;
    }

    public void adicionarExercicio(Exercicio exercicio) {
        this.exercicios.add(exercicio);
        //método pra adicionar um exercício na lista de exercícios
    }
    public void alterarExercicio(int indice, Exercicio novoExercicio) {
        if (indice >= 0 && indice < exercicios.size()) {
            this.exercicios.set(indice, novoExercicio);
        } else {
            System.out.println("ERRO");
        }
    }
    public void removerExercicio(int indice) {
        if (indice >= 0 && indice < exercicios.size()) {
            this.exercicios.remove(indice);
        } else {
            System.out.println("ERRO");//dar ideias pra oq colocar aqui
        }
    }

    @Override
    public String toString(){
        String resultado = "";
        resultado += "----- Ficha de treino -----\n";
        resultado += "Cliente: " + cliente.getNome() + "\n";
        resultado += "Professor: " + professor.getNome() + "\n";
        resultado += "Data de criação: " + dataCriacao.toString() + "\n";
        resultado += "----------------------------\n";
        resultado += "Tipo de treino: " + tipoTreino + "\n";
        resultado += "Nome:           Series:  Repetições:\n";
        for(Exercicio exercicio : exercicios){
            resultado += exercicio.getNome() + "         " + exercicio.getSeries() + " x " + exercicio.getRepeticoes() + "\n";
        }
        return resultado;
    }
}