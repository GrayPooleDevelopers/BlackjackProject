/*Created by Thomas Gray tgray39 and Alden Poole dpoole5
    Final Project
    IS 3920
    Blackjack Game
    December 3 2018
 */

package com.example.alden.blackjackproject;


import android.graphics.Bitmap;

public class Card {
    int value;
    Bitmap image;
    Boolean ace;

    public Card(Bitmap image, int value, Boolean ace){
        this.value = value;
        this.image = image;
        this.ace = ace;
    }

    public Bitmap getImage(){
        return image;
    }

    public int getValue(){
        return value;
    }

    public void setValue(int val){
        value = val;
    }

    public Boolean isAce(){
        return ace;
    }
}


