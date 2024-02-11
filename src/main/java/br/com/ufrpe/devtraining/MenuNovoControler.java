package br.com.ufrpe.devtraining;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.io.IOException;

public class MenuNovoControler {

    @FXML
    private Text BtnCadastroo;

    @FXML
    private Button BtnLiberarCatraca;

    @FXML
    private Text BtnPagamentoss;

    @FXML
    private Button btn_sair;

    @FXML
    void VoltarTelaLogin(ActionEvent event) throws IOException {
        Main.trocartela(new FXMLLoader(Main.class.getResource("telaLogin.fxml")).load());
    }




}
