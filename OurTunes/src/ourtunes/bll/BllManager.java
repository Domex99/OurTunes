/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ourtunes.bll;

import java.sql.SQLException;
import java.util.List;
import ourtunes.be.Song;
import ourtunes.dal.SongDAO;

/**
 *
 * @author XMdag
 */
public class BllManager {
    
    private SongDAO songdao;
    
    public BllManager(){
        SongDAO SongDAO = new SongDAO();


}
    
    public List<Song> getAllSongs() throws SQLException{
        return songdao.getAllSongs();
    
    }
}
