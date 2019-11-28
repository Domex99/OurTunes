/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ourtunes.dal;

import java.util.ArrayList;
import java.util.List;
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
import ourtunes.dal.DatabaseConnection;

/**
 *
 * @author XMdag
 */
public class PlaylistDAO {
    
private DatabaseConnection connector;


public PlaylistDAO()
{
connector = new DatabaseConnection();
}
//Gets All songs from the database
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
                allPlaylists.add(new Playlist(playlistID, playlistName, playlistLength));
            }
        }
        return allPlaylists;
    }
    }

