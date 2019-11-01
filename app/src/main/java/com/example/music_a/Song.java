package com.example.music_a;

import java.io.Serializable;
import java.util.Date;

public class Song implements Serializable {
    private long id;
    private String title;
    private int duration;
    private Artist artist;
    private String picture;
    private Album album;
    private String link;
    private long time_add;

    public Song() {
    }

    public Song(long id, String title, int duration, Artist artist, long time_add, String picture, Album album, String link) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.artist = artist;
        this.time_add = time_add;
        this.picture = picture;
        this.album = album;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public long getDate() {
        return time_add;
    }

    public void setDate(long date) {
        this.time_add = date;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
