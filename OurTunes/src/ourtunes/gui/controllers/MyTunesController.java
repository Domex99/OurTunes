/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ourtunes.gui.controllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import ourtunes.be.Song;
import ourtunes.bll.BllManager;
import ourtunes.dal.DalController;

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
    @FXML
    private TableView<Song> songTableView;
    @FXML
    private TableColumn<Song, String> songName;
    @FXML
    private TableColumn<Song,String > artistName;
    @FXML
    private TableColumn<Song,String > genreName;
    @FXML
    private Button stopSong;
    @FXML
    private Button playSong;
    @FXML
    private Slider volumeSlider;
    @FXML
    private TableColumn<?, ?> songTime;
    @FXML
    private TableColumn<?, ?> songTime1;
    @FXML
    private ImageView playingSong;
    @FXML
    private Label currentSong;
    
    private BllManager blMan;
    
    File songFile = new File("C:\\Users\\hp\\Desktop\\tunes_songs\\Jeff Mills - The Bells.mp3");
        Media m = new Media(songFile.toURI().toString());
        MediaPlayer mp = new MediaPlayer(m);

    public MyTunesController() throws IOException {
          blMan = new BllManager();
       // lstSongs.getItems().add(this);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<Song> listOfSongs = null;

        listOfSongs = blMan.getAllSongs();

        ObservableList<Song> songlist = FXCollections.observableArrayList();
        songlist.addAll(listOfSongs);
        
                songName.setCellValueFactory(new PropertyValueFactory<>("name"));
                artistName.setCellValueFactory(new PropertyValueFactory<>("artist"));
                genreName.setCellValueFactory(new PropertyValueFactory<>("genre"));
                songTime.setCellValueFactory(new PropertyValueFactory<>("timeAsString"));
                
                
                
                
songTableView.setItems(songlist);
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

    @FXML
    private void songStop(ActionEvent event) 
    {
        mp.stop();
    }

    private void songPause(ActionEvent event) 
    {
        mp.pause();
    }

    @FXML
    private void songPlay(ActionEvent event) 
    {
        mp.play();
    }

    @FXML
    private void setSound(MouseEvent event) {
         if (mp != null) {
            mp.setVolume(volumeSlider.getValue());
        }
}

    @FXML
    private void playSong(MouseEvent event) {
    }
}
