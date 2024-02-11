package br.com.ufrpe.devtraining;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

import java.io.IOException;

public class CadastroMenuControle {

    @FXML
    private Button BtnDinheiro;

    @FXML
    private Button BtnDinheiro1;

    @FXML
    private Button BtnDinheiro2;

    @FXML
    private Button BtnDinheiro3;

    @FXML
    private Button BtnVoltarCatraca;

    @FXML
    void PagamentoConfirmado(ActionEvent event) {

    }

    @FXML
    void VoltarTelaMenu(ActionEvent event) throws IOException {
        Main.trocarTela(new FXMLLoader(Main.class.getResource("TelaMenuNova.fxml")).load());
    }

}
