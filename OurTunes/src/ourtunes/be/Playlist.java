/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ourtunes.be;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author XMdag
 */
public class Playlist {
    
    private int playlistID;
    private String playlistName;
    private int playlistLength;
    private int songsNumber;
    private List<Song> songlist;


public Playlist(int playlistID, String playlistName ) 
    {
        this.playlistID = playlistID;
        this.playlistName = playlistName;
        playlistLength = 0;
        songsNumber = 0;
        songlist = new ArrayList();
        }


public void addSong(Song song)
{
    songlist.add(song);
    playlistLength = playlistLength +song.getTime();
    songsNumber ++;
    }


public void removeSong(Song song)
{
    songlist.remove(song);
    playlistLength -=song.getTime();
    songsNumber --;
}


public void setplaylistName(String name) 
{
        this.playlistName = playlistName;
    }


public String getplaylistName() 
{
        return playlistName;
    }


public int getplaylistID() 
{
        return playlistID;
    }


public int getplatlistLength() {
        return playlistLength;
    }


public List<Song> getSonglist() 
    {
        return songlist;
    }


public void setTracklist(List<Song> songs) 
    {
        songlist.clear();
        songlist.addAll(songs);
    }
}