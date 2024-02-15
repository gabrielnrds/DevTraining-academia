package br.com.ufrpe.devtraining;

import br.com.ufrpe.devtraining.dados.RepositorioTreinos;
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

public class BuscarFichaExcluir {
    private RepositorioTreinos repositorioTreinos;

    @FXML
    private Button BtnVoltar;
    @FXML
    private Button BtnExcluir;

    @FXML
    private TextField nomeClienteField;
    @FXML
    private Label LblFicha;

    @FXML
    private TextField tipoExercicioField;

    public BuscarFichaExcluir() {
        // Construtor padrão sem parâmetros
    }

    @FXML
    void VoltarTelaMenu(ActionEvent event) throws IOException {
        Main.trocarTela(new FXMLLoader(Main.class.getResource("TelaMenuNova.fxml")).load());
    }

    public BuscarFichaExcluir(RepositorioTreinos repositorioTreinos) {
        this.repositorioTreinos = repositorioTreinos;
    }

    @FXML
    private void buscarFichasPorNomeClienteETipo() {
        String nomeCliente = nomeClienteField.getText();
        String tipoExercicio = tipoExercicioField.getText();
        List<FichaTreino> fichasEncontradas = Main.repositorioGeral.getRepositorioTreinos().buscarPorNomeClienteETipo(nomeCliente, tipoExercicio);

        if (!fichasEncontradas.isEmpty()) {
            exibirFichasNaInterface(fichasEncontradas);

            // Remover as fichas associadas ao cliente (opcional)
            Main.repositorioGeral.getRepositorioTreinos().removerPorNomeCliente(nomeCliente);
        } else {
            exibirAlerta("Nenhuma ficha de treino encontrada para o cliente e tipo de exercício especificados.");
        }
    }

    @FXML
    private void excluirFicha(ActionEvent event) {

        String nomeCliente = nomeClienteField.getText();
        if (!nomeCliente.isEmpty()) {
            Main.repositorioGeral.getRepositorioTreinos().removerPorNomeCliente(nomeCliente);
            exibirAlerta("Ficha de treino excluída com sucesso.");

        } else {
            exibirAlerta("Por favor, insira um nome de cliente válido.");
        }
    }

    private void exibirFichasNaInterface(List<FichaTreino> fichas) {
        StringBuilder todasFichas = new StringBuilder();
        for (FichaTreino ficha : fichas) {
            todasFichas.append(ficha.toString()).append("\n");
        }
        LblFicha.setText(todasFichas.toString());
    }

    private void exibirAlerta(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Aviso");
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
