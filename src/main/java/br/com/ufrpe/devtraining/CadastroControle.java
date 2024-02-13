package br.com.ufrpe.devtraining;

import br.com.ufrpe.devtraining.negocio.entidades.Cliente;
import br.com.ufrpe.devtraining.negocio.entidades.Pessoa;
import br.com.ufrpe.devtraining.negocio.entidades.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CadastroControle implements Initializable {

    @FXML
    private Button BTNCasdastrar;

    @FXML
    private TextField txtCpf;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtIdade;

    @FXML
    private TextField txtNome;

    @FXML
    private PasswordField txtSenha;

    @FXML
    void CadastrarUsu(ActionEvent event) throws IOException {
        Usuario usuario = new Usuario(0,txtNome.getText(),txtSenha.getText());
        Cliente cliente = new Cliente(0,txtNome.getText(),"4",txtEmail.getText(),txtCpf.getText(),"rua",txtIdade.getText(),null,true,usuario);

        Main.repositorioGeral.getRepositorioClientes().cadastrar(cliente);
        Main.repositorioGeral.getUsuarioRepositorio().cadastrar(usuario);
        for (Pessoa clientes:Main.repositorioGeral.getRepositorioClientes().getClientes()) {
            if (clientes != null) {
                System.out.println(cliente.getUsuario().getNomeUsuario());
            }
        }
        Main.trocarTela(new FXMLLoader(Main.class.getResource("telaLogin.fxml")).load());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        }
    }


