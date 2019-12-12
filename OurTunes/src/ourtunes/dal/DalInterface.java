/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ourtunes.dal;

import java.util.List;
import ourtunes.be.Playlist;
import ourtunes.be.Song;

/**
 *
 * @author XMdag
 */
public interface DalInterface {
    
    //Creates a song in database.
    public Song createSong(int songID, String name, String artist, String genre, int time, String path);
    
    //Updates the song in database.
    public Song updateSong(Song song, String newTitle, String newArtist, String newGenre);
    
    //Deletes song from database.
    void deleteSong(Song song);
    
    //Gets all songs from database
    public List<Song> getAllSongs();

    //Creates a Playlist in the database.
    public Playlist createPlaylist(Playlist playlist, String name);
    
    //Updates the name of the playlist in the database.
    public Playlist editPlaylist(Playlist playlist, String newName);
    
    //Deletes playlist from the database.
    public void deletePlaylist(Playlist playlist);
    
    /*Gets a list with all playlists from the database for given user. All playlists
    consist of all songs that appears on them.*/
    public List<Playlist> getAllPlaylists();
    
    //Switches the places of songs in database.
    public Playlist switchSongsPlacesOnPlaylist(Playlist playlist, Song firstSong, Song secondSong);
    
    //Deletes song from given playlist in database.
    public void deleteSongFromPlaylist(Playlist playlist, Song song);
    
    //Adds a song to the playlist in database.
    public Playlist addSongToPlaylist(Playlist playlist, Song song);
    
    //Gets a list with names of all genres from the database.
    public List<String> getAllGenres();



    
    
}
