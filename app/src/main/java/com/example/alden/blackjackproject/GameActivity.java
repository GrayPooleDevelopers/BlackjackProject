package com.example.alden.blackjackproject;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;
import android.content.Context;
import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    private int bank;
    private int bet;
    TextView bankText, betText;
    Button bet100,bet500,bet50,menu;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);
        bank = 1000;
        bet = 0;


        bankText=(TextView)findViewById(R.id.bank_total);
        betText=(TextView)findViewById(R.id.bet_total);

        bankText.setText("Bank Total: $" + bank);
        betText.setText("Bet Total: $" + bet);

        bet100 = findViewById(R.id.button_hundred);
        bet50 = findViewById(R.id.button_fifty);
        bet500 = findViewById(R.id.button_five);
        menu = findViewById(R.id.menu_button);

        menu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openMenu();
            }
        });//Close open game button

        bet100.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                bet100();
            }
        });//Close open game button

        bet500.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                bet500();
            }
        });//Close open game button

        bet50.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                bet50();
            }
        });//Close open game button

    }

    public void resetGame(){

    }

    public void dealCard(){

    }

    public void bet100(){
        if(bank >= 100){
            bank-=100;
            bet+=100;
            setTexts();
        }else{
            Context context = getApplicationContext();
            CharSequence text = "Not enough funds!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    public void bet500(){
        if(bank >= 500){
            bank-=500;
            bet+=500;
            setTexts();
        }else{
            Context context = getApplicationContext();
            CharSequence text = "Not enough funds!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    public void bet50(){
        if(bank >= 50){
            bank-=50;
            bet+=50;
            setTexts();
        }else{
            Context context = getApplicationContext();
            CharSequence text = "Not enough funds!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    public void setTexts(){
        bankText.setText("Bank Total: $" + bank);
        betText.setText("Bet Total: $" + bet);
    }

    public void openMenu(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    } //Close openCraps
}