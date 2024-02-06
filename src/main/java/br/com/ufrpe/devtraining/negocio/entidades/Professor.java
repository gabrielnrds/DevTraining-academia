package br.com.ufrpe.devtraining.negocio.entidades;

import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;


public class Professor extends Pessoa
        implements Serializable{

    private String turno;
    private double salario;


    public Professor(int id, String nome, String telefone, String email, String cpf, String endereco, int idade, String turno, double salario) {
        super(id, nome, telefone, email, cpf, endereco, idade);
        this.turno = turno;
        this.salario = salario;
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
        return "Professor [turno=" + turno + ", salario=" + salario + "]";
    }

    public void criarTreino(String treino) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o treino: ");
        String treino1 = scanner.nextLine();
        System.out.println("Treino criado: " + treino1);
        scanner.close();
    }




}