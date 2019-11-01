package com.example.music_a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PlaylistAdapter extends BaseAdapter {

    private ArrayList<Playlist> playlists;

    public PlaylistAdapter () {
        playlists = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return playlists.size();
    }

    @Override
    public Object getItem(int i) {
        return playlists.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.row_playlist, null);
        TextView title = view.findViewById(R.id.row_playlist_title_tv);
        TextView creator = view.findViewById(R.id.row_playlist_creator_tv);
        TextView numSongs = view.findViewById(R.id.row_playlist_num_tracks_tv);
        ImageView picture = view.findViewById(R.id.row_playlist_picture_img);
        title.setText(playlists.get(position).getTitle());
        numSongs.setText(""+playlists.get(position).getNb_tracks());
        Picasso.get().load(playlists.get(position).getPicture()).into(picture);
        creator.setText(playlists.get(position).getUser().getName());
        return view;
    }

    public void setPlaylists(ArrayList<Playlist> p) {
        playlists = p;
        notifyDataSetChanged();
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }
}
