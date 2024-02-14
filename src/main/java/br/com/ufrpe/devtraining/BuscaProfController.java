package br.com.ufrpe.devtraining;

import br.com.ufrpe.devtraining.negocio.entidades.Pessoa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import java.io.IOException;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class BuscaProfController {

    @FXML
    private Button BtnBuscar;

    @FXML
    private Button BtnVoltarLogin;

    @FXML
    private Text TxtBuscar;

    @FXML
    private TextField TxtProcurarProfessor;

    @FXML
    private Label TxtResultado;

    @FXML
    void BuscarProfessor(ActionEvent event) {
        String cpfProfessor = TxtProcurarProfessor.getText();

        // Realiza a busca do professor pelo CPF
        Pessoa professorEncontrado = Main.repositorioGeral.getRepositorioProfessores().buscar(cpfProfessor);

        if (professorEncontrado != null) {
            // Se o professor for encontrado, exibe suas informações no Label TxtResultado
            TxtResultado.setText("Professor encontrado:\n" + professorEncontrado.toString());
        } else {
            // Se o professor não for encontrado, exibe uma mensagem indicando isso
            TxtResultado.setText("Nenhum professor encontrado com o CPF " + cpfProfessor);
        }
    }

    @FXML
    void VoltarTelaBusca(ActionEvent event) throws IOException {
        Main.trocarTela(new FXMLLoader(Main.class.getResource("TelaBuscaAlnProf.fxml")).load());
    }

}
