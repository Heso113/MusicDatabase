package com.experis.se.hampus.olsson.MusicDatabase.models;

public class Track {
    int trackId;
    String name;
    int albumId;
    int genreId;

    public Track() {

    }

    public Track(int trackId, String name, int albumId, int genreId) {
        this.trackId = trackId;
        this.name = name;
        this.albumId = albumId;
        this.genreId = genreId;
    }

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }
}
