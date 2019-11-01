package com.example.music_a;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.music_a.util.HTTPSWebUtilDomi;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.atomic.AtomicReference;

public class PlaylistActivity extends AppCompatActivity {

    private TextView titleTv, descriptionTv, numSongsTv, numFansTv;
    private ImageView pictureImg;
    private ListView songs;
    private SongAdapter songAdapter;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);
        Playlist playlist = (Playlist)getIntent().getSerializableExtra("playlist");
        titleTv = findViewById(R.id.playlist_title_tv);
        descriptionTv = findViewById(R.id.playlist_description_tv);
        numFansTv = findViewById(R.id.playlist_num_fans_tv);
        numSongsTv = findViewById(R.id.playlist_num_tracks_tv);
        pictureImg = findViewById(R.id.playlist_picture_img);
        songs = findViewById(R.id.playlist_tracks_lv);
        songAdapter = new SongAdapter();
        back = findViewById(R.id.playlist_back_img);


        titleTv.setText(playlist.getTitle());
        descriptionTv.setText(playlist.getDescription());
        numFansTv.setText(""+playlist.getFans()+" fans");
        numSongsTv.setText(""+playlist.getNb_tracks()+" cansiones");
        Picasso.get().load(playlist.getPicture()).into(pictureImg);
        songAdapter.setSongs(playlist.getTracks().getData());
        songs.setAdapter(songAdapter);
        songs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), SongActivity.class);
                Song s = (Song)songAdapter.getItem(i);
                intent.putExtra("song",s);
                startActivity(intent);
            }
        });
        back.setOnClickListener(
                view -> {
                    super.onBackPressed();
                }
        );
    }
}
