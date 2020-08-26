/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.UI;

import arbol_huffman.ArbolHuffman;
import arbol_huffman.Operaciones;
import arbol_huffman.Util;
import ec.edu.espol.constants.Constantes;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import javafx.geometry.Pos;
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
        accionComprimir(stage);
        accionDescomprimir(stage);
    }

    private void crearEstructura(Stage mainStage) {
        panePrincipal = new BorderPane();
        mainScene = new Scene(panePrincipal, 400, 400);
        mainStage.setScene(mainScene);
        comprimir = new Button("Comprimir Archivo");
        descomprimir = new Button("Descomprimir Archivo");
        VBox vb = new VBox();
        vb.getChildren().addAll(comprimir, descomprimir);
        panePrincipal.setCenter(vb);
        vb.setAlignment(Pos.CENTER);
        mainStage.setTitle("ARBOL HUFFMAN");
        mainStage.show();
    }

    private void accionComprimir(Stage stage) {
        comprimir.setOnAction(e -> {
            Label lb = new Label();
            VBox vb = new VBox();
            vb.getChildren().add(lb);
            panePrincipal.setBottom(vb);
            FileChooser fc = new FileChooser();
            fc.setTitle("Seleccionar un archivo");
            File selectedFile = fc.showOpenDialog(stage);
            if (selectedFile != null) {
                Operaciones.compressionProcess(selectedFile);
                lb.setText("Comprimido con éxito: " + selectedFile.getName());
            } else {
                lb.setText("Selección de archivos cancelada.");
            }
        });
    }

    private void accionDescomprimir(Stage stage) {
        descomprimir.setOnAction(e -> {
            Label lb = new Label();
            VBox vb = new VBox();
            vb.getChildren().add(lb);
            panePrincipal.setBottom(vb);
            FileChooser fc = new FileChooser();
            fc.setTitle("Seleccionar un archivo");
            List<File> selectedFiles = fc.showOpenMultipleDialog(stage);
            if (selectedFiles != null) {
                Operaciones.decompressionProcess(selectedFiles.get(0), selectedFiles.get(1));
                lb.setText("Descomprimido con éxito: " + selectedFiles.get(0) + ", " + selectedFiles.get(1));
            } else {
                lb.setText("Selección de archivos cancelada");
            }
        });
    }
}
