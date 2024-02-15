package br.com.ufrpe.devtraining;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import br.com.ufrpe.devtraining.negocio.entidades.Cliente;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FichaTreinoController implements Initializable {

    @FXML
    private Label lbl_id_cliente;

    @FXML
    private Label lbl_idade_cliente;

    @FXML
    private Label lbl_nome_cliente;

    @FXML
    private Label lbl_nome_professor;

    @FXML
    private Label lbl_tipo_treino;

    @FXML
    private ListView<?> list_exercicios;

    private static Cliente clienteLogado;

    @FXML
    private Label lbl_nome_cliente_impressao;

    public void setNomeCliente(String nomeCliente) {
        lbl_nome_cliente.setText("Nome: " + nomeCliente);
    }

    public void setIdadeCliente(String idadeCliente) {
        lbl_idade_cliente.setText("Idade: " + idadeCliente);
    }


    public void VoltarTela(ActionEvent event) throws IOException {
        Main.trocarTela(new FXMLLoader(Main.class.getResource("TelaImprimirFicha.fxml")).load());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Verifique se há um cliente logado
        if (clienteLogado != null) {
            // Defina o nome do cliente
            lbl_nome_cliente.setText("Nome: " + clienteLogado.getNome());

            // Defina a idade do cliente
            lbl_idade_cliente.setText("Idade: " + clienteLogado.getIdade());

            // Verifique se o cliente tem um professor associado
            if (clienteLogado.getProfessor() != null) {
                // Defina o nome do professor
                lbl_nome_professor.setText("Professor: " + clienteLogado.getProfessor());
            } else {
                // Se o cliente não tiver um professor associado, exiba uma mensagem indicando isso
                lbl_nome_professor.setText("Professor não vinculado");
            }
        }
    }

    public static void setClienteLogado(Cliente cliente) {
        clienteLogado = cliente;
    }
}