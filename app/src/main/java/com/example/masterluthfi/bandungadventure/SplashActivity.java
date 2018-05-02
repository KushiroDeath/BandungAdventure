package com.example.masterluthfi.bandungadventure;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class SplashActivity extends AppCompatActivity {

    //mensetting lama nya splash akan muncul
    private static int splashInterval = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //mensetiingan agar splashscreen dapat muncul dengan fullscreen
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        //Menampilkan Toast Selamat Datang
        Toast.makeText(SplashActivity.this,"Selamat Datang, Silahkan Dilihat-Lihat",Toast.LENGTH_LONG).show();


        new Handler().postDelayed(new Runnable() {

                                      @Override
                                      public void run() {
                                          // TODO Auto-generated method stub

                                          //Intent ke MainActivity
                                          Intent i = new Intent(SplashActivity.this, MainActivity.class);
                                          startActivity(i); // menghubungkan activity splashscren ke main activity dengan intent


                                          //Jeda Setelah SplashScreen
                                          this.finish();
                                      }

                                      private void finish() {
                                          // TODO Auto-generated method stub

                                      }
                                  }, //Timer Splash
                splashInterval);

    };
}
