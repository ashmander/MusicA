package com.example.music_a;

import java.io.Serializable;
import java.util.ArrayList;

public class DatasetTrack implements Serializable {
    private ArrayList<Song> data;
    public DatasetTrack () {data=new ArrayList<>(); }
    public DatasetTrack(ArrayList<Song> d){data=d;}
    public ArrayList<Song> getData(){return data;}
    public void setData(ArrayList<Song> d){data=d;}
}
