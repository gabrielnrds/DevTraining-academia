package br.com.ufrpe.devtraining;

import br.com.ufrpe.devtraining.negocio.entidades.Professor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.IOException;
import javafx.scene.control.Alert;

public class BuscaProfController {

    @FXML
    private Button BtnBuscar;

    @FXML
    private Button BtnVoltarLogin;

    @FXML
    private TextField TxtProcurarProfessor;

    @FXML
    private Label LblTurno;

    @FXML
    private Label LblSalario;

    @FXML
    private Label LblId;

    @FXML
    private Label LblEndereco;

    @FXML
    private Label LblEmail;

    @FXML
    private Label LblIdade;

    @FXML
    private Label TxtResultado;

    @FXML
    void BuscarProfessor(ActionEvent event) {
        String nomeProfessor = TxtProcurarProfessor.getText();

        // Realiza a busca do professor pelo nome
        Professor professorEncontrado = Main.repositorioGeral.getRepositorioProfessores().buscar(nomeProfessor);

        if (professorEncontrado != null) {
            // Se o professor for encontrado, exibe suas informações nos Labels correspondentes
            LblTurno.setText("" + professorEncontrado.getTurno());
            LblSalario.setText("" + professorEncontrado.getSalario());
            LblId.setText("" + professorEncontrado.getId());
            LblEndereco.setText(professorEncontrado.getEndereco());
            LblEmail.setText(professorEncontrado.getEmail());
            LblIdade.setText(professorEncontrado.getIdade());
        } else {
            mostrarAlertaNenhumProfessorEncontrado();
        }
    }

    private void mostrarAlertaNenhumProfessorEncontrado() {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle("Nenhum professor encontrado");
        alerta.setHeaderText(null);
        alerta.setContentText("Nenhum professor encontrado com o CPF fornecido.");
        alerta.showAndWait();
    }

    @FXML
    void VoltarTelaBusca(ActionEvent event) throws IOException {
        Main.trocarTela(new FXMLLoader(Main.class.getResource("TelaBuscaAlnProf.fxml")).load());
    }
}