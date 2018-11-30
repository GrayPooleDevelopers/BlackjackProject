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
