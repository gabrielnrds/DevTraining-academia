package br.com.ufrpe.devtraining;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.com.ufrpe.devtraining.dados.RepositorioGeral;
import br.com.ufrpe.devtraining.negocio.entidades.Cliente;
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
    private static Cliente clienteLogado;

    @FXML
    void EntrarTelaCadastro(ActionEvent event) throws IOException {
        Main.trocarTela(new FXMLLoader(Main.class.getResource("TelaCadastroProfessor.fxml")).load());
    }

    @FXML
    void EntrarNaTelaMenu(ActionEvent event) throws IOException {
        String nomeUsuario = Texto1.getText();
        String senhaUsuario = TextoSenha.getText();

        boolean usuarioEncontrado = false;

        // Percorre os usuários no repositório
        for (Usuario usuario : Main.repositorioGeral.getUsuarioRepositorio().getUsuarioRepositorio()) {
            // Verifica se o usuário atual não é nulo antes de acessar seus atributos
            if (usuario != null) {
                if (nomeUsuario.equals(usuario.getNomeUsuario()) && senhaUsuario.equals(usuario.getSenha())) {
                    // Define o cliente logado
                    clienteLogado = Main.repositorioGeral.getRepositorioClientes().clienteUsuario(usuario);
                    if (getClienteLogado() != null) {
                        System.out.println(getClienteLogado().getUsuario().getNomeUsuario());
                    }

                    usuarioEncontrado = true;
                    Main.trocarTela(new FXMLLoader(Main.class.getResource("TelaMenuNova.fxml")).load());
                    break;
                }
            }
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Usuario usuario = new Usuario("vini","123");
        Professor professor= new Professor("vini","81","email@","705","rua","20","tarde",1000,usuario);
        Cliente cliente = new Cliente("Paulo","81","email@","7","rua","34",professor,true,usuario);
        Main.repositorioGeral.getRepositorioProfessores().cadastrar(professor);
        Main.repositorioGeral.getUsuarioRepositorio().cadastrar(usuario);
        Main.repositorioGeral.getRepositorioClientes().cadastrar(cliente);

    }

    public static Cliente getClienteLogado() {
        return clienteLogado;
    }
}
