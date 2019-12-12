/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ourtunes.gui.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ourtunes.be.Playlist;
import ourtunes.be.Song;
import ourtunes.bll.BllManager;
import ourtunes.bll.LogicFacade;

/**
 *
 * @author dpank
 */
public class PlaylistModel {
    
        private ObservableList<Playlist> playlists;
        private final ObservableList<Object> playlistSongs;
        private final LogicFacade bllManager;
    
        
         /*
    Initialises the constructor and the logic layer
    */
    public PlaylistModel() 
    {
    
        bllManager = new BllManager();
        
        playlists = FXCollections.observableArrayList(bllManager.getAllPlaylists());
        playlistSongs = FXCollections.observableArrayList();       
    }

    
    
}
