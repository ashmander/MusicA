package com.example.music_a;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SongAdapter extends BaseAdapter {

    ArrayList<Song> songs;

    public SongAdapter () {
        songs = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return songs.size();
    }

    @Override
    public Object getItem(int i) {
        return songs.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View viewConvert, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.row_song, null);
        TextView title = view.findViewById(R.id.row_song_title_tv);
        TextView artist = view.findViewById(R.id.row_song_artist_tv);
        TextView releaseDate = view.findViewById(R.id.row_song_release_date_tv);
        ImageView picture = view.findViewById(R.id.row_song_picture_img);

        title.setText(songs.get(position).getTitle());
        artist.setText(songs.get(position).getArtist().getName());
        Picasso.get().load(songs.get(position).getAlbum().getCoverSmall()).into(picture);
        long milli = songs.get(position).getDate()*1000;
        Date timeAdd = new Date(milli);
        SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");
        releaseDate.setText(dtf.format(timeAdd));
        return view;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs =  songs;
        notifyDataSetChanged();
    }
}