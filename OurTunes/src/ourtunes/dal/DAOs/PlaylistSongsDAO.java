/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ourtunes.dal.DAOs;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import ourtunes.be.Playlist;
import ourtunes.be.Song;
import ourtunes.dal.DatabaseConnection;

/**
 *
 * @author dpank
 * 
 */
public class PlaylistSongsDAO {
    
    SQLServerDataSource ds;
    private DatabaseConnection connector;
    
    
    //Adds a song to the playlist in database.
    
     public Playlist addSongToPlaylist(Playlist playlist, Song song) throws SQLException
    {
        String sqlStatement = "INSERT INTO PlaylistSongs(playlistId, songId) values(?,?)";
        try(Connection con = connector.getConnection();
                PreparedStatement statement = con.prepareStatement(sqlStatement))
        {
            statement.setInt(1, playlist.getplaylistID());
            statement.setInt(2, song.getSongID());
            statement.execute();
            playlist.addSong(song);
            return playlist;
        }
    }
     
     
    //  Deletes song from given playlist in database.
    public void deleteSongFromPlaylist(Playlist playlist, Song song) throws SQLException
    {
        String sqlStatement = "DELETE FROM PlaylistSongs WHERE playlistId=? and songId=?";
        try(Connection con = connector.getConnection();
                PreparedStatement statement = con.prepareStatement(sqlStatement))
        {
            statement.setInt(1, playlist.getplaylistID());
            statement.setInt(2, song.getSongID());
            statement.execute();
        }
    }
     
    
    //Deletes all songs from given playlist in database.
    public void deleteAllSongsFromPlaylist(Playlist playlist) throws SQLException
    {
        String sqlStatement = "DELETE FROM PlaylistSongs WHERE playlistId=?";
        try(Connection con = connector.getConnection();
                PreparedStatement statement = con.prepareStatement(sqlStatement))
        {
            statement.setInt(1, playlist.getplaylistID());
            statement.execute();
        }
    }
    

    //Deletes given song from all playlists.
    public void deleteSongFromAllPlaylists(Song song) throws SQLException
    {
        String sqlStatement = "DELETE FROM PlaylistSongs WHERE songId=?";
        try(Connection con = connector.getConnection();
                PreparedStatement statement = con.prepareStatement(sqlStatement))
        {
            statement.setInt(1, song.getSongID());
            statement.execute();
        }
    }

    void addAllSongsToPlaylists(List<Playlist> playlists) throws SQLServerException, SQLException {
{
        String sqlStatement = "SELECT Playlists.id as playlistId, Songs.* FROM PlaylistSongs " +
                                        "INNER JOIN Playlists on PlaylistSongs.playlistId=Playlists.id " +
                                        "INNER JOIN Songs on PlaylistSongs.songId=Songs.id ";
                                        
        try(Connection con = connector.getConnection();
                PreparedStatement statement = con.prepareStatement(sqlStatement))
        {
            ResultSet rs = statement.executeQuery();
            if(rs.next())
            {
                for(Playlist p : playlists)
                {
                    while(!rs.isAfterLast() && rs.getInt("playlistID") == p.getplaylistID())
                    {
                        int songID = rs.getInt("songID");
                        String name = rs.getString("name");
                        String artist = rs.getString("artist");
                        String genre = rs.getString("genre");
                        int time = rs.getInt("time");
                        String path = rs.getString("path");
                        p.addSong(new Song(songID, name, artist, genre, time, path));
                        rs.next();
                    }
                }
            }
        }    
     }
    }
}
    
    
    
    

