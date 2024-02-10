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

public class MenuController implements Initializable {

    @FXML
    private Button BtnCatraca;
    @FXML
    private Button BtnCatracaTeste;

    @FXML
    private Button BtnSair;

    @FXML
    private Button btn_cadastros;

    @FXML
    private Button btn_config;

    @FXML
    private Button btn_consulta;

    @FXML
    private Button btn_inicio;

    @FXML
    private Button btn_pagamentos;

    @FXML
    private Button btn_relatorios;

    @FXML
    void VoltarTelaLogin(ActionEvent event) throws IOException {
        Main.trocartela(new FXMLLoader(Main.class.getResource("TelaLogin.fxml")).load());
    }

    @FXML
    void IrParaTelaPagamentos(ActionEvent event) throws IOException {
        Main.trocartela(new FXMLLoader(Main.class.getResource("telaPagamentos.fxml")).load());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    void LiberarCatracaMenu(ActionEvent event) {
        // Exibir um alerta de catraca liberada
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Catraca Liberada");
        alert.setHeaderText(null);
        alert.setContentText("A catraca foi liberada com sucesso!");
        alert.showAndWait();
    }
}