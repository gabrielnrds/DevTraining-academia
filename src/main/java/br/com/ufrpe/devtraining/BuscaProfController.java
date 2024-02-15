package br.com.ufrpe.devtraining;

import br.com.ufrpe.devtraining.negocio.entidades.Professor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class BuscaProfController {

    @FXML
    private Button BtnBuscar;

    @FXML
    private Button BtnVoltarLogin;

    @FXML
    private Label LblCPF;

    @FXML
    private Label LblEmail;

    @FXML
    private Label LblEndereco;

    @FXML
    private Label LblId;

    @FXML
    private Label LblIdade;

    @FXML
    private Label LblNome;

    @FXML
    private Label LblSalario;

    @FXML
    private Label LblTelefone;

    @FXML
    private Label LblTurno;

    @FXML
    private TextField TxtProcurarProfessor;

    @FXML
    void BuscarProfessor(ActionEvent event) {
        String cpfProfessor = TxtProcurarProfessor.getText();

        // Realiza a busca do professor pelo CPF
        Professor professorEncontrado = Main.repositorioGeral.getRepositorioProfessores().buscar(cpfProfessor);

        if (professorEncontrado != null) {
            LblNome.setText(professorEncontrado.getNome());
            LblCPF.setText(professorEncontrado.getCpf());
            LblTelefone.setText(professorEncontrado.getTelefone());
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