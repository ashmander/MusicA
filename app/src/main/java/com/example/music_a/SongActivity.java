package com.example.music_a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class SongActivity extends AppCompatActivity {

    private TextView titleTv, artistTv, albumTv, durationTv;
    private ImageView pictureImg, back;
    private Button escucharBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);
        Song song = (Song)getIntent().getSerializableExtra("song");
        titleTv = findViewById(R.id.song_title_tv);
        artistTv = findViewById(R.id.song_artist_tv);
        albumTv = findViewById(R.id.song_album_tv);
        durationTv = findViewById(R.id.song_duration_tv);
        pictureImg = findViewById(R.id.song_picture_img);
        escucharBtn = findViewById(R.id.song_escuchar_btn);
        back  = findViewById(R.id.song_back_img);

        titleTv.setText(song.getTitle());
        artistTv.setText(song.getArtist().getName());
        albumTv.setText(song.getAlbum().getName());
        durationTv.setText("Duración: "+song.getDuration()+" segundos");
        Picasso.get().load(song.getAlbum().getCoverSmall()).into(pictureImg);
        escucharBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombrePaquete = "deezer.android.app";
                Intent intentApp = getPackageManager().getLaunchIntentForPackage(nombrePaquete );
                if(intentApp == null) {
                    //No se puede abrir aplicacion.
                    Uri uri = Uri.parse(song.getLink());
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                } else {
                    startActivity(intentApp);
                }
            }
        });
        back.setOnClickListener(
                view -> {
                    super.onBackPressed();
                }
        );
    }
}
