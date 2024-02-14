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

        // Realiza a busca do professor pelo CPF
        Professor professorEncontrado = Main.repositorioGeral.getRepositorioProfessores().buscar(cpfProfessor);

        if (professorEncontrado != null) {
            // Remove o professor encontrado
            Main.repositorioGeral.getRepositorioProfessores().remover(cpfProfessor);

            // Limpa o campo e mostra uma mensagem de sucesso
            TxtProcurarProfessor.setText("");
            mostrarAlerta("Professor excluído com sucesso.");
        } else {
            // Se o professor não for encontrado, exibe uma mensagem de alerta
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