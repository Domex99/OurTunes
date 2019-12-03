/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ourtunes.gui.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import ourtunes.be.Song;
import ourtunes.dal.DalFacade;

/**
 *
 * @author hp
 */
public class MyTunesController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button newPlaylist;
    @FXML
    private Button editPLaylist;
    @FXML
    private Button deletePLaylist;
    @FXML
    private Button deleteSongFromPlaylist;
    @FXML
    private Button goUp;
    @FXML
    private Button goDown;
    @FXML
    private Button newSong;
    @FXML
    private Button deleteSong;
    @FXML
    private ImageView rewindBack;
    @FXML
    private ImageView rewindForward;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void createNewPlaylist(ActionEvent event) throws IOException {
        Parent root1;
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ourtunes/gui/view/AddPlaylist.fxml"));
            root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1, 650, 650));
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    private void onClickEditPlaylist(ActionEvent event) throws IOException {
        Parent root1;
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ourtunes/gui/view/EditPlaylist.fxml"));
            root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1, 650, 650));
        stage.centerOnScreen();
        stage.show();
        
    }

    @FXML
    private void onClickDeletePlaylist(ActionEvent event) {
        
    }

    @FXML
    private void addNewSong(ActionEvent event)throws IOException {   
         Parent root1;
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ourtunes/gui/view/AddSong.fxml"));
            root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1, 650, 650));
        stage.centerOnScreen();
        stage.show();
    }
    
}