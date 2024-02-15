package br.com.ufrpe.devtraining;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

import java.io.IOException;

public class ExcluirAlnProfController {

    @FXML
    private Button BtnExcluirAluno;
    @FXML
    private Button BtnExcluirFicha;


    @FXML
    private Button BtnExcluirProf;

    @FXML
    private Button BtnVoltarLogin;
    @FXML
    void TelaExcluirProf(ActionEvent event) throws IOException {
        Main.trocarTela(new FXMLLoader(Main.class.getResource("TelaExcluirProf.fxml")).load());
    }

    @FXML
    void TelaExcluirAln(ActionEvent event) throws IOException {
        Main.trocarTela(new FXMLLoader(Main.class.getResource("TelaExcluirAln.fxml")).load());
    }

    @FXML
    void VoltarTelaMenu(ActionEvent event) throws IOException {
        Main.trocarTela(new FXMLLoader(Main.class.getResource("TelaMenuNova.fxml")).load());
    }
    @FXML
    void TelaExcluirFicha(ActionEvent event)throws IOException {
        Main.trocarTela(new FXMLLoader(Main.class.getResource("TelaExcluirTreino.fxml")).load());
    }

}
