package br.com.ufrpe.devtraining;

import br.com.ufrpe.devtraining.negocio.entidades.Cliente;
import br.com.ufrpe.devtraining.negocio.entidades.Pessoa;
import br.com.ufrpe.devtraining.negocio.entidades.Professor;
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
    private Button BtnVoltarCadastro;
    @FXML
    private TextField txtCpf;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtIdade;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtNomeProfessor;

    @FXML
    private PasswordField txtSenha;

    @FXML
    void CadastrarUsu(ActionEvent event) throws IOException {
        // Obtenha o nome do professor digitado pelo usuário
        String nomeProfessor = txtNomeProfessor.getText();

        // Verifique se o professor existe no repositório de professores
        Professor professor = Main.repositorioGeral.getRepositorioProfessores().buscarPeloNome(nomeProfessor);

        if (professor != null) {
            // O professor foi encontrado, então crie o cliente vinculado a ele
            Usuario usuario = new Usuario(txtNome.getText(), txtSenha.getText());
            Cliente cliente = new Cliente(txtNome.getText(), "4", txtEmail.getText(), txtCpf.getText(), "rua", txtIdade.getText(), professor, true, usuario);

            // Cadastre o cliente e o usuário nos repositórios
            Main.repositorioGeral.getRepositorioClientes().cadastrar(cliente);
            Main.repositorioGeral.getUsuarioRepositorio().cadastrar(usuario);

            // Troque para a tela do menu
            Main.trocarTela(new FXMLLoader(Main.class.getResource("telaMenuNova.fxml")).load());
        } else {
            // Se o professor não foi encontrado, exiba uma mensagem de erro
            System.out.println("Professor não encontrado.");
        }
    }

    @FXML
    void VoltarTelaMenu(ActionEvent event) throws IOException {
        Main.trocarTela(new FXMLLoader(Main.class.getResource("telaMenuNova.fxml")).load());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}