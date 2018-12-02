package com.example.alden.blackjackproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button openGame, openSettings, openAbout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openGame = findViewById(R.id.start_game_button);
        openSettings = findViewById(R.id.settings_button);
        openAbout = findViewById(R.id.about_button);

        openGame.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openGame();
            }
        });//Close open game button
        openSettings.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openSettings();
            }
        });//Close open game button
        openAbout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openAbout();
            }
        });//Close open game button

    }

    public void openGame(){
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    } //Close openGame
    public void openSettings(){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    } //Close openSettings
    public void openAbout(){
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    } //Close openAbout
}