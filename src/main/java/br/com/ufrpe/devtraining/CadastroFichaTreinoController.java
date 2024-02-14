package br.com.ufrpe.devtraining;

import br.com.ufrpe.devtraining.dados.RepositorioTreinos;
import br.com.ufrpe.devtraining.negocio.entidades.Cliente;
import br.com.ufrpe.devtraining.negocio.entidades.Exercicio;
import br.com.ufrpe.devtraining.negocio.entidades.FichaTreino;
import br.com.ufrpe.devtraining.negocio.entidades.Professor;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class CadastroFichaTreinoController {
    @FXML
    private TextField txtNomeExercicio;

    @FXML
    private TextField txtSeries;

    @FXML
    private TextField txtRepeticoes;

    @FXML
    private ChoiceBox<String> choiceBoxTipoLista;

    @FXML
    private TextField txtNomeCliente;

    @FXML
    private TextField txtNomeProfessor;

    private FichaTreino fichaTreino;

    @FXML
    void initialize() {
        choiceBoxTipoLista.getItems().addAll("A", "B", "C");
        choiceBoxTipoLista.setValue("A"); // Define "A" como padrão
    }

    @FXML
    void adicionarExercicio() {
        try {
            String nomeExercicio = txtNomeExercicio.getText();
            int series = Integer.parseInt(txtSeries.getText());
            int repeticoes = Integer.parseInt(txtRepeticoes.getText());
            String tipoLista = choiceBoxTipoLista.getValue();
            String nomeCliente = txtNomeCliente.getText();
            String nomeProfessor = txtNomeProfessor.getText();

            Exercicio exercicio = new Exercicio(nomeExercicio, series, repeticoes);

            // Verifica se o cliente e o professor existem
            Cliente cliente = encontrarCliente(nomeCliente);
            Professor professor = encontrarProfessor(nomeProfessor);

            if (cliente != null && professor != null) {
                // Cria a ficha de treino se ainda não existir
                if (fichaTreino == null) {
                    fichaTreino = new FichaTreino(professor, cliente, tipoLista);
                }

                // Adiciona o exercício à ficha de treino
                fichaTreino.adicionarExercicio(tipoLista, exercicio);

                // Adiciona a ficha de treino ao repositório
                RepositorioTreinos repositorioTreinos = new RepositorioTreinos(100);
                repositorioTreinos.cadastrar(fichaTreino);

                exibirAlertaInformativo("Exercício adicionado", "Exercício adicionado com sucesso à ficha de treino e ao repositório.");
            } else {
                exibirAlertaErro("Erro ao adicionar exercício", "Cliente ou professor não encontrado.");
            }
        } catch (NumberFormatException e) {
            exibirAlertaErro("Erro de formato", "Por favor, insira números válidos para séries e repetições.");
        } catch (IllegalArgumentException e) {
            exibirAlertaErro("Erro ao adicionar exercício", e.getMessage());
        }
    }


    private Cliente encontrarCliente(String nomeCliente) {
        System.out.println("Buscando cliente com o nome: " + nomeCliente);
        Cliente cliente = Main.repositorioGeral.getRepositorioClientes().buscar(nomeCliente);
        System.out.println("Cliente encontrado: " + cliente); // Verifique se o cliente foi encontrado
        return cliente;
    }

    private Professor encontrarProfessor(String cpfProfessor) {
        System.out.println("Buscando professor com CPF: " + cpfProfessor);
        Professor professor = Main.repositorioGeral.getRepositorioProfessores().buscar(cpfProfessor);
        System.out.println("Professor encontrado: " + professor); // Verifique se o professor foi encontrado
        return professor;
    }

    private void exibirAlertaInformativo(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    private void exibirAlertaErro(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
