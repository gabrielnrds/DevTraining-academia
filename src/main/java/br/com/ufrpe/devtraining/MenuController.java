package br.com.ufrpe.devtraining;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.com.ufrpe.devtraining.negocio.entidades.Cliente;
import br.com.ufrpe.devtraining.negocio.entidades.Pessoa;
import br.com.ufrpe.devtraining.negocio.entidades.Professor;
import br.com.ufrpe.devtraining.negocio.entidades.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
public class MenuController implements Initializable {

    @FXML
    private Button BtnCatraca;

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
    void EntrarTelaCadastro(ActionEvent event) {

    }

    @FXML
    void VoltarTelaLogin(ActionEvent event) throws IOException {
        Main.trocartela(new FXMLLoader(Main.class.getResource("TelaLogin.fxml")).load());
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
