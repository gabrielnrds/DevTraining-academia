package br.com.ufrpe.devtraining;

import br.com.ufrpe.devtraining.negocio.entidades.Cliente;
import br.com.ufrpe.devtraining.negocio.entidades.Pessoa;
import br.com.ufrpe.devtraining.negocio.entidades.Professor;
import br.com.ufrpe.devtraining.negocio.entidades.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CadastroControleProfessor {

    @FXML
    private Button BTNCasdastrar;

    @FXML
    private Button BtnVoltarCadastro;

    @FXML
    private TextField txtCpf;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtEndereco;

    @FXML
    private TextField txtIdade;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtSalario;

    @FXML
    private PasswordField txtSenha;

    @FXML
    private TextField txtTelefone;

    @FXML
    private TextField txtTurno;

    @FXML
    void CadastrarProfessor(ActionEvent event)throws IOException {
        double salario = Double.parseDouble(txtSalario.getText());
        Usuario usuario = new Usuario(txtNome.getText(),txtSenha.getText());
        Professor professor = new Professor(txtNome.getText(),txtTelefone.getText(),txtEmail.getText(),txtCpf.getText(),txtEndereco.getText(),txtIdade.getText(),txtTurno.getText(),salario,usuario);

        Main.repositorioGeral.getUsuarioRepositorio().cadastrar(usuario);
        Main.repositorioGeral.getRepositorioProfessores().cadastrar(professor);
        for (Pessoa professores:Main.repositorioGeral.getRepositorioProfessores().getProfessores()) {
            if (professores != null) {
                System.out.println(professor.getUsuario().getNomeUsuario());
                System.out.println(professor);
                System.out.println(usuario);
            }
        }
        Main.trocarTela(new FXMLLoader(Main.class.getResource("telaMenuNova.fxml")).load());

    }

    @FXML
    void VoltarTelaMenu(ActionEvent event) throws IOException {
        Main.trocarTela(new FXMLLoader(Main.class.getResource("telaMenuNova.fxml")).load());
    }

}
