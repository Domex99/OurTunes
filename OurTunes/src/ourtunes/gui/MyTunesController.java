/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ourtunes.gui;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
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
    private TextField txtMovieSearcjh;

    /**
     * The TextField containing the query word.
     */
    @FXML
    private ListView<Song> lstSongs;
    
    private BllManager bllmanager = new BllManager();


    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
 

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        ObservableList<Song> songlist;
        try {
            songlist = FXCollections.observableArrayList(bllmanager.getAllSongs());
        } catch (SQLException ex) {
            Logger.getLogger(MyTunesController.class.getName()).log(Level.SEVERE, null, ex);
        }
       lstSongs.setItems(songlist);
    
        
    }
    
}
