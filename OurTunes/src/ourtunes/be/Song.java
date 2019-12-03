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
    private String path;
    private int songID;
    private int time;
    public boolean toString;
    
    
    public Song(String name, String artist, String genre, int songID, int time, String path)
    {  
        this.name = name;
        this.songID = songID;
        this.artist = artist;
        this.genre = genre;
        this.time = time;
        this.path = path;
        }

    public String getPath() {
        return path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getSongID() {
        return songID;
    }

    public int getTime() {
        return time;
    }
    
        @Override
    public String toString() {
        return songID + ") " + name + ", " + artist + ", " + time;
    }

}