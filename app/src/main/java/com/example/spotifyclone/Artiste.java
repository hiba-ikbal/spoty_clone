package com.example.spotifyclone;

import android.graphics.Bitmap;

import java.time.Duration;

public class Artiste {
    String nom,Titre,Album;
    int duration;
    Bitmap image;

    public Artiste(String nom,String Titre,String Album,int duration,Bitmap map){
        this.nom=nom;
        this.Titre=Titre;
        this.Album=Album;
        this.duration=duration;
        image = map;
    }

    public Bitmap getImage() {return image;}
    public String getNom(){return nom; }
    public String getTitre(){return Titre;}
    public String getAlbum(){return Album;}
    public int getDuration(){return duration;}

}
