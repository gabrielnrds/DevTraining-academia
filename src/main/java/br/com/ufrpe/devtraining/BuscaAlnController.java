package br.com.ufrpe.devtraining;

import br.com.ufrpe.devtraining.negocio.entidades.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.IOException;

public class BuscaAlnController {

    @FXML
    private Button BtnBuscar;

    @FXML
    private Button BtnVoltarLogin;

    @FXML
    TextField TxtProcurarAluno;

    @FXML
    private Label LblNomeAluno;

    @FXML
    private Label LblIdadeAluno;

    @FXML
    private Label LblEmailAluno;

    @FXML
    private Label TxtResultado;

    @FXML
    void BuscarAluno(ActionEvent event) {
        String nomeAluno = TxtProcurarAluno.getText();

        // Realiza a busca do aluno pelo nome
        Cliente alunoEncontrado = Main.repositorioGeral.getRepositorioClientes().buscar(nomeAluno);

        if (alunoEncontrado != null) {
            // Se o aluno for encontrado, exibe suas informações nos Labels correspondentes
            LblNomeAluno.setText("Nome: " + alunoEncontrado.getNome());
            LblIdadeAluno.setText("Idade: " + alunoEncontrado.getIdade());
            LblEmailAluno.setText("E-mail: " + alunoEncontrado.getEmail());
            // Limpa a mensagem de resultado anterior
            TxtResultado.setText("");
        } else {
            // Se o aluno não for encontrado, exibe uma mensagem de alerta
            mostrarAlertaNenhumAlunoEncontrado();
        }
    }

    @FXML
    void VoltarTelaBusca(ActionEvent event) throws IOException {
        Main.trocarTela(new FXMLLoader(Main.class.getResource("TelaBuscaAlnProf.fxml")).load());
    }

    private void mostrarAlertaNenhumAlunoEncontrado() {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle("Nenhum aluno encontrado");
        alerta.setHeaderText(null);
        alerta.setContentText("Nenhum aluno encontrado com o CPF fornecido.");
        alerta.showAndWait();
    }
}