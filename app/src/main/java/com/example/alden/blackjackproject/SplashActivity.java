/* Created by Thomas Gray(tgray39) and Alden Poole (dpoole5)
    Final Project
    IS 3920
    BlackJack Game
    December 3, 2018
*/

package com.example.alden.blackjackproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

    }
}
