package br.com.ufrpe.devtraining;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

public class ImpriFichaController {

    @FXML
    private Text TextoVoltarFicha;

    @FXML
    private TextField TxtProcurarAluno;

    @FXML
    private Button BtnVoltarFicha;

    @FXML
    void VoltarTelaMenu(ActionEvent event) throws IOException {
        Main.trocarTela(new FXMLLoader(Main.class.getResource("TelaMenuNova.fxml")).load());
    }

}

