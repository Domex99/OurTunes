/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ourtunes.dal.DAOs;

import ourtunes.be.Song;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import ourtunes.dal.DatabaseConnection;

/**
 *
 * @author XMdag
 */
public class SongDAO {

    private DatabaseConnection connector;
    private PlaylistSongsDAO playlistsongsdao;

    public SongDAO() 
    {
        playlistsongsdao = new PlaylistSongsDAO();
        connector = new DatabaseConnection();
    }
//Gets All songs from the database

    public List<Song> getAllSongs() {
        String sqlStatement = "SELECT * FROM Song";
        List<Song> allSongs = new ArrayList();
        try (Connection con = connector.getConnection()) {

            PreparedStatement statement = con.prepareStatement(sqlStatement);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int songID = rs.getInt("songID");
                String name = rs.getString("name");
                String artist = rs.getString("artist");
                String genre = rs.getString("genre");
                String path = rs.getString("path");
                int time = rs.getInt("time");
                allSongs.add(new Song(songID, name, artist, genre, time, path));
            }

        } catch (SQLServerException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return allSongs;
    }
    
    //Creates a song in database.
    public Song createSong(int songID, String name, String artist, String genre, int time, String path) throws SQLException
    {
     String sqlStatement = "INSERT INTO Song(songID, name, artist, genre, time, path) values(?,?,?,?,?,?)";
     try(Connection con = connector.getConnection();
             PreparedStatement statement = con.prepareStatement(sqlStatement, Statement.RETURN_GENERATED_KEYS))
     {
         statement.setInt(1, songID);
         statement.setString(2, name);
         statement.setString(3, artist);
         statement.setString(4, genre);
         statement.setInt(5, time);
         statement.setString(6, path);
         statement.execute();
         ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            return new Song(songID, name, artist, genre, time, path);
     }
    } 
    
    //Updates the song in database.
    public Song updateSong(Song song, String newName, String newArtist, String newGenre) throws SQLException
    {
        String sqlStatement = "UPDATE Songs SET name=?, artist=?, genre=? WHERE id=?";
        try(Connection con = connector.getConnection();
                PreparedStatement statement = con.prepareStatement(sqlStatement))
        {
            statement.setString(1, newName);
            statement.setString(2, newArtist);
            statement.setString(3, newGenre);
            statement.setInt(4, song.getSongID());
            statement.execute();
            song.setName(newName);
            song.setArtist(newArtist);
            song.setGenre(newGenre);
            return song;
        }
    }
    
    /*Uses object of PlaylistSongsDAO class to delete song from
     all playlists that contain this song and then completely deletes song from database.*/
    public void deleteSong(Song song) throws SQLException
    {
        playlistsongsdao.deleteSongFromAllPlaylists(song);
        String sqlStatement = "DELETE FROM Songs WHERE id=?";
        try(Connection con = connector.getConnection();
                PreparedStatement statement = con.prepareStatement(sqlStatement))
        {
            statement.setInt(1, song.getSongID());
            statement.execute();
        }
    }
    
    
    
}
