package br.com.ufrpe.devtraining.negocio.entidades;

import java.util.Objects;
import java.util.Scanner;


public class Professor extends Pessoa {

    private String turno;
    private double salario;

    public Professor(String wendell, String number, String mail, String id, int i, int i1, String manhã, int i2) {

    }

    public Professor(long id, String nome, String telefone, String email, String cpf, String endereco, int idade, String turno, double salario) {
        super(id, nome, telefone, email, cpf, endereco, idade);
        this.turno = turno;
        this.salario = salario;
    }




    public long getIdDoProfessor(){
        return getId();
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

    //Adição do metodo toFormattedString
    public String toFormattedString() {
        return String.format("%d %s %s %s %s %d %d %s %.2f",
                getIdDoProfessor(), getNome(), getTelefone(), getEmail(), getCpf(),
                getIdade(), getIdDoProfessor(), getTurno(), getSalario());
    }


}