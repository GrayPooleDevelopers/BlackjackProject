package com.example.alden.blackjackproject;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import java.util.ArrayList;
import android.graphics.Bitmap;
import android.content.res.Resources;
import android.content.Context;
import android.support.v4.content.res.ResourcesCompat;

public class CardDeck {

    private Context context;
    private ArrayList<Card> deck; // array of Cards
    private int currentCard; // index of next card to be dealt
    private int cards = 52; // number of cards
    String fileLocation = new String();
    Drawable drawableCard;



    public CardDeck(Context context){
        this.context = context;
    }

    protected void onCreate(Bundle savedInstanceState) {
        Resources res = context.getResources();
        drawableCard = ResourcesCompat.getDrawable(res, R.drawable.H3, null);
        addCard();

    }

    public void addCard(){
        deck.add(drawableCard, 3, "threeHearts");
    }

}


