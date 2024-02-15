package br.com.ufrpe.devtraining.negocio.entidades;

import br.com.ufrpe.devtraining.dados.IDManager;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FichaTreino implements Serializable {
    private static final IDManager idManager = new IDManager();
    private int idTreino;
    private Professor professor;
    private Cliente cliente;
    private LocalDate dataCriacao;
    private Map<String, List<Exercicio>> exerciciosPorTipo;
    private String tipoTreino;

    public FichaTreino(Professor professor, Cliente cliente, String tipoTreino) {
        this.idTreino = proximoId();
        this.professor = professor;
        this.cliente = cliente;
        this.dataCriacao = LocalDate.now();
        this.exerciciosPorTipo = new HashMap<>();
        // Inicializa as listas para os tipos A, B e C
        this.exerciciosPorTipo.put("A", new ArrayList<>());
        this.exerciciosPorTipo.put("B", new ArrayList<>());
        this.exerciciosPorTipo.put("C", new ArrayList<>());
        this.tipoTreino = tipoTreino;
    }

    private static int proximoId() {
        int proximoId = idManager.getLastTreinoID() + 1;
        idManager.setLastTreinoID(proximoId); // Atualiza o IDManager com o próximo ID
        return proximoId;
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

    public Map<String, List<Exercicio>> getExerciciosPorTipo() {
        return exerciciosPorTipo;
    }

    public String getTipoTreino() {
        return tipoTreino;
    }

    public void adicionarExercicio(String tipo, Exercicio exercicio) {
        if (exercicio == null) {
            throw new IllegalArgumentException("O exercício não pode ser nulo.");
        }
        List<Exercicio> listaExercicios = exerciciosPorTipo.get(tipo);
        if (listaExercicios == null) {
            throw new IllegalArgumentException("Tipo de exercício inválido: " + tipo);
        }
        listaExercicios.add(exercicio);
    }

    public void removerExercicio(String tipo, int indice) {
        List<Exercicio> listaExercicios = exerciciosPorTipo.get(tipo);
        if (listaExercicios == null) {
            throw new IllegalArgumentException("Tipo de exercício inválido: " + tipo);
        }
        if (indice < 0 || indice >= listaExercicios.size()) {
            throw new IndexOutOfBoundsException("Índice fora dos limites: " + indice);
        }
        listaExercicios.remove(indice);
    }

    // Outros métodos para alterar, buscar, etc.

    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder();
        resultado.append("----- Ficha de treino -----\n");
        resultado.append("Cliente: ").append(cliente.getNome()).append("\n");
        resultado.append("Professor: ").append(professor.getNome()).append("\n");
        resultado.append("Data de criação: ").append(dataCriacao.toString()).append("\n");
        resultado.append("----------------------------\n");
        resultado.append("Tipo de treino: ").append(tipoTreino).append("\n");
        resultado.append("Total de exercícios: ").append(calcularTotalExercicios()).append("\n");
        resultado.append("Nome:           Séries:  Repetições:\n");
        for (Map.Entry<String, List<Exercicio>> entry : exerciciosPorTipo.entrySet()) {
            String tipo = entry.getKey();
            List<Exercicio> exercicios = entry.getValue();
            for (Exercicio exercicio : exercicios) {
                resultado.append(tipo).append(": ");
                resultado.append(exercicio.getNome()).append(" - ");
                resultado.append(": ").append(exercicio.getSeries()).append(", ");
                resultado.append(": ").append(exercicio.getRepeticoes()).append("\n");
            }
        }
        return resultado.toString();
    }

    private int calcularTotalExercicios() {
        int total = 0;
        for (List<Exercicio> exercicios : exerciciosPorTipo.values()) {
            total += exercicios.size();
        }
        return total;
    }
    public List<Exercicio> getExerciciosTipoA() {
        return exerciciosPorTipo.getOrDefault("A", new ArrayList<>());
    }
    public List<Exercicio> getExerciciosTipoB() {
        return exerciciosPorTipo.getOrDefault("B", new ArrayList<>());
    }
    public List<Exercicio> getExerciciosTipoC() {
        return exerciciosPorTipo.getOrDefault("C", new ArrayList<>());
    }


}
