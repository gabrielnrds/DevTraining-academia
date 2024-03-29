// Main.java
package br.com.ufrpe.devtraining;

import br.com.ufrpe.devtraining.dados.RepositorioGeral;
import br.com.ufrpe.devtraining.dados.SaveManager;
import br.com.ufrpe.devtraining.negocio.entidades.Usuario;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static RepositorioGeral repositorioGeral;
    public static Stage stage;
    public static Usuario usuarioLogado;

    @Override
    public void start(Stage stage) throws IOException {
        // Inicialize o repositório geral
        repositorioGeral = new RepositorioGeral();

        // Carregue os dados salvos
        SaveManager saveManager = new SaveManager(repositorioGeral);
        saveManager.carregar();

        stage.setMinHeight(600);
        stage.setMinWidth(200);
        this.stage = stage;
        stage.setResizable(false);
        FXMLLoader root = new FXMLLoader(Main.class.getResource("telaLogin.fxml"));
        Scene scene = new Scene(root.load());

        stage.setScene(scene);
        stage.setTitle("DevTraining");
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        SaveManager saveManager = new SaveManager(repositorioGeral);
        saveManager.salvar();
        super.stop();
    }

    public static void trocarTela(Parent janela) {
        Scene scene = new Scene(janela);
        stage.setScene(scene);
    }

    public static void main(String[] args) {
        launch();
    }
}
