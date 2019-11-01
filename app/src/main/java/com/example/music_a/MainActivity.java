package com.example.music_a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.music_a.util.HTTPSWebUtilDomi;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView playlistsLv;
    private ImageButton searchBtn;
    private EditText searchEt;
    private PlaylistAdapter playlistAdapter;
    private Dataset dataset;
    private Playlist playlistSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playlistAdapter = new PlaylistAdapter();
        playlistsLv = findViewById(R.id.mainactivity_playlist_lv);
        playlistsLv.setAdapter(playlistAdapter);
        searchBtn = findViewById(R.id.mainactivity_search_btn);
        searchEt = findViewById(R.id.mainactivity_search_et);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = searchEt.getText().toString();
                String url = "https://api.deezer.com/search/playlist?q="+name;
                new Thread(
                        () -> {
                            try {
                                HTTPSWebUtilDomi util = new HTTPSWebUtilDomi();
                                String res = util.GETrequest(url);
                                Gson json = new Gson();
                                runOnUiThread(()->{
                                    dataset = json.fromJson(res, Dataset.class);
                                    playlistAdapter.setPlaylists(dataset.getData());
                                });
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                ).start();

            }
        });
        playlistsLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), PlaylistActivity.class);
                Playlist p = (Playlist)playlistAdapter.getItem(i);
                String url = "https://api.deezer.com/playlist/"+p.getId();
                Thread t = new Thread(
                        () -> {
                            try {
                                HTTPSWebUtilDomi util = new HTTPSWebUtilDomi();
                                String res = util.GETrequest(url);
                                Gson json = new Gson();
                                runOnUiThread(()->{
                                    playlistSelected = json.fromJson(res, Playlist.class);
                                    intent.putExtra("playlist",playlistSelected);
                                    startActivity(intent);
                                });
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                );
                t.start();
                try {
                    t.join();
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });
    }
}
