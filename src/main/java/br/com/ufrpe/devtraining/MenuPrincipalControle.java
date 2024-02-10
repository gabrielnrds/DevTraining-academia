package br.com.ufrpe.devtraining;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

import java.io.IOException;

public class MenuPrincipalControle {

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
    private Button btn_sair;

    @FXML
    void VoltarTelaLogin(ActionEvent event) throws IOException {
        Main.trocartela(new FXMLLoader(Main.class.getResource("telaLogin.fxml")).load());
    }
}
