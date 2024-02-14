package br.com.ufrpe.devtraining;

import br.com.ufrpe.devtraining.negocio.entidades.Usuario;
import br.com.ufrpe.devtraining.dados.RepositorioGeral;
import br.com.ufrpe.devtraining.negocio.entidades.Cliente;
import br.com.ufrpe.devtraining.negocio.entidades.Professor;
import javafx.scene.Parent;
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

        for (Usuario usuario : Main.repositorioGeral.getUsuarioRepositorio().getUsuarioRepositorio()) {
            if (usuario != null) {
                if (nomeCliente.equals(usuario.getNomeUsuario())) {
                    clienteLogado = Main.repositorioGeral.getRepositorioClientes().clienteUsuario(usuario);
                    if (getClienteLogado() != null) {
                        System.out.println(getClienteLogado().getUsuario().getNomeUsuario());
                    }

                    usuarioEncontrado = true;
                    FXMLLoader loader = new FXMLLoader(Main.class.getResource("fichaTreinoImpressao.fxml"));
                    Parent root = loader.load();

                    // Obtém o controlador da tela de impressão
                    FichaTreinoController controller = loader.getController();

                    // Define o nome do cliente no controlador da tela de impressão
                    controller.setNomeCliente(nomeCliente);

                    // Verifica se o clienteLogado não é null antes de definir a idade
                    if (clienteLogado != null) {
                        controller.setIdadeCliente(clienteLogado.getIdade());
                    }

                    Main.trocarTela(root);
                    break;
                }
            }
        }

        System.out.println("Usuário encontrado? " + usuarioEncontrado);

        if (!usuarioEncontrado) {
            exibirAlertaMensagem("Erro", "Usuário não encontrado!");
        }


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