package com.example.alden.blackjackproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SettingsActivity extends AppCompatActivity {
    Button usd, euros;
    boolean isEuros = false;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);

        usd = findViewById(R.id.dollars_button_settings);
        euros = findViewById(R.id.euros_button_settings);


        usd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                boolean euros = false;
                setUSD(euros);
            }
        });

        euros.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                boolean euros = true;
                setEuros(euros);


            }
        });
    }

    public void setUSD(boolean euro){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("euro", false);
        startActivity(intent);

    }

    public void setEuros(boolean euro){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("euro1", true);
        startActivity(intent);

    }

}
