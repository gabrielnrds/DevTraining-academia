package br.com.ufrpe.devtraining;

import br.com.ufrpe.devtraining.negocio.entidades.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.io.IOException;

public class ExcluirController {

    @FXML
    private Button BtnBuscar;

    @FXML
    private Button BtnVoltarLogin;

    @FXML
    private TextField TxtProcurarAluno;

    @FXML
    void BuscarAluno(ActionEvent event) {
        String cpfAluno = TxtProcurarAluno.getText();

        // Realiza a busca do cliente pelo CPF
        Cliente clienteEncontrado = Main.repositorioGeral.getRepositorioClientes().buscar(cpfAluno);

        if (clienteEncontrado != null) {
            // Remove o cliente encontrado
            Main.repositorioGeral.getRepositorioClientes().remover(cpfAluno);

            // Limpa o campo e mostra uma mensagem de sucesso
            TxtProcurarAluno.setText("");
            mostrarAlerta("Cliente excluído com sucesso.");
        } else {
            // Se o cliente não for encontrado, exibe uma mensagem de alerta
            mostrarAlerta("Nenhum cliente encontrado com o CPF fornecido.");
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