/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demonfolderfxml;

import demonfolder.preferences.Preferences;
import demonfolder.service.Service;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.DirectoryChooser;

/**
 *
 * @author Maxime
 */
public class FXMLDocumentController implements Initializable {
    Service serv = new Service();
    DirectoryChooser chooser = new DirectoryChooser();
    
    
    
    @FXML
    private Label path;
         
    @FXML
    private void browse(ActionEvent event) {
        try {
            File selectedDirectory = chooser.showDialog(DemonFolderFXML.appStage);
            path.setText(selectedDirectory.getPath());
            chooser.setInitialDirectory(new File(path.getText()));
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @FXML
    private void reorganize(ActionEvent event) {
        Preferences.ROOT_PATH = path.getText();
        File repository = new File(Preferences.ROOT_PATH);
        
        Preferences.MUSIC_PATH = Preferences.ROOT_PATH + "\\Music";
        File music = new File(Preferences.MUSIC_PATH);
        Preferences.PICTURE_PATH = Preferences.ROOT_PATH + "\\Picture";
        File picture = new File(Preferences.PICTURE_PATH);
        Preferences.DOCUMENT_PATH = Preferences.ROOT_PATH + "\\Document";
        File document = new File(Preferences.DOCUMENT_PATH);
 
        serv.createFolderIfNotExist(repository);
        serv.createFolderIfNotExist(music);
        serv.createFolderIfNotExist(picture);
        serv.createFolderIfNotExist(document);
        
        serv.classificationOfFiles();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
