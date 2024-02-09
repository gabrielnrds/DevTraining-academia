package br.com.ufrpe.devtraining.negocio.entidades;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Cliente extends Pessoa
        implements Serializable {

    private  Usuario usuario;

    private FichaTreino treino;
    private LocalDate dataMatricula;
    private Professor professor;
    private boolean statusMatricula;

    public Cliente(String clienteTeste, String number, String mail, String s, int i, String ruaRobertinho, String treino, Object o, Professor professor1, boolean b) {

    }

    public Cliente(int id, String nome, String telefone, String email, String cpf, String endereco, String idade
                   , Professor professor, Boolean statusMatricula, Usuario usuario) {
        super(id, nome, telefone, email, cpf, endereco, idade);
        this.treino = null;
        this.dataMatricula = LocalDate.now();
        this.professor = professor;
        this.statusMatricula = statusMatricula;
        this.usuario = usuario;
    }


    public FichaTreino getTreino() {
        return treino;
    }

    public void setTreino(FichaTreino treino) {
        this.treino = treino;
    }

    public String getDataMatricula() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dataMatricula.format(formatter);
    }

    public void setDataMatricula(LocalDate dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public String getProfessor() {
        return professor.getNome();
    }
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Boolean getStatusMatricula() {
        return statusMatricula;
    }
    public void setStatusMatricula(Boolean statusMatricula) {
        this.statusMatricula = statusMatricula;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(dataMatricula, professor, statusMatricula, treino);
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
        Cliente other = (Cliente) obj;
        return Objects.equals(dataMatricula, other.dataMatricula) && Objects.equals(professor, other.professor)
                && statusMatricula == other.statusMatricula && Objects.equals(treino, other.treino);
    }

    @Override
    public String toString() {
        return "Cliente [treino=" + treino + ", dataMatricula=" + dataMatricula + ", professor=" + professor
                + ", statusMatricula=" + statusMatricula + "]";
    }

    public String toFormattedString() {
        // Formate os atributos do cliente como desejar
        return String.format("Nome: %s, CPF: %s, Treino: %s, Data de Matrícula: %s, Professor: %s, Status Matrícula: %s",
                this.getNome(), this.getCpf(), this.getTreino(), this.getDataMatricula(), this.getProfessor(), this.getStatusMatricula());
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
