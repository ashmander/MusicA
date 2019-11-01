package com.example.music_a;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Dataset {
    private ArrayList<Playlist> data;
    public Dataset () {data=new ArrayList<>(); }
    public Dataset(ArrayList<Playlist> d){data=d;}
    public ArrayList<Playlist> getData(){return data;}
    public void setData(ArrayList<Playlist> d){data=d;}
}
