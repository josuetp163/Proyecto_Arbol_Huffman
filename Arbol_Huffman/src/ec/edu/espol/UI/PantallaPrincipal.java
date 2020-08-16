/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.UI;

import java.io.File;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

/**
 *
 * @author micharce
 */
public class PantallaPrincipal {
    Scene mainScene;
    BorderPane panePrincipal;
    Button comprimir;
    Button descomprimir;
    
    public PantallaPrincipal(Stage stage) {
        stage = new Stage();
        crearEstructura(stage);
        accionesBotones(stage);
    }
    
    private void crearEstructura(Stage mainStage) {
        panePrincipal = new BorderPane();
        mainScene = new Scene(panePrincipal,400,400);
        mainStage.setScene(mainScene);
        comprimir = new Button("Comprimir Archivo");
        descomprimir = new Button("Descomprimir Archivo");
        VBox vb = new VBox();
        vb.getChildren().addAll(comprimir,descomprimir);
        panePrincipal.setCenter(vb);
        mainStage.show();
    }
    
    private void accionesBotones(Stage stage) {
        comprimir.setOnAction(e -> {
            Label lb = new Label();
            VBox vb = new VBox(); vb.getChildren().add(lb);
            panePrincipal.setBottom(vb);
            FileChooser fc = new FileChooser();
            fc.setTitle("Seleccionar un archivo");
            File selectedFile = fc.showOpenDialog(stage);
            if (selectedFile != null) {
                lb.setText("File selected: " + selectedFile.getName());
            }
            else {
                lb.setText("File selection cancelled.");
}
        });
    }
}
