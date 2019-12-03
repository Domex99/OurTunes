/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ourtunes.gui.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class EditPlaylistController implements Initializable {

    @FXML
    private Button renamePlaylist;
    @FXML
    private Button addSongToPlaylist;
    @FXML
    private Button cancelEditingPlaylist;
    @FXML
    private TextField inputNewPlaylistName;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void renamePlaylistAction(ActionEvent event) {
    }

    @FXML
    private void addSongToPlaylistAction(ActionEvent event) {
    }

    @FXML
    private void cancelEditingPlaylistAction(ActionEvent event) {
          Stage stage = (Stage) cancelEditingPlaylist.getScene().getWindow();
    
    stage.close();
    }

    @FXML
    private void inputNewPlaylistNameAction(ActionEvent event) {
    }
    
}
