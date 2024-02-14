package br.com.ufrpe.devtraining;

import br.com.ufrpe.devtraining.negocio.entidades.Cliente;
import br.com.ufrpe.devtraining.negocio.entidades.Pessoa;
import br.com.ufrpe.devtraining.negocio.entidades.Professor;
import br.com.ufrpe.devtraining.negocio.entidades.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
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
    void CadastrarProfessor(ActionEvent event) throws IOException {
        String nome = txtNome.getText();
        String telefone = txtTelefone.getText();
        String email = txtEmail.getText();
        String cpf = txtCpf.getText();
        String endereco = txtEndereco.getText();
        String idade = txtIdade.getText();
        String turno = txtTurno.getText();
        String salarioText = txtSalario.getText();
        String senha = txtSenha.getText();

        // Verifica se algum dos campos está vazio
        if (nome.isEmpty() || telefone.isEmpty() || email.isEmpty() || cpf.isEmpty() ||
                endereco.isEmpty() || idade.isEmpty() || turno.isEmpty() || salarioText.isEmpty() || senha.isEmpty()) {
            exibirAlertaMensagem("Erro de Validação", "Por favor, preencha todos os campos.");
            return;
        }

        // Verifica se o campo de salário não está vazio e se é um número válido
        double salario;
        try {
            salario = Double.parseDouble(salarioText);
        } catch (NumberFormatException e) {
            exibirAlertaMensagem("Erro de Validação", "O salário informado não é um número válido.");
            return;
        }
        // Verifica se o CPF já está cadastrado
        if (Main.repositorioGeral.getRepositorioProfessores().existeProfessorComCpf(cpf)) {
            exibirAlertaMensagem("Erro de Validação", "CPF já cadastrado.");
            return;
        }

        // Agora você pode prosseguir com o cadastro do professor
        Usuario usuario = new Usuario(nome, senha);
        Professor professor = new Professor(nome, telefone, email, cpf, endereco, idade, turno, salario, usuario);

        Main.repositorioGeral.getUsuarioRepositorio().cadastrar(usuario);
        Main.repositorioGeral.getRepositorioProfessores().cadastrar(professor);

        for (Pessoa professores : Main.repositorioGeral.getRepositorioProfessores().getProfessores()) {
            if (professores != null) {
                System.out.println(professor.getUsuario().getNomeUsuario());
                System.out.println(professor);
                System.out.println(usuario);
            }
        }

        Main.trocarTela(new FXMLLoader(Main.class.getResource("TelaMenuNova.fxml")).load());
        exibirAlertaMensagem("Cadastro de professor", "Professor cadastrado com sucesso!.");
    }

    public static void exibirAlertaMensagem(String titulo, String mensagem) {
        System.out.println("Exibindo alerta: " + mensagem); // Adicionando instrução de debug
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null); //sem cabeçalho adicional
        alerta.setContentText(mensagem);

        alerta.showAndWait();
    }



    @FXML
    void VoltarTelaMenu(ActionEvent event) throws IOException {
        Main.trocarTela(new FXMLLoader(Main.class.getResource("TelaCadastroMenu.fxml")).load());
    }

}
