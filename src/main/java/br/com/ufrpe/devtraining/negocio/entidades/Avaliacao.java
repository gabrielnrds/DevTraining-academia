package br.com.ufrpe.devtraining.negocio.entidades;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Avaliacao {
    public static ArrayList<Integer> id_avaliacaoIds = new ArrayList<Integer>();
    private int id_avaliacao;
    private Professor professor;
    private Cliente cliente;
    private LocalDateTime dataHora;
    private String objetivo;
    private Medidas medidas;
    private double imc;

    public Avaliacao(Professor professor, Cliente cliente, String objetivo, Medidas medidas) {
        setId_avaliacao(gerarNumId());
        setProfessor(professor);
        setCliente(cliente);
        setDataHora(LocalDateTime.now());
        setObjetivo(objetivo);
        setMedidas(medidas);
        setImc(calcularImc());
    }

    //gerar id
    public int gerarNumId() {
        Integer id;
        do {
            id = ThreadLocalRandom.current().nextInt(0,999);
        } while(id_avaliacaoIds.contains(id));

        id_avaliacaoIds.add(id);
        return id;
    }

    //calcularIMC
    public double calcularImc() {
        double altura, peso, imc;
        altura = medidas.getAltura();
        peso = medidas.getPeso();
        imc = (peso / (altura * altura));
        return imc;
    }

    //imprimir avaliação
    public String toString() {
        String resultado = "";
        resultado += "Professor: " + professor.getNome() + " | Cliente: " + cliente.getNome() + "\n";
        resultado += "Data/horario:	" + dataHora + "\n";
        resultado += "----------------------------------------------\n";
        resultado += "Objetivo:\n        " + objetivo + "\n";
        resultado += "Medidas:" + medidas.toString() + "\n";
        resultado += "----------------------------------------------\n";
        resultado += "IMC: " + imc;

        return resultado;
    }

    //getters
    public void setId_avaliacao(int id_avaliacao) {
        this.id_avaliacao = id_avaliacao;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public void setMedidas(Medidas medidas) {
        this.medidas = medidas;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    //Getters
    public int getId_avaliacao() {
        return this.id_avaliacao;
    }

    public Professor getProfessor() {
        return this.professor;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public LocalDateTime getDataHorario() {
        return this.dataHora;
    }

    public String getObjetivo() {
        return this.objetivo;
    }

    public Medidas getMedidas() {
        return this.medidas;
    }

    public double getImc() {
        return this.imc;
    }

    public String toFormattedString() {
        StringBuilder formattedString = new StringBuilder();

        formattedString.append(id_avaliacao).append(";")
                .append(professor.getIdDoProfessor()).append(";")
                .append(cliente.getId()).append(";")
                .append(dataHora).append(";")
                .append(objetivo).append(";")
                .append(medidas.toFormattedString()).append(";")
                .append(imc);

        return formattedString.toString();
    }
}