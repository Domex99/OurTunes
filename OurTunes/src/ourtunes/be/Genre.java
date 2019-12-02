/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ourtunes.be;

/**
 *
 * @author dpank
 */
public class Genre {
    
    private int genre_ID;
    private String genre_name;
    
    public Genre(int genre_ID, String genre_name){
        
        this.genre_ID = genre_ID;
        this.genre_name = genre_name;
        
    }

    public int getGenre_ID() {
        return genre_ID;
    }

    public String getGenre_name() {
        return genre_name;
    }
    
    public String setGenre_name() {
        return genre_name;
    }
}