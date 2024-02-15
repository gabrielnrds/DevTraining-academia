package br.com.ufrpe.devtraining.negocio.entidades;

import br.com.ufrpe.devtraining.dados.IDManager;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Cliente extends Pessoa implements Serializable {
    private Usuario usuario;
    private FichaTreino treino;
    private LocalDate dataMatricula;
    private Professor professor;
    private boolean statusMatricula;
    private String id;
    private static final IDManager idManager = new IDManager();

    public Cliente(String nome, String telefone, String email, String cpf, String endereco, String idade, Professor professor, Boolean statusMatricula, Usuario usuario) {
        super(proximoId(), nome, telefone, email, cpf, endereco, idade);
        this.treino = null;
        this.dataMatricula = LocalDate.now();
        this.professor = professor;
        this.statusMatricula = statusMatricula;
        this.usuario = usuario;
        this.id = gerarNovoID();
    }

    private static int proximoId() {
        return idManager.getLastClientID() + 1;
    }

    private String gerarNovoID() {
        int novoID = idManager.getLastClientID() + 1;
        idManager.setLastClientID(novoID);
        idManager.saveLastClientID(); //salvar o novo ID
        return  novoID + "C";
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
    public String toString() {
        return "Cliente [ID=" + id + ", treino=" + treino + ", dataMatricula=" + dataMatricula + ", professor=" + professor
                + ", statusMatricula=" + statusMatricula + ", nome=" + getNome() + ", telefone=" + getTelefone()
                + ", email=" + getEmail() + ", cpf=" + getCpf() + ", endereco=" + getEndereco() + ", idade=" + getIdade()
                + ", usuario=" + (usuario != null ? usuario.getNomeUsuario() : "null") + "]";
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setId(String id) {
        this.id = id;
    }
}
