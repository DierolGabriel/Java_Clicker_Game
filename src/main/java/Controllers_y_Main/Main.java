package Controllers_y_Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class Main extends Application
{
    @Override
    public void start(Stage stage) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Boton.fxml"));

        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Boton");


        stage.setWidth(601);
        stage.setHeight(621);
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
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            stage.setTitle("Menu");
            stage.setScene(scene);
            stage.show();
        }
    }
}