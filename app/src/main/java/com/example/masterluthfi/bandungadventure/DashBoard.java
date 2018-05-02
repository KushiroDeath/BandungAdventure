package com.example.masterluthfi.bandungadventure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DashBoard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gender(View view) {
        startActivity(new Intent(this, gender.class));
    }

    public void location(View view) {
        startActivity(new Intent(this, location.class));
    }
}
