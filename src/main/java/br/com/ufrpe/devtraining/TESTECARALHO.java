package br.com.ufrpe.devtraining;

import br.com.ufrpe.devtraining.negocio.entidades.Cliente;
import br.com.ufrpe.devtraining.negocio.entidades.Professor;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

import static br.com.ufrpe.devtraining.PrimaryController.getPessoa;

public class TESTECARALHO implements Initializable {

    @FXML
    private Text txtAdmin;

    @FXML
    private Text txtCliente;

    @FXML
    private Text txtProf;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (getPessoa() != null){
            if (getPessoa() instanceof Cliente){
                txtCliente.setText("EU SOU UM CLIENTE");
            } else if (getPessoa() instanceof Professor) {
                txtProf.setText("EU SOU UM PROFESSOR");
            }
        }
    }
}
