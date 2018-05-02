package com.example.masterluthfi.bandungadventure;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class PengaturanWisata extends AppCompatActivity {
    private static int LOAD_IMAGE_RESULT = 1;
    private ImageButton button;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengaturan_wisata);
        button = (ImageButton) findViewById(R.id.btnimg);
        image = (ImageView) findViewById(R.id.imgphoto);

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == LOAD_IMAGE_RESULT && resultCode == RESULT_OK && data != null) {
            Uri pickedImage = data.getData();
            String[] filePath = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(pickedImage, filePath, null, null, null);
            cursor.moveToFirst();
            String imagePath = cursor.getString(cursor.getColumnIndex(filePath[0]));
            image.setImageBitmap(BitmapFactory.decodeFile(imagePath));
            cursor.close();

        }
    }

    public void onClick(View v) {
        // TODO Auto-generated method stub
        Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i, LOAD_IMAGE_RESULT);
    }

    public void btncancel(View view) {
        AlertDialog.Builder cncl = new AlertDialog.Builder(PengaturanWisata.this);
        cncl.setMessage("Apakah anda yakin ingin keluar?").setCancelable(false)
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent ok = new Intent(PengaturanWisata.this, TempatWisata.class);
                        startActivity(ok);
                    }
                })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
    }

    public void btnsave(View view) {
        AlertDialog.Builder sv = new AlertDialog.Builder(PengaturanWisata.this);
        sv.setMessage("Apakah anda yakin data benar?").setCancelable(false)
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getBaseContext(), "DATA TERSIMPAN", Toast.LENGTH_SHORT).show();
                        Intent ok = new Intent(PengaturanWisata.this, TempatWisata.class);
                        startActivity(ok);
                    }
                })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
    }
}
