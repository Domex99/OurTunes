/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ourtunes.bll;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ourtunes.be.Playlist;
import ourtunes.be.Song;
import ourtunes.dal.DalController;
import ourtunes.dal.DalInterface;

/**
 *
 * @author XMdag
 */
public class BllManager implements LogicFacade {
    
    private DalInterface dalInter;
    private Playlist playlist;
    
    public BllManager()
    {
        try {
            dalInter = new DalController();
        } catch (IOException ex) {
            Logger.getLogger(BllManager.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }

    @Override
    public List<Playlist> getAllPlaylists() 
    {
        return dalInter.getAllPlaylists();
    }

    @Override
    public Playlist createPlaylist(String name) 
    {
        return dalInter.createPlaylist(playlist, name);
    }

    @Override
    public Playlist editPlaylist(Playlist playlsit, String newName) 
    {
        return dalInter.editPlaylist(playlist, newName);
    }

    @Override
    public void deletePlaylist(Playlist playlist) 
    {
        dalInter.deletePlaylist(playlist);
    }

    @Override
    public Song createSong(int songID, String name, String artist, String genre, int time, String path) 
    {
        return dalInter.createSong(songID, name, artist, genre, time, path);
    }

    @Override
    public Song updateSong(Song song, String newName, String newArtist, String newGenre) 
    {
        return dalInter.updateSong(song, newGenre, newArtist, newGenre);
    }

    @Override
    public void deleteSong(Song song) 
    {
        dalInter.deleteSong(song);
    }

    @Override
    public List<Song> getAllSongs() 
    {
        return dalInter.getAllSongs();
    }

    @Override
    public void deleteSongFromPlaylist(Playlist playlist, Song song) 
    {
        dalInter.deleteSongFromPlaylist(playlist, song);
    }

    @Override
    public Playlist addSongToPlaylist(Playlist playlist, Song song)
    {
        return dalInter.addSongToPlaylist(playlist, song);
    }

    @Override
    public Playlist switchSongsPlacesOnPlaylist(Playlist playlist, Song firstSong, Song secondSong) 
    {
        return dalInter.switchSongsPlacesOnPlaylist(playlist, firstSong, secondSong);
    }
     
}
