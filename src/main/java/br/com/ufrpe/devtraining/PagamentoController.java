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
        Main.trocartela(new FXMLLoader(Main.class.getResource("telaMenuPrincipal.fxml")).load());
    }

    @FXML
    void PagamentoConfirmado(ActionEvent event) {
        // Exibir um alerta de pagamento confirmado
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Pagamento Confirmado");
        alert.setHeaderText(null);
        alert.setContentText("O pagamento foi confirmado com sucesso!");
        alert.showAndWait();
    }

    @FXML
    void LiberarCatraca(ActionEvent event) {
        // Exibir um alerta de catraca liberada
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Catraca Liberada");
        alert.setHeaderText(null);
        alert.setContentText("A catraca foi liberada com sucesso!");
        alert.showAndWait();
    }
}