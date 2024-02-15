package br.com.ufrpe.devtraining;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.com.ufrpe.devtraining.dados.RepositorioGeral;
import br.com.ufrpe.devtraining.negocio.entidades.Cliente;
import br.com.ufrpe.devtraining.negocio.entidades.Pessoa;
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

    private static Pessoa clienteLogado;

    @FXML
    void EntrarNaTelaMenu(ActionEvent event) throws IOException {
        String nomeUsuario = Texto1.getText();
        String senhaUsuario = TextoSenha.getText();

        boolean usuarioEncontrado = false;

        //Verificamos se é um aluno ou admin acessando
        if ("admin".equals(nomeUsuario) && "123".equals(senhaUsuario)) {
            Main.trocarTela(new FXMLLoader(Main.class.getResource("TelaMenuNova.fxml")).load());
            usuarioEncontrado = true;
        } else if ("aluno".equals(nomeUsuario) && "123".equals(senhaUsuario)) {
            Main.trocarTela(new FXMLLoader(Main.class.getResource("TelaImprimirFicha.fxml")).load());
            usuarioEncontrado = true;
        }

        if (!usuarioEncontrado) {
            exibirAlertaMensagem("Erro", "Usuário e senha não encontrados!");
        }
    }

    public static void exibirAlertaMensagem(String titulo, String mensagem) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null); //sem cabeçalho adicional
        alerta.setContentText(mensagem);

        alerta.showAndWait();
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        Usuario admin = new Usuario("admin", "123");
        Usuario aluno = new Usuario("aluno", "123");
        Main.repositorioGeral.getUsuarioRepositorio().cadastrar(admin);
        Main.repositorioGeral.getUsuarioRepositorio().cadastrar(aluno);

    }

    public static Pessoa getClienteLogado() {
        return clienteLogado;
    }
}