package br.com.ufrpe.devtraining;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import br.com.ufrpe.devtraining.negocio.entidades.Usuario;
import br.com.ufrpe.devtraining.negocio.entidades.Cliente;

import java.io.IOException;

public class FichaTreinoController {

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

    public void VoltarTela(ActionEvent event) throws IOException {
        Main.trocarTela(new FXMLLoader(Main.class.getResource("TelaImprimirFicha.fxml")).load());
    }
}