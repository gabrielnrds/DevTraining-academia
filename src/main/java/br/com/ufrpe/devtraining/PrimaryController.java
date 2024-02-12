package br.com.ufrpe.devtraining;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.com.ufrpe.devtraining.dados.RepositorioGeral;
import br.com.ufrpe.devtraining.negocio.entidades.Cliente;
import br.com.ufrpe.devtraining.negocio.entidades.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;


public class PrimaryController implements Initializable {
    @FXML
    private Button BtnLogin;

    @FXML
    private Button BtnRegistro;

    @FXML
    private TextField Texto1;

    @FXML
    private TextField TextoDEVTRAINING;

    @FXML
    private PasswordField TextoSenha;

    @FXML
    private AnchorPane imagemInicio;

    @FXML
    private Text textcpf;

    @FXML
    private Text textsenha;
    private static Cliente clienteLogado;

    @FXML
    void EntrarTelaCadastro(ActionEvent event) throws IOException {
        Main.trocarTela(new FXMLLoader(Main.class.getResource("TelaCadastro.fxml")).load());
    }

    @FXML
    void EntrarNaTelaMenu(ActionEvent event) throws IOException {
        String nomeUsuario = Texto1.getText();
        String senhaUsuario = TextoSenha.getText();

        // Verifica se os campos de texto estão vazios
        if (nomeUsuario.isEmpty() || senhaUsuario.isEmpty()) {
            exibirAlertaMensagem("Erro", "Por favor, preencha todos os campos.");
            return; // Encerra o método, pois os campos estão vazios
        }

        boolean usuarioEncontrado = false;

        // Percorre os usuários no repositório
        for (Usuario usuario : Main.repositorioGeral.getUsuarioRepositorio().getUsuarioRepositorio()) {
            // Verifica se o nome de usuário e senha correspondem a algum usuário
            if (nomeUsuario.equals(usuario.getNomeUsuario()) && senhaUsuario.equals(usuario.getSenha())) {
                System.out.println("Usuário existe");
                clienteLogado = Main.repositorioGeral.getRepositorioClientes().clienteUsuario(usuario);
                if (getClienteLogado() != null) {
                    System.out.println(getClienteLogado().getUsuario().getNomeUsuario());
                }
                usuarioEncontrado = true;
                Main.trocarTela(new FXMLLoader(Main.class.getResource("TelaMenuNova.fxml")).load());
                // Pra trocar pra tela de bigode, tem que trocar o TelaMenuNova por telaMenuPrincipal
                break;
            }
        }

        // Se o usuário não foi encontrado, exibe mensagem de erro
        if (!usuarioEncontrado) {
            exibirAlertaMensagem("Erro", "Usuário não existe!");
            System.out.println("Usuário não existe");
        }
    }




    public static void exibirAlertaMensagem(String titulo, String mensagem) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null); //sem cabeçalho adicional
        alerta.setContentText(mensagem);

        alerta.showAndWait();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Usuario usuario = new Usuario(00,"vini","123");
        Main.repositorioGeral.getUsuarioRepositorio().cadastrar(usuario);

    }

    public static Cliente getClienteLogado() {
        return clienteLogado;
    }
}
