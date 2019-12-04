/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ourtunes.dal;

import java.util.ArrayList;
import java.util.List;
import ourtunes.be.Song;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ourtunes.dal.DatabaseConnection;

/**
 *
 * @author XMdag
 */
public class SongDAO {

    private DatabaseConnection connector;

    public SongDAO() {
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
                allSongs.add(new Song(name, artist, genre, songID, time, path));
            }

        } catch (SQLServerException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return allSongs;
    }
    public void createSong(Song song) throws SQLException
    {
     String sqlStatement = "INSERT INTO Song(songID, name, artist, genre, time, path) values(?,?,?,?,?,?)";
     try(Connection con = connector.getConnection())
     {
         PreparedStatement ps = con.prepareStatement(sqlStatement);
         ps.setInt(1, song.getSongID());
         ps.setString(2, song.getName());
         ps.setString(3, song.getArtist());
         ps.setString(4, song.getGenre());
         ps.setInt(5, song.getTime());
         ps.setString(6, song.getPath());
         ps.execute();
         
     } catch (SQLException ex)
     {
         throw new SQLException(ex);
     }
    }
    
   
}
