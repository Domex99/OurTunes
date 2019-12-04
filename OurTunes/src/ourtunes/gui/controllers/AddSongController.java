/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ourtunes.gui.controllers;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ourtunes.be.Song;
import ourtunes.bll.BllManager;

/**
 * FXML Controller class
 *
 * @author XMdag
 */
public class AddSongController implements Initializable {

    @FXML
    private Button saveSong;
    @FXML
    private TextField inputSongName;
    @FXML
    private Button cancelSavingSong;
    @FXML
    private Button chooseSongPath;
    @FXML
    private ChoiceBox<?> genreChoiceBox;

    BllManager manager;
    @FXML
    private TextField inputSongPath;
    @FXML
    private TextField inputSongArtist;
    @FXML
    private TextField inputSongLength;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        manager = new BllManager();
    }    

    @FXML
    private void savesTheSong(ActionEvent event) {
        try {
            String name = inputSongName.getText();
            String artist = inputSongArtist.getText();
            String genre = "Techno";
            int time = Integer.valueOf(inputSongLength.getText());
            String path = inputSongPath.getText();
            Song song = new Song(name, artist, genre, 100, time, path);
            manager.addSong(song);
        } catch (SQLException ex) {
            Logger.getLogger(AddSongController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void cancelsSavingSong(ActionEvent event) {
        Stage stage = (Stage) cancelSavingSong.getScene().getWindow();
    
    stage.close();
    }

    @FXML
    private void choosesSongPath(ActionEvent event) {
    }
    
}
