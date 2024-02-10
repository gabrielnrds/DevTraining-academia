package br.com.ufrpe.devtraining;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.com.ufrpe.devtraining.negocio.entidades.Cliente;
import br.com.ufrpe.devtraining.negocio.entidades.Pessoa;
import br.com.ufrpe.devtraining.negocio.entidades.Professor;
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
    private static Pessoa pessoa;

    @FXML
    void EntrarTelaCadastro(ActionEvent event) throws IOException {
        Main.trocartela(new FXMLLoader(Main.class.getResource("TelaCadastro.fxml")).load());
    }
    @FXML
    void EntrarNaTelaMenu(ActionEvent event) throws IOException {
        boolean usuarioEncontrado = false; // Variável booleana para detectar se encontrou
        for (Usuario usuario : Main.repositorioGeral.getRepositorioUsuarios()) {
            if (Texto1.getText().equals(usuario.getNomeUsuario()) && TextoSenha.getText().equals(usuario.getSenha())) {
                Cliente cliente = Main.repositorioGeral.getRepositorioClientes().clienteUsuario(usuario);
                if (cliente != null) { // Se o cliente for encontrado, é um aluno
                    pessoa = cliente;
                } else { // Se não for encontrado no repositório de clientes, verifica se é professor
                    Professor professor = Main.repositorioGeral.getRepositorioProfessores().professor(usuario);
                    if (professor != null) {
                        pessoa = professor;
                    }
                }
                usuarioEncontrado = true;
                Main.trocartela(new FXMLLoader(Main.class.getResource("telaMenuPrincipal.fxml")).load());
                break;
            }
        }

        if (!usuarioEncontrado) {
            exibirAlertaMensagem("Erro", "Usuário não existe");
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
        Usuario usuarioProf = new Usuario(01, "Girafales", "123");
        Main.repositorioGeral.getRepositorioUsuarios().add(usuarioProf);
        Professor professor = new Professor(01, "Girafales", "81", null, null, null, null, null, 1.1, usuarioProf);
        Main.repositorioGeral.getRepositorioProfessores().cadastrar(professor);

    }

    public static Pessoa getPessoa() {
        return pessoa;
    }
}
