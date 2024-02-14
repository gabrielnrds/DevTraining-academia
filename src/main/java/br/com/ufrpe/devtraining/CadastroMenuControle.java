package br.com.ufrpe.devtraining;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

import java.io.IOException;

public class CadastroMenuControle {

    @FXML
    private Button BtnCadProfessor;

    @FXML
    private Button BtnCadastroAluno;

    @FXML
    private Button BtnDinheiro1;

    @FXML
    private Button BtnDinheiro3;

    @FXML
    private Button BtnVoltarCatraca;

    @FXML
    void PagamentoConfirmado(ActionEvent event) {

    }

    @FXML
    void TelaCadastro(ActionEvent event) throws IOException {
        Main.trocarTela(new FXMLLoader(Main.class.getResource("TelaCadastro.fxml")).load());
    }

    @FXML
    void VoltarTelaMenu(ActionEvent event) throws IOException {
        Main.trocarTela(new FXMLLoader(Main.class.getResource("TelaMenuNova.fxml")).load());
    }
    @FXML
    void TelaCadastroProf(ActionEvent event) throws IOException {
        Main.trocarTela(new FXMLLoader(Main.class.getResource("TelaCadastroProfessor.fxml")).load());

    }
}
