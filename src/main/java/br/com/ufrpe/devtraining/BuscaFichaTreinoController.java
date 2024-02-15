package br.com.ufrpe.devtraining;

import br.com.ufrpe.devtraining.dados.RepositorioTreinos;
import br.com.ufrpe.devtraining.negocio.entidades.Exercicio;
import br.com.ufrpe.devtraining.negocio.entidades.FichaTreino;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.List;

public class BuscaFichaTreinoController {
    private RepositorioTreinos repositorioTreinos;

    @FXML
    private Button BtnVoltar;

    @FXML
    private TextField nomeClienteField;
    @FXML
    private Label LblFicha;

    @FXML
    private TextField tipoExercicioField;

    public BuscaFichaTreinoController() {
        // Construtor padrão sem parâmetros
    }
    @FXML
    void VoltarTelaMenu(ActionEvent event) throws IOException {
        Main.trocarTela(new FXMLLoader(Main.class.getResource("TelaMenuNova.fxml")).load());
    }

    public BuscaFichaTreinoController(RepositorioTreinos repositorioTreinos) {
        this.repositorioTreinos = repositorioTreinos;
    }

    @FXML
    private void buscarFichasPorNomeClienteETipo() {
        String nomeCliente = nomeClienteField.getText();
        String tipoExercicio = tipoExercicioField.getText();
        List<FichaTreino> fichasEncontradas = Main.repositorioGeral.getRepositorioTreinos().buscarPorNomeClienteETipo(nomeCliente, tipoExercicio);
        if (!fichasEncontradas.isEmpty()) {
            exibirFichaNaInterface(fichasEncontradas.get(0)); // Exibir apenas a primeira ficha encontrada
            StringBuilder todasFichas = new StringBuilder();
            int contadorFichas = 0;
            for (FichaTreino ficha : fichasEncontradas) {
                todasFichas.append(ficha.toString()).append("\n");
                contadorFichas++;
                // Limitar o número de fichas de treino exibidas para evitar sobrecarregar o Label
                if (contadorFichas >= 5) {
                    todasFichas.append("... (mais fichas disponíveis)");
                    break;
                }
            }
            LblFicha.setText(todasFichas.toString());
        } else {
            exibirAlerta("Nenhuma ficha de treino encontrada para o cliente e tipo de exercício especificados.");
        }
    }


    private void exibirAlerta(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Aviso");
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    private void exibirFichaNaInterface(FichaTreino ficha) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Cliente: ").append(ficha.getCliente().getNome()).append("\n");
        stringBuilder.append("Professor: ").append(ficha.getProfessor().getNome()).append("\n");
        stringBuilder.append("Data de Criação: ").append(ficha.getDataCriacao()).append("\n");
        stringBuilder.append("Tipo de Treino: ").append(ficha.getTipoTreino()).append("\n");

        // Exibir os exercícios por tipo
        stringBuilder.append("Exercícios:\n");
        for (String tipo : ficha.getExerciciosPorTipo().keySet()) {
            stringBuilder.append(tipo).append(":\n");
            for (Exercicio exercicio : ficha.getExerciciosPorTipo().get(tipo)) {
                stringBuilder.append("- Nome: ").append(exercicio.getNome()).append(", Séries: ").append(exercicio.getSeries()).append(", Repetições: ").append(exercicio.getRepeticoes()).append("\n");
            }
        }


    }
}
