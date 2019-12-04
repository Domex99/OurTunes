/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ourtunes.gui.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author XMdag
 */
public class AddPlaylistController implements Initializable {

    @FXML
    private Button saveNewPlaylist;
    @FXML
    private Button cancelSavingPlaylist;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void savesPlaylist(ActionEvent event) {
        
    }

    @FXML
    private void cancelsSavingPlaylist(ActionEvent event) {
        Stage stage = (Stage) cancelSavingPlaylist.getScene().getWindow();
    
    stage.close();
    }
    
}
