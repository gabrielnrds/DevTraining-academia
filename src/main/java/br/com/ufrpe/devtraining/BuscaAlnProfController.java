package br.com.ufrpe.devtraining;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

import java.io.IOException;

public class BuscaAlnProfController {

    @FXML
    private Button BtnBuscarAluno;

    @FXML
    private Button BtnBuscarAluno1;

    @FXML
    private Button BtnVoltarLogin;

    @FXML
    void VoltarTelaMenu(ActionEvent event) throws IOException {
        Main.trocarTela(new FXMLLoader(Main.class.getResource("TelaMenuNova.fxml")).load());
    }
    @FXML
    void TelaBuscaAln(ActionEvent event) throws IOException {
        Main.trocarTela(new FXMLLoader(Main.class.getResource("TelaBuscaAln.fxml")).load());
    }
    @FXML
    void TelaBuscaProf(ActionEvent event) throws IOException {
        Main.trocarTela(new FXMLLoader(Main.class.getResource("TelaBuscaProf.fxml")).load());
    }
}