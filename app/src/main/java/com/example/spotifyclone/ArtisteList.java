package com.example.spotifyclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.spotify.protocol.types.PlayerState;
import com.spotify.protocol.types.Track;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Set;
import java.util.Vector;

public class ArtisteList extends AppCompatActivity {
    Vector<Hashtable<String,Object>>liste;
    ListView ListeArtist;
    Artiste artiste;
    PlayerMusic playerMusic;
    Vector<Artiste>choixArtiste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artiste_list);
        ListeArtist = findViewById(R.id.ArtList);
        //ajouter des elements dans le hashtable
        liste = new Vector<Hashtable<String,Object>>();
        playerMusic = PlayerMusic.getInstance(this);//pour initialiser mon singleton
        try {
            choixArtiste.add(playerMusic.getArtiste("1QAJqy2dA3ihHBFIHRphZj"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    void UpdateListe(Bundle savedInstanceState){
        for (int i = 0; i < choixArtiste.size(); i++) {
            Hashtable<String,Object>tmpA = new Hashtable<>();
            tmpA.put("Titre",choixArtiste.get(i).getTitre());
            tmpA.put("Nom",choixArtiste.get(i).getNom());
            tmpA.put("Album",choixArtiste.get(i).getAlbum());
            tmpA.put("Duration",choixArtiste.get(i).getDuration());
            tmpA.put("image",choixArtiste.get(i).getImage());

            liste.add(tmpA);

        }
        // Creer un tab de string avc l<ordre que je veux + tab de int avc R.id du nv layout cre
        String[] from = {"Bitmap","Titre","Album","Artiste"};
        int[] to = {R.id.img_album_lay,R.id.Titre_txt_lay,R.id.Album_txt_lay,R.id.Nom_txt_lay};
        //transformer la bitmap en drawable(setViewValue)
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,liste,R.layout.layout_chanson,from,to);

        simpleAdapter.setViewBinder(new SimpleAdapter.ViewBinder() {
            @Override
            public boolean setViewValue(View view, Object data, String textRepresentation) {
                if( (view instanceof ImageView) & (data instanceof Bitmap) ) {
                    ImageView iv = (ImageView) view;
                    Bitmap bm = (Bitmap) data;
                    iv.setImageBitmap(bm);
                    return true;
                }
                    return false;
            }


        });
        ListeArtist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent();
                Hashtable<String,Object> Artistes = (Hashtable<String, Object>) adapterView.getItemAtPosition(i);
                intent.putExtra("nom",(String)Artistes.get("Nom"));
                intent.putExtra("titre",(String)Artistes.get("Titre"));
                intent.putExtra("image",String.valueOf(Artistes.get("Image")));

                setResult(11, intent);
                finish();


            }
        });



        //ligne 96/97/98 a moi de l<adapter a spoty



    }
}