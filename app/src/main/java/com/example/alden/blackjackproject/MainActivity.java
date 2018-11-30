package com.example.alden.blackjackproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button openGame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openGame = findViewById(R.id.start_game_button);

        openGame.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openCraps();
            }
        });//Close open game button

    }

    public void openCraps(){
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    } //Close openCraps
}
