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
public class Song {
    
    private String name;
    
    private String artist;
    
    private String genre;

    private int songID;
    
    //find another way to track time
    private int time;
    
    
    private Song(String name, String artist, String genre, int songID, int time){
        
            
        this.songID = songID;
        this.artist = artist;
        this.genre = genre;
        this.songID = songID;
        this.time = time;
        
    
    
    }
}
