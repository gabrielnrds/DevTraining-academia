package br.com.ufrpe.devtraining.dados;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import br.com.ufrpe.devtraining.negocio.entidades.Cliente;
import br.com.ufrpe.devtraining.negocio.entidades.Professor;

public class RepositorioClientes {
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

        if (this.proxima == this.clientes.length) {
            this.duplicaArrayClientes();
            salvarDados();
        }
    }

    private boolean existeClienteComCPF(String cpf) {
        return buscar(cpf) != null;
    }

    private void duplicaArrayClientes() {
        if (this.clientes != null && this.clientes.length > 0) {
            Cliente[] arrayDuplicado = new Cliente[this.clientes.length * 2];
            System.arraycopy(this.clientes, 0, arrayDuplicado, 0, this.clientes.length);
            this.clientes = arrayDuplicado;
        }
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

            salvarDados();
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

        salvarDados();
    }

    void salvarDados() {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(arquivo), StandardCharsets.UTF_8))) {
            for (int i = 0; i < proxima; i++) {
                writer.write(clientes[i].toFormattedString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void carregarDados() {
        File file = new File(arquivo);

        if (!file.exists()) {
            System.out.println("Arquivo não encontrado. Criando um novo arquivo.");
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }







}