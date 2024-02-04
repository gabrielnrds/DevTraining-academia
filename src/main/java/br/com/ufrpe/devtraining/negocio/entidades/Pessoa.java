package br.com.ufrpe.devtraining.negocio.entidades;

import java.io.Serializable;
import java.util.Objects;

public abstract class  Pessoa implements Serializable {
    private long id;
    private String nome;
    private String telefone;
    private String email;
    private String cpf;
    private String endereco;
    private int idade;

    public Pessoa() {}

    public Pessoa(long id, String nome, String telefone, String email, String cpf, String endereco, int idade) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
        this.endereco = endereco;
        this.idade = idade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Pessoa [id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", cpf=" + cpf
                + ", endereco=" + endereco + ", idade=" + idade + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf, email, endereco, id, idade, nome, telefone);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pessoa other = (Pessoa) obj;
        return Objects.equals(cpf, other.cpf) && Objects.equals(email, other.email)
                && Objects.equals(endereco, other.endereco) && id == other.id && idade == other.idade
                && Objects.equals(nome, other.nome) && Objects.equals(telefone, other.telefone);
    }
}
