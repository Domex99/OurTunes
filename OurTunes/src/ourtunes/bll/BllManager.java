/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ourtunes.bll;

import java.sql.SQLException;
import java.util.List;
import ourtunes.be.Playlist;
import ourtunes.be.Song;
import ourtunes.dal.PlaylistDAO;
import ourtunes.dal.SongDAO;

/**
 *
 * @author XMdag
 */
public class BllManager {
    
    private SongDAO songdao;
    private PlaylistDAO playlistdao;
    
    public BllManager(){
         songdao = new SongDAO();


}
    
    public List<Song> getAllSongs(){
        
        return songdao.getAllSongs();
    
    }
    
    public void addSong(Song song) throws SQLException
    {
        songdao.createSong(song);
    }
    
    public List<Playlist> getAllPlaylists() throws SQLException{
        
       return playlistdao.getAllPlaylist();
    }
}
