package com.example.asus.coba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.coba.config.buku;
import com.example.asus.coba.config.bukuDAO;
import com.example.asus.coba.config.bukuIMP;

import java.util.Random;

public class insertBuku extends AppCompatActivity {
    EditText judulBuku, penulisBuku, penerbitBuku, tahunTerbitBuku, lokasiBuku, deskripsiBuku;
    bukuDAO dao = new bukuIMP(this);
    private int tag = 0;
    private int ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_buku);
        judulBuku = (EditText) findViewById(R.id.judulBuku);
        penulisBuku = (EditText) findViewById(R.id.penulis);
        penerbitBuku = (EditText) findViewById(R.id.penerbit);
        tahunTerbitBuku = (EditText) findViewById(R.id.tahunTerbit2);
        lokasiBuku = (EditText) findViewById(R.id.lokasiBuku);
        deskripsiBuku = (EditText) findViewById(R.id.deskripsi2);
        Intent i = getIntent();
        if (i.getStringExtra("tag").equalsIgnoreCase("1")) {
            tag = 1;
            ID = Integer.valueOf(i.getStringExtra("idBuku"));
            judulBuku.setText(i.getStringExtra("judulBuku"));
            penulisBuku.setText(i.getStringExtra("penulisBuku"));
            penerbitBuku.setText(i.getStringExtra("penerbitBuku"));
            tahunTerbitBuku.setText(i.getStringExtra("tahunTerbitBuku"));
            lokasiBuku.setText(i.getStringExtra("lokasiBuku"));
            deskripsiBuku.setText(i.getStringExtra("deskripsiBuku"));
        }
    }

    public void tambahbuku(View view) {
        if (judulBuku.getText().toString().equalsIgnoreCase("") || penulisBuku.getText().toString().equalsIgnoreCase("") || penerbitBuku.getText().toString().equalsIgnoreCase("") || tahunTerbitBuku.getText().toString().equalsIgnoreCase("") || lokasiBuku.getText().toString().equalsIgnoreCase("") || deskripsiBuku.getText().toString().equalsIgnoreCase("") ) {
            Toast.makeText(this, "data belum lengkap", Toast.LENGTH_SHORT).show();
        } else {
            Random r = new Random();
            int i1 = r.nextInt(80 - 65) + 65;
            buku buku = new buku();
            buku.setIdeBuku(i1);
            buku.setJudulBuku(judulBuku.getText().toString());
            buku.setpenulisBuku(penulisBuku.getText().toString());
            buku.setPenerbitBuku(penerbitBuku.getText().toString());
            buku.setTahunTerbitBuku(tahunTerbitBuku.getText().toString());
            buku.setLokasiBuku(lokasiBuku.getText().toString());
            buku.setDeskripsiBuku(deskripsiBuku.getText().toString());
            if (tag == 0) {
                dao.insert(buku);

            } else {
                buku.setIdeBuku(ID);
                dao.update(buku);
            }
            reset();
        }
    }

    public void reset() {
        ID = 0;
        tag = 0;
        penulisBuku.setText("");
        judulBuku.setText("");
        penerbitBuku.setText("");
        tahunTerbitBuku.setText("");
        lokasiBuku.setText("");
        deskripsiBuku.setText("");
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(insertBuku.this, ListBuku.class);
        i.putExtra("tabel", "ori");
        i.putExtra("value", "null");
        startActivity(i);
        finish();
    }
}
