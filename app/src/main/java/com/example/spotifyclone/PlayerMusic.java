package com.example.spotifyclone;

import android.content.Context;
import android.util.Log;

import com.spotify.android.appremote.api.ConnectionParams;
import com.spotify.android.appremote.api.Connector;
import com.spotify.android.appremote.api.SpotifyAppRemote;
import com.spotify.protocol.types.Track;

public class PlayerMusic {
    private static PlayerMusic instance;

    private  String CLIENT_ID;
    private  String REDIRECT_URI;
    private SpotifyAppRemote mSpotifyAppRemote;
    boolean musicBound;

    public PlayerMusic(Context context){
        this.CLIENT_ID = "833df7f639984a518117e9edab32a480";
        this.REDIRECT_URI = "com.example.spotifyclone://callback";
        this.musicBound = false;
        onStart(context);
    }
    public static PlayerMusic getInstance(Context context)
    {
        if(instance == null)
            instance = new PlayerMusic(context);
        return instance;
    }
    protected void onStart(Context context) {

        ConnectionParams connectionParams =
                new ConnectionParams.Builder(CLIENT_ID)
                        .setRedirectUri(REDIRECT_URI)
                        .showAuthView(true)
                        .build();
        onStop();
        SpotifyAppRemote.connect(context, connectionParams,
                new Connector.ConnectionListener() {

                    public void onConnected(SpotifyAppRemote spotifyAppRemote) {
                        mSpotifyAppRemote = spotifyAppRemote;
                        Log.d("MainActivity", "Connected! Yay!");

                        // Now you can start interacting with App Remote
                        connected();

                    }

                    public void onFailure(Throwable throwable) {
                        Log.e("MyActivity", throwable.getMessage(), throwable);

                        // Something went wrong when attempting to connect! Handle errors here
                    }
                });
    }


    private void connected() {
        // Play a playlist
        mSpotifyAppRemote.getPlayerApi().play("spotify:playlist:37i9dQZF1DX2sUQwD7tbmL");

        // Subscribe to PlayerState
        mSpotifyAppRemote.getPlayerApi()
                .subscribeToPlayerState()
                .setEventCallback(playerState -> {
                    final Track track = playerState.track;
                    if (track != null) {
                        Log.d("MainActivity", track.name + " by " + track.artist.name);
                    }
                });
    }
    protected void onStop() {

        SpotifyAppRemote.disconnect(mSpotifyAppRemote);
    }
    public Artiste getArtiste(String id){
        // creer un artiste tempo
        Artiste artistetmp = new Artiste();
        //get l artiste sur spoti
        mSpotifyAppRemote.getPlayerApi().getPlayerState();
        //set les valeurs de artistes tmp par arpp a spotify
        //artistetmp.set...
        return artistetmp;
    }


    public void next() {
    }

    public boolean pause() {

        return false;
    }

    public void prev() {
    }

    public void play() {
    }
}

