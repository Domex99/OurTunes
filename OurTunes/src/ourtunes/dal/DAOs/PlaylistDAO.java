/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ourtunes.dal.DAOs;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import ourtunes.be.Playlist;
import ourtunes.be.Song;
import ourtunes.dal.DatabaseConnection;

/**
 *
 * @author XMdag
 */
public class PlaylistDAO {
    

    

private DatabaseConnection connector;
private PlaylistSongsDAO psDao;

public PlaylistDAO()
{
connector = new DatabaseConnection();
psDao = new PlaylistSongsDAO();

}

   public Playlist createPlaylist(String playlistName) throws SQLServerException, SQLException {
        String sqlStatement = "INSERT INTO Playlists(name) values(?)";
        try(Connection con = connector.getConnection();
                PreparedStatement statement = con.prepareStatement(sqlStatement, Statement.RETURN_GENERATED_KEYS))
        {
            
            statement.setString(1, playlistName);
            statement.execute();
            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            return new Playlist(id, playlistName);
        }
    }
   
      /*
    Updates specified playlist with user given name
     */
    public void updatePlaylist(Playlist selectedItem, String name) {
        try (Connection con = connector.getConnection()) {
            String query = "UPDATE Playlist set name = ? WHERE id = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, name);
            preparedStmt.setInt(2, selectedItem.getplaylistID());
            preparedStmt.executeUpdate();
        } catch (SQLServerException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
   
//Gets All playlists from the database
    public List<Playlist> getAllPlaylist() throws SQLException
    {
        String sqlStatement = "SELECT * FROM Playlists";
        List<Playlist> allPlaylists = new ArrayList();
        try(Connection con = connector.getConnection();
                PreparedStatement statement = con.prepareStatement(sqlStatement))
        {

            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
                int playlistID = rs.getInt("playlistID");
                String playlistName = rs.getString("playlistName");
                int playlistLength = rs.getInt("playlistLength");
                allPlaylists.add(new Playlist(playlistID, playlistName));
            }
        }
        return allPlaylists;
    }
    
     /*
    Counts all combined time of all songs in the playlist and outputs it in seconds.
     */
    private int countTotalTime(List<Song> allSongs) {
        int totalTime = 0;
        for (Song allSong : allSongs) {
            totalTime += allSong.getTime();
        }
        return totalTime; //returns total count in seconds
    }
    
    public void deletePlaylist(Playlist playlist) throws SQLException
    {
        psDao.deleteAllSongsFromPlaylist(playlist);
        String sqlStatement = "DELETE FROM Playlists WHERE id=?";
        try(Connection con = connector.getConnection();
                PreparedStatement statement = con.prepareStatement(sqlStatement))
        {
            statement.setInt(1, playlist.getplaylistID());
            statement.execute();
        }
    }

    public List<Playlist> getAllPlaylists() throws SQLServerException, SQLException {
{
        String sqlStatement = "SELECT * FROM Playlists";
        List<Playlist> allPlaylists = new ArrayList();
        try(Connection con = connector.getConnection();
                PreparedStatement statement = con.prepareStatement(sqlStatement))
        {
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                allPlaylists.add(new Playlist(id, name));
            }
            psDao.addAllSongsToPlaylists(allPlaylists);
        }
        return allPlaylists;
    }    
    }
   
}

