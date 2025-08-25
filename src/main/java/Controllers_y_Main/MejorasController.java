package Controllers_y_Main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

import static Controllers_y_Main.Boton.contador;

public class MejorasController {
    @FXML
    private Button Click1;
    @FXML
    private Label precioLabel;

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
}