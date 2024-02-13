package br.com.ufrpe.devtraining;

import br.com.ufrpe.devtraining.negocio.entidades.Usuario;
import br.com.ufrpe.devtraining.dados.RepositorioGeral;
import br.com.ufrpe.devtraining.negocio.entidades.Cliente;
import br.com.ufrpe.devtraining.negocio.entidades.Professor;
import br.com.ufrpe.devtraining.negocio.entidades.Usuario;

import javafx.scene.control.Alert;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

import static br.com.ufrpe.devtraining.PrimaryController.getClienteLogado;

public class ImpriFichaController {

    @FXML
    private Button BtnImprimirTreino;

    @FXML
    private Button BtnVoltarFicha;

    @FXML
    private Text TextoVoltarFicha;

    @FXML
    private Text TextoVoltarFicha1;

    @FXML
    private TextField TxtProcurarAluno;

    private static Cliente clienteLogado;

    @FXML
    void VoltarTelaMenu(ActionEvent event) throws IOException {
        Main.trocarTela(new FXMLLoader(Main.class.getResource("TelaMenuNova.fxml")).load());
    }

    @FXML
    void ImprimirFichaTreino(ActionEvent event) throws IOException {

        String nomeCliente = TxtProcurarAluno.getText();

        boolean usuarioEncontrado = false;
        // Percorre os usuários no repositório
        for (Usuario usuario : Main.repositorioGeral.getUsuarioRepositorio().getUsuarioRepositorio()) {
            // Verifica se o usuário atual não é nulo antes de acessar seus atributos
            if (usuario != null) {
                if (nomeCliente.equals(usuario.getNomeUsuario())) {
                    // Define o cliente logado
                    clienteLogado = Main.repositorioGeral.getRepositorioClientes().clienteUsuario(usuario);
                    if (getClienteLogado() != null) {
                        System.out.println(getClienteLogado().getUsuario().getNomeUsuario());
                    }

                    usuarioEncontrado = true;
                    Main.trocarTela(new FXMLLoader(Main.class.getResource("TelaMenuNova.fxml")).load());
                    break;
                }}}
        System.out.println("Usuário encontrado? " + usuarioEncontrado);

        if (!usuarioEncontrado) {
            exibirAlertaMensagem("Erro", "Usuário não encontrado!");
        }
    }






    public static void exibirAlertaMensagem(String titulo, String mensagem) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null); //sem cabeçalho adicional
        alerta.setContentText(mensagem);

        alerta.showAndWait();
    }
    }
