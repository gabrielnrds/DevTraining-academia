package br.com.ufrpe.devtraining;

import br.com.ufrpe.devtraining.dados.RepositorioGeral;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import java.io.IOException;

public class Main extends Application {
    public static RepositorioGeral repositorioGeral;
    public static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        repositorioGeral = new RepositorioGeral();

        stage.setMinHeight(600);
        stage.setMinWidth(960);
        this.stage = stage;
        stage.setResizable(true);
        FXMLLoader root = new FXMLLoader(Main.class.getResource("telaLogin.fxml"));
        Scene scene = new Scene(root.load());

        stage.setScene(scene);
        stage.setTitle("DevTraining");
        stage.show();

    }
    public static void trocartela(Parent janela) {
        Scene scene = new Scene(janela);
        stage.setScene(scene);
    }

    public static void main(String[] args) {
        launch();
    }
}