/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ourtunes.dal;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import ourtunes.be.Playlist;
import ourtunes.be.Song;
import ourtunes.dal.DAOs.GenreDAO;
import ourtunes.dal.DAOs.PlaylistDAO;
import ourtunes.dal.DAOs.PlaylistSongsDAO;
import ourtunes.dal.DAOs.SongDAO;

/**
 *
 * @author XMdag
 */
public class DalController implements DalInterface {
    
    private SongDAO songdao;
    private PlaylistDAO playlistDAO;
    private PlaylistSongsDAO playlistsongsDAO;
    private GenreDAO genreDAO;
    


public DalController() throws IOException
{

        songdao = new SongDAO();
        playlistDAO = new PlaylistDAO();
        playlistsongsDAO = new PlaylistSongsDAO();
        genreDAO = new GenreDAO();
}

    @Override
    public Song createSong(int songID, String name, String artist, String genre, int time, String path) {
        
        Song createdSong = null;
        try
        {
            createdSong = songdao.createSong(songID,  name, artist, genre, time, path);
        }
        catch(SQLException e)
        {
            //TO DO
        }
        return createdSong;
    }

    @Override
    public Song updateSong(Song song, String newTitle, String newArtist, String newGenre) {
        Song updatedSong = null;
        try
        {
            updatedSong = songdao.updateSong(song, newTitle, newArtist, newGenre);
        }
        catch(SQLException e)
        {
            //TO DO
        }
        return updatedSong;
    }

    @Override
    public void deleteSong(Song song) {
        try
        {
            songdao.deleteSong(song);
        }
        catch(SQLException e)
        {
            //TO DO
        }    
    }

    @Override
    public List<Song> getAllSongs() {
        
        List<Song> allSongs = null;
        allSongs = songdao.getAllSongs();
        return allSongs;    
    }

    @Override
    public Playlist createPlaylist(Playlist playlist, String name) {
        
        Playlist createdPlaylist = null;
        try
        {
            createdPlaylist = playlistDAO.createPlaylist(name);
        }
        catch(SQLException e)
        {
            //TO DO
        }
        return createdPlaylist;    }

    @Override
    public Playlist editPlaylist(Playlist playlist, String newName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        }

    @Override
    public void deletePlaylist(Playlist playlist) {
        try
        {
            playlistDAO.deletePlaylist(playlist);
        }
        catch(SQLException e)
        {
            //TO DO
        }    
    }

    @Override
    public List<Playlist> getAllPlaylists() {
        List<Playlist> allPlaylists = null;
        try
        {
            allPlaylists = playlistDAO.getAllPlaylists();
        }
        catch(SQLException e)
        {
            //TO DO
        }
        return allPlaylists;    }

    @Override
    public Playlist switchSongsPlacesOnPlaylist(Playlist playlist, Song firstSong, Song secondSong) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteSongFromPlaylist(Playlist playlist, Song song) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Playlist addSongToPlaylist(Playlist playlist, Song song) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> getAllGenres() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}
