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
        List<Exercicio> listaExercicios = exerciciosPorTipo.get(tipo);
        if (listaExercicios != null) {
            listaExercicios.add(exercicio);
        } else {
            System.out.println("Tipo de exercício inválido!");
        }
    }

    public void removerExercicio(String tipo, int indice) {
        List<Exercicio> listaExercicios = exerciciosPorTipo.get(tipo);
        if (listaExercicios != null && indice >= 0 && indice < listaExercicios.size()) {
            listaExercicios.remove(indice);
        } else {
            System.out.println("Tipo de exercício inválido ou índice fora dos limites!");
        }
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
        resultado.append("Nome:           Series:  Repetições:\n");
        for (Map.Entry<String, List<Exercicio>> entry : exerciciosPorTipo.entrySet()) {
            String tipo = entry.getKey();
            List<Exercicio> exercicios = entry.getValue();
            for (Exercicio exercicio : exercicios) {
                resultado.append(tipo).append(": ");
                resultado.append(exercicio.getNome()).append(" - ");
                resultado.append("Series: ").append(exercicio.getSeries()).append(", ");
                resultado.append("Repetições: ").append(exercicio.getRepeticoes()).append("\n");
            }
        }
        return resultado.toString();
    }
}
