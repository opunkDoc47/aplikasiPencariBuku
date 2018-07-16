package com.example.asus.coba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DataBuku extends AppCompatActivity {
    TextView title,judulBuku,penulis,penerbit,tahuTerbit,lokasiBuku,deskripsi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_buku);
        title=(TextView)findViewById(R.id.title1);
        judulBuku=(TextView)findViewById(R.id.judulBuku);
        penulis=(TextView)findViewById(R.id.penulis);
        penerbit=(TextView)findViewById(R.id.penerbit);
        tahuTerbit=(TextView)findViewById(R.id.tahuTerbit);
        lokasiBuku=(TextView)findViewById(R.id.lokasiBuku);
        deskripsi=(TextView)findViewById(R.id.deskripsi);
        Intent i=getIntent();
        title.setText(i.getStringExtra("judulBuku"));
        judulBuku.setText(i.getStringExtra("judulBuku"));
        penulis.setText(i.getStringExtra("penulisBuku"));
        penerbit.setText(i.getStringExtra("penerbitBuku"));
        tahuTerbit.setText(i.getStringExtra("tahunTerbitBuku"));
        lokasiBuku.setText(i.getStringExtra("lokasiBuku"));
        deskripsi.setText(i.getStringExtra("deskripsiBuku"));
    }
}
