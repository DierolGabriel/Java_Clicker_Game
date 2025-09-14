package Controllers_y_Main;

import eu.hansolo.tilesfx.events.ChartDataEventListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.awt.event.WindowEvent;
import java.io.IOException;

import static Controllers_y_Main.Boton.contador;

public class MejorasController {
    @FXML
    private Button Click1;
    @FXML
    private Button Click2;
    @FXML
    private Button Click3;
    @FXML
    private Button Click5;

    @FXML
    private Label precioLabel;
    @FXML
    private Label precioLabel2;
    @FXML
    private Label precioLabel3;
    @FXML
    private Label precioLabel5;

    private int precio = 10;

    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Mejoras.fxml"));
        Scene scene = new Scene(root, 285, 568);
        stage.setTitle("Mejoras");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

        stage.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                stage.close();
            }
        });
    }

    @FXML
    public void initialize() {
        if (MejorasManager.estaComprado("1")) {
            Click1.setText("Comprado");
            Click1.setDisable(true);
            precioLabel.setText("");
        } else {
            precioLabel.setText("Price: " + precio + " clicks");
        }
        if (MejorasManager.estaComprado("2")) {
            Click2.setText("Comprado");
            Click2.setDisable(true);
            precioLabel2.setText("");
        }
        if (MejorasManager.estaComprado("3")) {
            Click3.setText("Comprado");
            Click3.setDisable(true);
            precioLabel3.setText("");
        }
        if (MejorasManager.estaComprado("5")) {
            Click5.setText("Comprado");
            Click5.setDisable(true);
            precioLabel5.setText("");
        }
    }

    @FXML
    void Clik1(ActionEvent event) {
        if (contador >= precio) {
            MejorasManager.guardarMejora("1");
            contador -= precio;
            Boton.cps += 1;

            precioLabel.setText("");
            Click1.setText("Comprado");
            Click1.setDisable(true);
        }
    }
    @FXML
    void Click2(ActionEvent event) {
        if (contador >= 100) {
            MejorasManager.guardarMejora("2");
            contador -= 100;
            Boton.cps += 5;

            precioLabel2.setText("");
            Click2.setText("Comprado");
            Click2.setDisable(true);
        }
    }
    @FXML
    void Click3(ActionEvent event)
    {
        if (contador >= 500) {
            MejorasManager.guardarMejora("3");
            contador -= 500;
            Boton.cps += 100;

            precioLabel3.setText("");
            Click3.setText("Comprado");
            Click3.setDisable(true);
        }
    }

    @FXML
    void Click5(ActionEvent event) {
        if (contador >= 1000) {
            MejorasManager.guardarMejora("5");
            contador -= 1000;


            precioLabel5.setText("");
            Click5.setText("Comprado");
            Click5.setDisable(true);
        }
    }
}