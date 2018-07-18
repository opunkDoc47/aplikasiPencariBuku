package com.example.asus.coba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class cari extends AppCompatActivity {
    String pilihan[] = {"PILIH", "Judul Buku", "penulis", "Penerbit", "Tahun Terbit"};
    Spinner pilih;
    EditText input1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari);
        pilih = (Spinner) findViewById(R.id.co);
        input1 = (EditText) findViewById(R.id.input1);
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, pilihan);
        pilih.setAdapter(adapter);
    }

    public void cari(View view) {
        if (input1.getText().toString().equalsIgnoreCase("") || pilih.getSelectedItemPosition() == 0) {
            Toast.makeText(this, "data kurang lengkap", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(cari.this, ListBuku.class);
            if (pilih.getSelectedItemPosition() == 1) {
                intent.putExtra("tabel", "judulBuku");
                intent.putExtra("value", input1.getText().toString());

            } else if (pilih.getSelectedItemPosition() == 2) {
                intent.putExtra("tabel", "penulisBuku");
                intent.putExtra("value", input1.getText().toString());

            } else if (pilih.getSelectedItemPosition() == 3) {
                intent.putExtra("tabel", "penerbitBuku");
                intent.putExtra("value", input1.getText().toString());

            } else if (pilih.getSelectedItemPosition() == 4) {
                intent.putExtra("tabel", "tahunTerbitBuku");
                intent.putExtra("value", input1.getText().toString());

            }
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(cari.this, ListBuku.class);
        i.putExtra("tabel", "ori");
        i.putExtra("value", "null");
        startActivity(i);
        finish();
    }

}

