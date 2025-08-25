package Controllers_y_Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class Main extends Application{

@Override
public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Boton.fxml"));
    Scene scene = new Scene(fxmlLoader.load(), 601, 650);
    stage.setTitle("Boton");
    stage.setScene(scene);
    stage.show();
}

    public static void main(String[] args)
    {
        launch();
    }

    public static class HelloApplication extends Application
    {
        @Override
        public void start(@NotNull Stage stage) throws IOException
        {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Menu.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 601, 621);
            stage.setTitle("Menu");
            stage.setScene(scene);
            stage.show();
        }
    }

    public static class Mejoras extends Application
    {
        @Override
        public void start(@NotNull Stage stage) throws IOException
        {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MejorasController.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 285, 568);

            stage.setTitle("MejorasController");
            stage.setResizable(false);
            stage.initStyle(javafx.stage.StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.show();
            stage.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    stage.close();
                }
            });
        }
    }
}