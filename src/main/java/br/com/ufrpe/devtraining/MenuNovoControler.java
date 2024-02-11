package br.com.ufrpe.devtraining;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuNovoControler implements Initializable {

    @FXML
    private Button BtnCadastro;

    @FXML
    private Button BtnCatraca;

    @FXML
    private Button BtnPagamento;

    @FXML
    private Button BtnVoltarLogin;
    @FXML
    void VoltarTelaMenu(ActionEvent event) throws IOException {
        Main.trocartela(new FXMLLoader(Main.class.getResource("telaLogin.fxml")).load());
    }
    @FXML
    void LiberarCatraca(ActionEvent event) throws IOException {
        // Exibir um alerta de catraca liberada
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Catraca Liberada");
        alert.setHeaderText(null);
        alert.setContentText("A catraca foi liberada com sucesso!");
        alert.showAndWait();
    }

    @FXML
    void TelaCadastro(ActionEvent event) throws IOException {
        Main.trocartela(new FXMLLoader(Main.class.getResource("TelaCadastroMenu.fxml")).load());
    }
    @FXML
    void TelaPagamentos(ActionEvent event) throws IOException {
        Main.trocartela(new FXMLLoader(Main.class.getResource("telaPagamentos.fxml")).load());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}



