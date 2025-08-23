package Controllers_y_Main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Boton {

    @FXML
    private Button Boton;

    @FXML
    private Label Numero;

    @FXML

    int contador = 0;

    @FXML
    void Click(ActionEvent event)
    {
        try
        {
        String FilePath = "src/main/Resources/Imagenes/clickSound.wav";
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(FilePath));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        }
        catch (Exception e)
        {
            System.out.println("Error al cargar el sonido: " + e.getMessage());
        }
        contador++;
        Numero.setText(String.valueOf(contador));
        if (contador == 10)
        {
            Boton.setStyle("-fx-background-color: red;");
        }
        else if (contador == 20)
        {
            Boton.setStyle("-fx-background-color: blue;");
        }
        else if (contador == 30)
        {
            Boton.setStyle("-fx-background-color: white;");
        }
        else if (contador == 40)
        {
            Boton.setStyle("-fx-background-color: gold;");
        }
        else if (contador >= 50)
        {
            int numeroRandom = (int) (Math.random() * 256);
            int r = (int) (Math.random() * 256);
            int g = (int) (Math.random() * 256);
            int b = (int) (Math.random() * 256);
            String color = String.format("-fx-background-color: rgb(%d, %d, %d);", r, g, b);
            Boton.setStyle(color);
        }
    }


}
