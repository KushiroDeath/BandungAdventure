package com.example.masterluthfi.bandungadventure;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Booking extends AppCompatActivity {
private EditText txtdur,txtorg,tglcheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        txtdur = (EditText) findViewById(R.id.txtdur);
        txtorg = (EditText) findViewById(R.id.txtorg);
        tglcheck = (EditText) findViewById(R.id.tglcheck);

    }

    public void btnok(View view) {
        AlertDialog.Builder bok = new  AlertDialog.Builder(Booking.this);
        bok.setMessage("Apakah pemesanan sudah benar?").setCancelable(false)
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String a = txtdur.getText().toString();
                        String b = txtorg.getText().toString();
                        String c = tglcheck.getText().toString();
                        if (a.isEmpty() || b.isEmpty() || c.isEmpty() ){
                            Toast.makeText(Booking.this, "Data belum lengkap", Toast.LENGTH_LONG).show();
                        }
                        else {
                        Toast.makeText(getBaseContext(),"Pemesanan telah dikirim", Toast.LENGTH_SHORT).show();
                        Intent ok = new Intent(Booking.this,TempatWisata.class);
                        startActivity(ok);

                    }}
                })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                    }
                });


    }

    public void btncancel(View view) {
        Intent cancel = new Intent(this,TempatWisata.class);
        startActivity(cancel);
    }

}
