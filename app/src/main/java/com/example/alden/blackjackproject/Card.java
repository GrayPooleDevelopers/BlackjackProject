package com.example.alden.blackjackproject;
import android.widget.ImageView;
import android.media.Image;
import 	java.io.InputStream;
import android.graphics.Bitmap;
import android.graphics.Bitmap;
import android.content.res.Resources;
import android.content.Context.*;
import android.support.v4.content.res.ResourcesCompat;
import android.graphics.drawable.Drawable;

public class Card
{
    private String cardName;
    private int value;
    private Drawable image;    // image of card
    private ImageView cardView;

    // construct a card with face, suit, and image
    public Card(Drawable image, int value, String cardName)
    {
        this.cardName = cardName;
        this.image = image;  // initialize image
        this.value = value;
    }

    // returns card's image
    public ImageView getImage(){
        return cardView;
    }

}
