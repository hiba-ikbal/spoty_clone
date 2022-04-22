package com.example.spotifyclone;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.spotify.android.appremote.api.ConnectionParams;
import com.spotify.android.appremote.api.Connector;
import com.spotify.android.appremote.api.SpotifyAppRemote;
import com.spotify.protocol.types.Track;

public class MainActivity extends AppCompatActivity {
    ImageButton next, prev,pause,play;
    ImageView cover;
    TextView Title,artist,duree;
    SeekBar sb;
    Ecouteur ec;
    Handler handler; //psq on aura besoin d<un thread
    Thread thread;
    PlayerMusic playerMusic;

    Intent intentPlay;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prev = findViewById(R.id.prevbtn);
        next = findViewById(R.id.nextbtn);
        pause = findViewById(R.id.stopbtn);
        play = findViewById(R.id.playbtn);
        cover=findViewById(R.id.imgAlbum);
        Title=findViewById(R.id.Titre);
        artist = findViewById(R.id.Artiste);
        duree = findViewById(R.id.Duree);
        sb=findViewById(R.id.seekbar);

        ec = new Ecouteur();
        pause.setOnClickListener(ec);
        next.setOnClickListener(ec);
        prev.setOnClickListener(ec);
        play.setOnClickListener(ec);

        handler = new Handler();
        thread = new Thread();


    }

    @Override
    protected void onStart(){
        super.onStart();
        playerMusic = new PlayerMusic(getApplicationContext());
    }

    @Override
    protected void onStop(){
        super.onStop();
        playerMusic.onStop();
    }
    private void connected() {

    }


    private class Ecouteur implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.nextbtn:
                    playerMusic.next();
                    changeSong();
                    break;
                case R.id.prevbtn:
                    playerMusic.prev();
                    changeSong();
                    break;
                case R.id.stopbtn:
                    playerMusic.pause();
                    break;
                case R.id.playbtn:
                    playerMusic.play();
                    break;


            }

        }
    }

    private void changeSong() {
        //changer les infos de la chanson
    }
}