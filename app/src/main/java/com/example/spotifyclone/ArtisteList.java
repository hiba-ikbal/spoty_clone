package com.example.spotifyclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.spotify.protocol.types.PlayerState;
import com.spotify.protocol.types.Track;

import java.util.Hashtable;
import java.util.Vector;

public class ArtisteList extends AppCompatActivity {
    Vector<Hashtable<String,Artiste>>liste;
    ListView ListeArtist;
    Artiste artiste;
    PlayerState playerState;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artiste_list);
        ListeArtist = findViewById(R.id.ArtList);
        //ajouter des elements dans le hashtable
        liste = new Vector<Hashtable<String,Artiste>>();
    }
    void UpdateListe(Bundle savedInstanceState){
        Vector<Artiste>tmp = new Vector<>();

        for(int i=0;i<tmp.size();i++){
            Hashtable<String,Artiste>tmpA = new Hashtable<>();
            //tmpA.put("Bitmap");
        }


    }
}