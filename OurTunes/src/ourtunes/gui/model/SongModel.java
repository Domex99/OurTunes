/*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    package ourtunes.gui.model;

    import javafx.collections.FXCollections;
    import javafx.collections.ObservableList;
    import ourtunes.be.Song;
    import ourtunes.bll.BllManager;
    import ourtunes.bll.LogicFacade;

    /**
     *
     * @author dpank
     */
    public class SongModel {

        private ObservableList<Song> songList;

        private final LogicFacade bllManager;

    public SongModel(){    

        bllManager = new BllManager();

        songList = FXCollections.observableArrayList(bllManager.getAllSongs());

    }

        //Returns list with all songs.
        public ObservableList<Song> getSongs()
        {
            return songList;
        }

        //Deletes song from the list of songs.
        public void deleteSong(Song song)
        {
            bllManager.deleteSong(song);
            songList.remove(song);
        }

        //Create song.
        public void createSong(int songID, String name, String artist, String genre, int time, String path)
        {
            bllManager.createSong(songID, name, artist, genre, time, path);
        }

        //Edit songs.
        public void updateSong(Song song, String newName, String newArtist, String newGenre)
        {
            bllManager.updateSong(song, newName, newArtist, newGenre);

        }

    }