package com.example.asus.coba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class menuUtama extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_menu_utama);
    }

    public void listbuku(View view) {
        Intent i = new Intent(menuUtama.this, ListBuku.class);
        i.putExtra("tabel", "ori");
        i.putExtra("value", "null");
        startActivity(i);
    }

    public void tambah(View view) {
        Intent i = new Intent(menuUtama.this, insertBuku.class);
        i.putExtra("tag","0");
        startActivity(i);
    }
}
