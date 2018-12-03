package com.example.alden.blackjackproject;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Collections;
import java.util.Random;
import android.widget.Toast;
import android.content.Context;
import java.util.ArrayList;
import java.util.Arrays;

public class GameActivity extends AppCompatActivity {
    public boolean isEuro = false;
    Bitmap back; // back card
    Bitmap twoclubs;
    Bitmap threeclubs;
    Bitmap fourclubs;
    Bitmap fiveclubs;
    Bitmap sixclubs;
    Bitmap sevenclubs;
    Bitmap eightclubs;
    Bitmap nineclubs;
    Bitmap tenclubs;
    Bitmap jackclubs;
    Bitmap queenclubs;
    Bitmap kingclubs;
    Bitmap aceclubs;
    Bitmap twohearts;
    Bitmap threehearts;
    Bitmap fourhearts;
    Bitmap fivehearts;
    Bitmap sixhearts;
    Bitmap sevenhearts;
    Bitmap eighthearts;
    Bitmap ninehearts;
    Bitmap tenhearts;
    Bitmap jackhearts;
    Bitmap queenhearts;
    Bitmap kinghearts;
    Bitmap acehearts;
    Bitmap twospades;
    Bitmap threespades;
    Bitmap fourspades;
    Bitmap fivespades;
    Bitmap sixspades;
    Bitmap sevenspades;
    Bitmap eightspades;
    Bitmap ninespades;
    Bitmap tenspades;
    Bitmap jackspades;
    Bitmap queenspades;
    Bitmap kingspades;
    Bitmap acespades;
    Bitmap twodiamonds;
    Bitmap threediamonds;
    Bitmap fourdiamonds;
    Bitmap fivediamonds;
    Bitmap sixdiamonds;
    Bitmap sevendiamonds;
    Bitmap eightdiamonds;
    Bitmap ninediamonds;
    Bitmap tendiamonds;
    Bitmap jackdiamonds;
    Bitmap queendiamonds;
    Bitmap kingdiamonds;
    Bitmap acediamonds;
    Random rand;
    int deckSize = 52;
    int hitCount = 0;
    private int bank;
    private int bet;
    TextView bankText, betText;
    Button bet100,bet500,bet50,menu,buttonhit,buttonstand,mainMenu,continueButton;
    ImageView card1, card2, card3, card4;
    ArrayList<Card> deck;
    ImageView[] cardViews, endCardViews;
    int playerTot = 0;
    Dialog dialog;
    ImageView endCard1, endCard2, endCard3, endCard4;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);
        bank = 1000;
        bet = 0;
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.end_screen);
        dialog.setTitle("End Game");
        dialog.setCancelable(true);
        mainMenu = (Button) dialog.findViewById(R.id.mainMenu_button);
        continueButton = (Button) dialog.findViewById(R.id.continue_button);
        mainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMenu();
            }
        });
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
                resetGame();
            }
        });
        cardViews =  new ImageView[4];
        endCardViews =  new ImageView[4];
        endCardViews[0] = (ImageView) dialog.findViewById(R.id.endCard1);
        endCardViews[1] = (ImageView) dialog.findViewById(R.id.endCard2);
        endCardViews[2] = (ImageView) dialog.findViewById(R.id.endCard3);
        endCardViews[3] = (ImageView) dialog.findViewById(R.id.endCard4);

        Intent intent = getIntent();
        isEuro = getIntent().getExtras().getBoolean("euro2");

        back = BitmapFactory.decodeResource(getResources(), R.drawable.back);

        twoclubs = BitmapFactory.decodeResource(getResources(), R.drawable.two_of_clubs);
        threeclubs = BitmapFactory.decodeResource(getResources(), R.drawable.three_of_clubs);
        fourclubs = BitmapFactory.decodeResource(getResources(), R.drawable.four_of_clubs);
        fiveclubs = BitmapFactory.decodeResource(getResources(), R.drawable.five_of_clubs);
        sixclubs = BitmapFactory.decodeResource(getResources(), R.drawable.six_of_clubs);
        sevenclubs = BitmapFactory.decodeResource(getResources(), R.drawable.seven_of_clubs);
        eightclubs = BitmapFactory.decodeResource(getResources(), R.drawable.eight_of_clubs);
        nineclubs = BitmapFactory.decodeResource(getResources(), R.drawable.nine_of_clubs);
        tenclubs = BitmapFactory.decodeResource(getResources(), R.drawable.ten_of_clubs);
        jackclubs = BitmapFactory.decodeResource(getResources(), R.drawable.jack_of_clubs);
        queenclubs = BitmapFactory.decodeResource(getResources(), R.drawable.queen_of_clubs);
        kingclubs = BitmapFactory.decodeResource(getResources(), R.drawable.king_of_clubs);
        aceclubs = BitmapFactory.decodeResource(getResources(), R.drawable.ace_of_clubs);

        twohearts = BitmapFactory.decodeResource(getResources(), R.drawable.two_of_hearts);
        threehearts = BitmapFactory.decodeResource(getResources(), R.drawable.three_of_hearts);
        fourhearts = BitmapFactory.decodeResource(getResources(), R.drawable.four_of_hearts);
        fivehearts = BitmapFactory.decodeResource(getResources(), R.drawable.five_of_hearts);
        sixhearts = BitmapFactory.decodeResource(getResources(), R.drawable.six_of_hearts);
        sevenhearts = BitmapFactory.decodeResource(getResources(), R.drawable.seven_of_hearts);
        eighthearts = BitmapFactory.decodeResource(getResources(), R.drawable.eight_of_hearts);
        ninehearts = BitmapFactory.decodeResource(getResources(), R.drawable.nine_of_hearts);
        tenhearts = BitmapFactory.decodeResource(getResources(), R.drawable.ten_of_hearts);
        jackhearts = BitmapFactory.decodeResource(getResources(), R.drawable.jack_of_hearts);
        queenhearts = BitmapFactory.decodeResource(getResources(), R.drawable.queen_of_hearts);
        kinghearts = BitmapFactory.decodeResource(getResources(), R.drawable.king_of_hearts);
        acehearts = BitmapFactory.decodeResource(getResources(), R.drawable.ace_of_hearts);

        twospades = BitmapFactory.decodeResource(getResources(), R.drawable.two_of_spades);
        threespades = BitmapFactory.decodeResource(getResources(), R.drawable.three_of_spades);
        fourspades = BitmapFactory.decodeResource(getResources(), R.drawable.four_of_spades);
        fivespades = BitmapFactory.decodeResource(getResources(), R.drawable.five_of_spades);
        sixspades = BitmapFactory.decodeResource(getResources(), R.drawable.six_of_spades);
        sevenspades = BitmapFactory.decodeResource(getResources(), R.drawable.seven_of_spades);
        eightspades = BitmapFactory.decodeResource(getResources(), R.drawable.eight_of_spades);
        ninespades = BitmapFactory.decodeResource(getResources(), R.drawable.nine_of_spades);
        tenspades = BitmapFactory.decodeResource(getResources(), R.drawable.ten_of_spades);
        jackspades = BitmapFactory.decodeResource(getResources(), R.drawable.jack_of_spades);
        queenspades = BitmapFactory.decodeResource(getResources(), R.drawable.queen_of_spades);
        kingspades = BitmapFactory.decodeResource(getResources(), R.drawable.king_of_spades);
        acespades = BitmapFactory.decodeResource(getResources(), R.drawable.ace_of_spades);

        twodiamonds = BitmapFactory.decodeResource(getResources(), R.drawable.two_of_diamonds);
        threediamonds = BitmapFactory.decodeResource(getResources(), R.drawable.three_of_diamonds);
        fourdiamonds = BitmapFactory.decodeResource(getResources(), R.drawable.four_of_diamonds);
        fivediamonds = BitmapFactory.decodeResource(getResources(), R.drawable.five_of_diamonds);
        sixdiamonds = BitmapFactory.decodeResource(getResources(), R.drawable.six_of_diamonds);
        sevendiamonds = BitmapFactory.decodeResource(getResources(), R.drawable.seven_of_diamonds);
        eightdiamonds = BitmapFactory.decodeResource(getResources(), R.drawable.eight_of_diamonds);
        ninediamonds = BitmapFactory.decodeResource(getResources(), R.drawable.nine_of_diamonds);
        tendiamonds = BitmapFactory.decodeResource(getResources(), R.drawable.ten_of_diamonds);
        jackdiamonds = BitmapFactory.decodeResource(getResources(), R.drawable.jack_of_diamonds);
        queendiamonds = BitmapFactory.decodeResource(getResources(), R.drawable.queen_of_diamonds);
        kingdiamonds = BitmapFactory.decodeResource(getResources(), R.drawable.king_of_diamonds);
        acediamonds = BitmapFactory.decodeResource(getResources(), R.drawable.ace_of_diamonds);

        deck = new ArrayList<Card>();

        fillDeck();

        Collections.shuffle(deck);

        cardViews[0] = (ImageView)findViewById(R.id.cardView1);
        cardViews[1] = (ImageView)findViewById(R.id.cardView2);
        cardViews[2] = (ImageView)findViewById(R.id.cardView3);
        cardViews[3] = (ImageView)findViewById(R.id.cardView4);


        cardViews[0].setImageBitmap(deck.get(0).getImage());
        endCardViews[0].setImageBitmap(deck.get(0).getImage());
        playerTot+=deck.get(0).getValue();
        hitCount++;
        deck.remove(0);
        cardViews[1].setImageBitmap(deck.get(0).getImage());
        endCardViews[1].setImageBitmap(deck.get(0).getImage());
        playerTot+=deck.get(0).getValue();
        hitCount++;
        deck.remove(0);

        bankText=(TextView)findViewById(R.id.bank_total);
        betText=(TextView)findViewById(R.id.bet_total);

        bankText.setText("Bank Total: $" + bank);
        betText.setText("Bet Total: $" + bet);

        bet100 = findViewById(R.id.button_hundred);
        bet50 = findViewById(R.id.button_fifty);
        bet500 = findViewById(R.id.button_five);
        menu = findViewById(R.id.menu_button);
        buttonhit = findViewById(R.id.button_hit);
        buttonstand = findViewById(R.id.button_stand);


        buttonhit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(hitCount < 3){
                    hitOne();
                }
                else{
                    hitTwo();
                }
            }
        });//Close open game button

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
       deck.removeAll(deck);
       fillDeck();
       hitCount = 2;
       playerTot = 0;
        cardViews[2].setImageBitmap(back);
        cardViews[3].setImageBitmap(back);
        cardViews[0].setImageBitmap(deck.get(0).getImage());
        endCardViews[0].setImageBitmap(deck.get(0).getImage());
        playerTot+=deck.get(0).getValue();
        deck.remove(0);
        cardViews[1].setImageBitmap(deck.get(0).getImage());
        endCardViews[1].setImageBitmap(deck.get(0).getImage());
        playerTot+=deck.get(0).getValue();
        deck.remove(0);

    }

    public void fillDeck(){
        deck.add(new Card(twodiamonds,2, false));
        deck.add(new Card(threediamonds,3,false));
        deck.add(new Card(fourdiamonds,4,false));
        deck.add(new Card(fivediamonds,5,false));
        deck.add(new Card(sixdiamonds,6,false));
        deck.add(new Card(sevendiamonds,7,false));
        deck.add(new Card(eightdiamonds,8,false));
        deck.add(new Card(ninediamonds,9,false));
        deck.add(new Card(tendiamonds,10,false));
        deck.add(new Card(jackdiamonds,10,false));
        deck.add(new Card(queendiamonds,10,false));
        deck.add(new Card(kingdiamonds,10,false));
        deck.add(new Card(acediamonds,1,true));
        deck.add(new Card(twoclubs,2,false));
        deck.add(new Card(threeclubs,3,false));
        deck.add(new Card(fourclubs,4,false));
        deck.add(new Card(fiveclubs,5,false));
        deck.add(new Card(sixclubs,6,false));
        deck.add(new Card(sevenclubs,7,false));
        deck.add(new Card(eightclubs,8,false));
        deck.add(new Card(nineclubs,9,false));
        deck.add(new Card(tenclubs,10,false));
        deck.add(new Card(jackclubs,10,false));
        deck.add(new Card(queenclubs,10,false));
        deck.add(new Card(kingclubs,10,false));
        deck.add(new Card(aceclubs,1,true));
        deck.add(new Card(twospades,2,false));
        deck.add(new Card(threespades,3,false));
        deck.add(new Card(fourspades,4,false));
        deck.add(new Card(fivespades,5,false));
        deck.add(new Card(sixspades,6,false));
        deck.add(new Card(sevenspades,7,false));
        deck.add(new Card(eightspades,8,false));
        deck.add(new Card(ninespades,9,false));
        deck.add(new Card(tenspades,10,false));
        deck.add(new Card(jackspades,10,false));
        deck.add(new Card(queenspades,10,false));
        deck.add(new Card(kingspades,10,false));
        deck.add(new Card(acespades,1,true));
        deck.add(new Card(twohearts,2,false));
        deck.add(new Card(threehearts,3,false));
        deck.add(new Card(fourhearts,4,false));
        deck.add(new Card(fivehearts,5,false));
        deck.add(new Card(sixhearts,6,false));
        deck.add(new Card(sevenhearts,7,false));
        deck.add(new Card(eighthearts,8,false));
        deck.add(new Card(ninehearts,9,false));
        deck.add(new Card(tenhearts,10,false));
        deck.add(new Card(jackhearts,10,false));
        deck.add(new Card(queenhearts,10,false));
        deck.add(new Card(kinghearts,10,false));
        deck.add(new Card(acehearts,1,true));
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

        if (isEuro == true){
            bankText.setText("Bank Total: €" + bank);
            betText.setText("Bet Total: €" + bank);
        }

        else{
            bankText.setText("Bank Total: $" + bank);
            betText.setText("Bet Total: $" + bet);
        }

    }

    public void openMenu(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    } //Close openCraps

    public void hitOne(){
        cardViews[hitCount].setImageBitmap(deck.get(0).getImage());
        endCardViews[hitCount].setImageBitmap(deck.get(0).getImage());
        playerTot+=deck.get(0).getValue();

        if(playerTot > 21){
            TextView text = (TextView) dialog.findViewById(R.id.end_text);
            text.setText("You lose!");
            if(bank == 0){
                mainMenu.setAlpha(.5f);
                mainMenu.setClickable(false);
                text.setText("You lost all your money!");
            }
            dialog.show();

        }else if(playerTot == 21){
            TextView text = (TextView) dialog.findViewById(R.id.end_text);
            text.setText("You win!");
            bank+=(bet*2);
            dialog.show();
        }
            deck.remove(0);
            hitCount++;
    }

    public void hitTwo(){
        cardViews[hitCount].setImageBitmap(deck.get(0).getImage());
        endCardViews[hitCount].setImageBitmap(deck.get(0).getImage());
        playerTot+=deck.get(0).getValue();
        if(playerTot > 21){
            TextView text = (TextView) dialog.findViewById(R.id.end_text);
            text.setText("You lose!");
            if(bank == 0){
                continueButton.setAlpha(.5f);
                continueButton.setClickable(false);
                text.setText("You lost all your money!");
            }
            dialog.show();
        }else if(playerTot == 21 || playerTot < 21){
            TextView text = (TextView) dialog.findViewById(R.id.end_text);
            text.setText("You win!");
            bank+=(bet*2);
            dialog.show();
        }else if(playerTot > 21){
            TextView text = (TextView) dialog.findViewById(R.id.end_text);
            text.setText("You win!");
            bank+=(bet*2);
            dialog.show();
        }
        deck.remove(0);
        hitCount++;
        deck.remove(0);
    }

    public void setEuro(boolean bool){
        isEuro = bool;
    }

}