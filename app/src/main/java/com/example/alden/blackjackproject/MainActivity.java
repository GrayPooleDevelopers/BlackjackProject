/*Created by Thomas Gray tgray39 and Alden Poole dpoole5
    Final Project
    IS 3920
    Blackjack Game
    December 3 2018
 */

package com.example.alden.blackjackproject;

import android.content.Intent;
import android.os.CountDownTimer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.media.MediaPlayer;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;




public class MainActivity extends AppCompatActivity {

    AdView myAdView;
    Button openGame, openAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this,"ca-app-pub-3940256099942544~3347511713");

        myAdView = (AdView)findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
        myAdView.loadAd(adRequest);

        final MediaPlayer shuffleSound = MediaPlayer.create(this,R.raw.shuffle);
        final MediaPlayer menuMusic = MediaPlayer.create(this,R.raw.menu_theme);
        menuMusic.start();


        openGame = findViewById(R.id.start_game_button);
        openAbout = findViewById(R.id.about_button);

        playSound(menuMusic);

        openGame.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openGame(menuMusic);
                shuffleSound.start();
            }
        });//Close open game button

        openAbout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openAbout();
                
            }
        });//Close open game button

    }//End create

    public void playSound(MediaPlayer media){
        media.setLooping(true);
        media.start();
    }

    public void openGame(MediaPlayer media){
        Intent intent = new Intent(this, GameActivity.class);
        media.stop();
        startActivity(intent);
    } //Close openGame
    public void openAbout(){
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    } //Close openAbout
}