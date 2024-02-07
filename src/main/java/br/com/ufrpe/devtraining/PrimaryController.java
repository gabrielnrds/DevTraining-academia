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
    void EntrarSegundaTela(ActionEvent event) throws IOException {
        Main.trocartela(new FXMLLoader(Main.class.getResource("TelaCadastro.fxml")).load());
    }

    @FXML
    void EntrarNaTelaMenu(ActionEvent event) {
        for (Usuario usuario : Main.repositorioGeral.getRepositorioUsuarios()) {
            if (Texto1.getText().equals(usuario.getNomeUsuario()) && TextoSenha.getText().equals(usuario.getSenha())) {
                System.out.println("Usuário existe");
                clienteLogado = Main.repositorioGeral.getRepositorioClientes().clienteUsuario(usuario);
                System.out.println(getClienteLogado().getUsuario().getNomeUsuario());
            } else {
                exibirAlertaMensagem("Erro","Usuário não existe");
                System.out.println("Usuário não existe");
            }
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
        Main.repositorioGeral.getRepositorioUsuarios().add(usuario);


    }

    public static Cliente getClienteLogado() {
        return clienteLogado;
    }
}
