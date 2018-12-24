/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demonfolderfxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Maxime
 */
public class DemonFolderFXML extends Application {
    public static Stage appStage;
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("DemonFX");
        /*stage.getIcons().add(
        new Image(<yourclassname>.class.getResourceAsStream( "icon.png" ))); 
        */
        stage.setResizable(false);
        //stage.initStyle(StageStyle.UNDECORATED);
        
        appStage = stage;
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
