package br.com.ufrpe.devtraining;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

import java.io.IOException;

public class BuscaProfController {

    @FXML
    private Button BtnVoltarLogin;

    @FXML
    void VoltarTelaBusca(ActionEvent event) throws IOException {
        Main.trocarTela(new FXMLLoader(Main.class.getResource("TelaBuscaAlnProf.fxml")).load());
    }

}
