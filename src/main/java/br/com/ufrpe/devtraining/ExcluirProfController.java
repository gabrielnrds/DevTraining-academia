package br.com.ufrpe.devtraining;

import br.com.ufrpe.devtraining.negocio.entidades.Professor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.io.IOException;

public class ExcluirProfController {

    @FXML
    private Button BtnBuscar;

    @FXML
    private Button BtnVoltarLogin;

    @FXML
    private TextField TxtProcurarProfessor;

    @FXML
    void BuscarProfessor(ActionEvent event) {
        String cpfProfessor = TxtProcurarProfessor.getText();

        Professor professorEncontrado = Main.repositorioGeral.getRepositorioProfessores().buscar(cpfProfessor);

        if (professorEncontrado != null) {
            Main.repositorioGeral.getRepositorioProfessores().remover(cpfProfessor);

            TxtProcurarProfessor.setText("");
            mostrarAlerta("Professor excluído com sucesso.");
        } else {
            mostrarAlerta("Nenhum professor encontrado com o CPF fornecido.");
        }
    }

    @FXML
    void VoltarTelaMenu(ActionEvent event) throws IOException {
        Main.trocarTela(new FXMLLoader(Main.class.getResource("TelaMenuNova.fxml")).load());
    }

    private void mostrarAlerta(String mensagem) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Informação");
        alerta.setHeaderText(null);
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }
}