package com.example.music_a;

import java.io.Serializable;
import java.util.ArrayList;

public class Playlist implements Serializable {
    private long id;
    private String title;
    private int nb_tracks;
    private String picture_small;
    private int fans;
    private DatasetTrack tracks;
    private String description;
    private User user;


    public Playlist() {
    }

    public Playlist(long id, String title, int nb_tracks, String picture_small, int fans, DatasetTrack tracks, String description, User user) {
        this.id = id;
        this.title = title;
        this.nb_tracks = nb_tracks;
        this.picture_small = picture_small;
        this.fans = fans;
        this.tracks = tracks;
        this.description = description;
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNb_tracks() {
        return nb_tracks;
    }

    public void setNb_tracks(int nb_tracks) {
        this.nb_tracks = nb_tracks;
    }

    public String getPicture() {
        return picture_small;
    }

    public void setPicture(String picture) {
        this.picture_small = picture;
    }

    public int getFans() {
        return fans;
    }

    public void setFans(int fans) {
        this.fans = fans;
    }

    public DatasetTrack getTracks() {
        return tracks;
    }

    public void setTracks(DatasetTrack tracks) {
        this.tracks = tracks;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {return user;}

    public void setUser()  {this.user = user;}
}
