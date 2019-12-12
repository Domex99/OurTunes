/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ourtunes.bll;

import java.util.List;
import ourtunes.be.Playlist;
import ourtunes.be.Song;

/**
 *
 * @author dpank
 */
public interface LogicFacade {
    
    
    //Gets a list of all playlists.
    List<Playlist> getAllPlaylists();
    
    
    //Creates a playlist.
    Playlist createPlaylist(String name);
    
    
    //Edits the playlist with new name.
    Playlist editPlaylist(Playlist playlsit, String newName);
    
     
    //Deletes specified playlist.
    void deletePlaylist(Playlist playlist);
    
    //Creates a song in database.
    Song createSong(int songID, String name, String artist, String genre, int time, String path);
    
    //Updates the song in database.
    Song updateSong(Song song, String newName, String newArtist, String newGenre);
    
    //Deletes song from database.
    void deleteSong(Song song);
    
    //Gets all song from database.
    List<Song> getAllSongs();
    
    //Deletes song from playlist.
    void deleteSongFromPlaylist(Playlist playlist, Song song);
    
    //Adds song to playlist.
    Playlist addSongToPlaylist(Playlist playlist, Song song);
    
    //Switches the places of songs in database.
    Playlist switchSongsPlacesOnPlaylist(Playlist playlist, Song firstSong, Song secondSong);
    
    
    
    
    
    
}
