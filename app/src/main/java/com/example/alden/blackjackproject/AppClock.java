/*Created by Thomas Gray tgray39 and Alden Poole dpoole5
    Final Project
    IS 3920
    Blackjack Game
    December 3 2018
 */

package com.example.alden.blackjackproject;

import android.app.Application;
import android.os.SystemClock;

public class AppClock extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SystemClock.sleep(3000);
    }
}
