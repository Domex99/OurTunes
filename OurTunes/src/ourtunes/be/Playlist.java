/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ourtunes.be;

/**
 *
 * @author XMdag
 */
public class Playlist {
    
    private int playlistID;
    
    private String playlistName;
    
    private int playlistLength;
    


public Playlist(int playlistID, String playlistName, int playlistLength) {
        
        this.playlistID = playlistID;
        this.playlistName = playlistName;
        this.playlistLength = playlistLength;
    
    }

public int getplaylistID() {
        return playlistID;
    }

public String getplaylistName() {
        return playlistName;
    }

public void setplaylistName(String name) {
        this.playlistName = playlistName;
    }

public int getplatlistLength() {
        return playlistLength;
    }

}



