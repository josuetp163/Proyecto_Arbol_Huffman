/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.main;

import ec.edu.espol.UI.PantallaPrincipal;
import ec.edu.espol.constants.Constantes;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author micharce
 */

public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage){
        PantallaPrincipal pp = new PantallaPrincipal(stage);
    }
    
    @Override
    public void init(){
        setUserAgentStylesheet(Constantes.RUTASTYLE);
    }
}
