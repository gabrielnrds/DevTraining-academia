package br.com.ufrpe.devtraining.negocio.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class FichaTreino implements Serializable {

    private int idTreino;
    private Professor professor;
    private Cliente cliente;
    private Date dataCriacao;
    private List<String> exercicios;
    private String tipoTreino;

    public FichaTreino(int idTreino, Professor professor, Cliente cliente, Date dataCriacao, String tipoTreino) {
        this.idTreino = idTreino;
        this.professor = professor;
        this.cliente = cliente;
        this.dataCriacao = dataCriacao;
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
    public Date getDataCriacao() {
        return dataCriacao;
    }
    public List<String> getExercicios() {
        return exercicios;
    }
    public String getTipoTreino() {
        return tipoTreino;
    }
    public void adicionaExercicio(String exercicio) {
        this.exercicios.add(exercicio);
        //método pra adicionar um exercício na lista de exercícios
    }
    public void alteraExercicio(int indice, String novoExercicio) {
        if (indice >= 0 && indice < exercicios.size()) {
            this.exercicios.set(indice, novoExercicio);
        } else {
            System.out.println("ERRO");
        }
    }
    public void removeExercicio(int indice) {
        if (indice >= 0 && indice < exercicios.size()) {
            this.exercicios.remove(indice);
        } else {
            System.out.println("ERRO");//dar ideias pra oq colocar aqui
        }
    }



    }
