package br.com.ufrpe.devtraining.dados;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;


import br.com.ufrpe.devtraining.negocio.entidades.Cliente;
import br.com.ufrpe.devtraining.negocio.entidades.Professor;
import br.com.ufrpe.devtraining.negocio.entidades.Usuario;

public class RepositorioClientes implements Serializable  {

    private Cliente[] clientes;
    private int proxima;
    private String arquivo = "clientes.txt";

    public RepositorioClientes(int tamanho) {
        this.clientes = new Cliente[tamanho];
        this.proxima = 0;
    }

    public void cadastrar(Cliente cliente) {
        if (existeClienteComCPF(cliente.getCpf())) {
            System.out.println("CPF já existe. Não é possível cadastrar o cliente.");
            return;
        }

        this.clientes[this.proxima] = cliente;
        this.proxima++;

    }

    private boolean existeClienteComCPF(String cpf) {
        return buscar(cpf) != null;
    }

    public Cliente buscar(String cpf) {
        int i = 0;
        boolean achou = false;

        while ((!achou) && (i < this.proxima)) {
            if (cpf.equals(this.clientes[i].getCpf())) {
                achou = true;
            } else {
                i++;
            }
        }

        return achou ? this.clientes[i] : null;
    }

    public void remover(String cpf) {
        int i = 0;
        boolean achou = false;
        while ((!achou) && (i < this.proxima)) {
            if (cpf.equals(this.clientes[i].getCpf())) {
                achou = true;
            } else {
                i++;
            }
        }

        if (achou) {
            this.clientes[i] = this.clientes[this.proxima - 1];
            this.clientes[this.proxima - 1] = null;
            this.proxima--;


            System.out.println("Cliente " + cpf + " removido com sucesso.");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    public void alterar(String cpf, Cliente novoCliente) {
        int i = 0;
        boolean achou = false;

        while ((!achou) && (i < this.proxima)) {
            if (cpf.equals(this.clientes[i].getCpf())) {
                achou = true;
            } else {
                i++;
            }
        }

        if (achou) {
            this.clientes[i] = novoCliente;
            System.out.println("Cliente " + cpf + " alterado com sucesso.");
        } else {
            System.out.println("Cliente não encontrado.");
        }


    }



    public Cliente[] getClientes() {
        return clientes;
    }

    public Cliente clienteUsuario(Usuario usuario){
        for(Cliente cliente : clientes){
            if (cliente != null && cliente.getUsuario() != null && cliente.getUsuario().equals(usuario)) {
                return cliente;
            }
        }
        return null;
    }

}







