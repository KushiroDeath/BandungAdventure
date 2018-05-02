package com.example.masterluthfi.bandungadventure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TempatWisata extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tempat_wisata);
    }

    public void btnbook(View view) {
        Intent book = new Intent(this,Booking.class);
        startActivity(book);
    }
}
