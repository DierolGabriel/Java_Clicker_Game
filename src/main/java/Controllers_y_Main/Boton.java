package Controllers_y_Main;

import com.sun.javafx.charts.Legend;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Boton {


    @FXML
    private Button Upgrades;
    @FXML
    private Button Boton;
    @FXML
    private Label Numero;
    @FXML
    private Label CPSLabel;

    public static int contador = 0;
    public static int cps = 0;
    private Timeline cpsTimeline;

    public void initialize() {
        MejorasManager.inicializarArchivoGuardado();

        if (MejorasManager.estaComprado("1")) {
            cps += 1;
        }
        if (MejorasManager.estaComprado("2")) {
            cps += 5;
        }
        if (MejorasManager.estaComprado("3")) {
            cps += 10;
        }


        iniciarCPS();

        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Numero.setText(String.valueOf(contador));
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    private void iniciarCPS() {
        cpsTimeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            contador += cps;
            Numero.setText(String.valueOf(contador));
            CPSLabel.setText("CPS: " + cps);
        }));
        cpsTimeline.setCycleCount(Timeline.INDEFINITE);
        cpsTimeline.play();
    }

    @FXML
    void Click(ActionEvent event) {
        try {
            String FilePath = "src/main/Resources/Imagenes/clickSound.wav";
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(FilePath));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            System.out.println("Error al cargar el sonido: " + e.getMessage());
        }
        contador++;
        Numero.setText(String.valueOf(contador));
        actualizarColorBoton();
    }

    private void actualizarColorBoton() {
        if (contador < 50) {
            Boton.setStyle("-fx-background-color: #4CAF50;");
        } else if (contador == 100) {
            Boton.setStyle("-fx-background-color: red;");
        } else if (contador == 150) {
            Boton.setStyle("-fx-background-color: blue;");
        } else if (contador == 200) {
            Boton.setStyle("-fx-background-color: pink;");
        } else if (contador == 250) {
            Boton.setStyle("-fx-background-color: purple;");
        } else if (contador >= 500) {
            int r = (int) (Math.random() * 256);
            int g = (int) (Math.random() * 256);
            int b = (int) (Math.random() * 256);
            String color = String.format("-fx-background-color: rgb(%d, %d, %d);", r, g, b);
            Boton.setStyle(color);
        }
    }

    @FXML
    void Upgrade(ActionEvent event) {
        try {
            Stage stage = new Stage();
            MejorasController mejorasController = new MejorasController();
            mejorasController.start(stage);
        } catch (Exception e) {
            System.out.println("Error al abrir la ventana: " + e.getMessage());
        }
    }

}