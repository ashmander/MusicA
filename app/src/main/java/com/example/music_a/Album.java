package com.example.music_a;

import java.io.Serializable;

public class Album implements Serializable {
    private String title;
    private String cover_small;
    public Album(){}
    public Album(String title, String cover_small){this.title=title;this.cover_small=cover_small;}
    public void setName(String title){this.title=title;}
    public String getName(){return title;}
    public void setCoverSmall(String cover_small){this.cover_small=cover_small;}
    public String getCoverSmall(){return cover_small;}
}
