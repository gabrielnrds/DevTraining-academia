package br.com.ufrpe.devtraining;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import java.io.IOException;

public class PagamentoController {

    @FXML
    private Button BtnCartao;

    @FXML
    private Button BtnCatracaPagamento;

    @FXML
    private Button BtnDinheiro;

    @FXML
    private Button BtnVoltarCatraca;

    @FXML
    void VoltarTelaMenu(ActionEvent event) throws IOException {
        Main.trocarTela(new FXMLLoader(Main.class.getResource("TelaMenuNova.fxml")).load());
    }

    @FXML
    void PagamentoConfirmado(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Pagamento Confirmado");
        alert.setHeaderText(null);
        alert.setContentText("O pagamento foi confirmado com sucesso!");
        alert.showAndWait();
    }

    @FXML
    void LiberarCatraca(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Catraca Liberada");
        alert.setHeaderText(null);
        alert.setContentText("A catraca foi liberada com sucesso!");
        alert.showAndWait();
    }
}