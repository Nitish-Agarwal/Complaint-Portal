package com.example.pawan.complaintportal;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.os.Handler;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;

public class MainActivity1 extends AppCompatActivity {


    private final int SPLASH_DISPLAY_LENGTH = 3000;

        /** Called when the activity is first created. */
        @Override
        public void onCreate(Bundle icicle) {
            super.onCreate(icicle);
            setContentView(R.layout.activity_main1);

        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    startActivity(new Intent(MainActivity1.this, MainActivity.class));
                    finish();
                }
            },  SPLASH_DISPLAY_LENGTH);
        }
    }
