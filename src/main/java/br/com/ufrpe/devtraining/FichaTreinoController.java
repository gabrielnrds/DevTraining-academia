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

    public void VoltarTela(ActionEvent event) throws IOException {
        Main.trocarTela(new FXMLLoader(Main.class.getResource("TelaImprimirFicha.fxml")).load());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}