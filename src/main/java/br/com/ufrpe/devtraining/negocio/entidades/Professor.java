package br.com.ufrpe.devtraining.negocio.entidades;

import br.com.ufrpe.devtraining.dados.IDManager;

import java.io.Serializable;
import java.util.Objects;

public class Professor extends Pessoa implements Serializable {

    private static int proximoId = 1;

    private String turno;
    private double salario;
    private Usuario usuario;
    private String id;
    private static IDManager idManager = new IDManager();


    public Professor(String nome, String telefone, String email, String cpf, String endereco, String idade, String turno, double salario, Usuario usuario) {
        super(proximoId, nome, telefone, email, cpf, endereco, idade);
        this.turno = turno;
        this.salario = salario;
        this.usuario = usuario;
        this.id = gerarIdProfessor();
        idManager.setLastProfessorID(idManager.getLastProfessorID() + 1);
        proximoId++;
    }


    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(salario, turno);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Professor other = (Professor) obj;
        return Double.doubleToLongBits(salario) == Double.doubleToLongBits(other.salario)
                && Objects.equals(turno, other.turno);
    }

    @Override
    public String toString() {
        return "Professor [id=" + id + ", turno=" + turno + ", salario=" + salario + "]";
    }

    public void criarTreino(String treino) {
        // Implementação do método para criar treino
    }

    public Usuario getUsuario() {
        return usuario;
    }

    private String gerarIdProfessor() {
        return super.getId() + "P"; // Utilizando o ID herdado da classe Pessoa
    }
}
