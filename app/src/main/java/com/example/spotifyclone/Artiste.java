package com.example.spotifyclone;

import android.graphics.Bitmap;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import com.spotify.android.appremote.api.ConnectionParams;
import com.spotify.android.appremote.api.Connector;
import com.spotify.android.appremote.api.SpotifyAppRemote;
import com.spotify.protocol.types.Track;

import java.time.Duration;

public class Artiste {
    String nom,Titre,Album;
    int duration;
    Bitmap image;


    public Artiste(){}

    public void setNom(String nom) {this.nom = nom;}

    public void setAlbum(String album) {Album = album;}

    public void setDuration(int duration) {this.duration = duration; }

    public void setImage(Bitmap image) {this.image = image;}

    public void setTitre(String titre) {Titre = titre;}

    public Bitmap getImage() {return image;}
    public String getNom(){return nom; }
    public String getTitre(){return Titre;}
    public String getAlbum(){return Album;}
    public int getDuration(){return duration;}

    public boolean getPlaylist() {
        return true;
    }
}
