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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import ourtunes.be.Playlist;
import ourtunes.be.Song;
import ourtunes.bll.BllManager;
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
    @FXML
    private TableColumn<Playlist, String> playlistName;

    private BllManager blMan;
    private TableView<Song> songTableView;
    private TableColumn<Song, String> songName;
    private TableColumn<Song,String > artistName;
    
         File songFile = new File("C:\\Users\\XMdag\\Desktop\\test.mp3");
                Media m = new Media(songFile.toURI().toString());
                MediaPlayer mp = new MediaPlayer(m);


    public MyTunesController()  {
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

        List<Playlist> listOfPlaylists = null;

        try {
            listOfPlaylists = blMan.getAllPlaylists();
        } catch (SQLException ex) {
            Logger.getLogger(MyTunesController.class.getName()).log(Level.SEVERE, null, ex);
        }

        ObservableList<Playlist> playlists = FXCollections.observableArrayList();
        playlists.addAll(listOfPlaylists);
        
                playlistName.setCellValueFactory(new PropertyValueFactory<>("name"));
                          
                
                
                
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

    private void playSelectedSong(ActionEvent event) {

        mp.play();
    }

    private void pauseCurrentSong(ActionEvent event) {

        mp.pause();
    }

    private void stopCurrentSong(ActionEvent event) {

                mp.stop();
    }

    
}
