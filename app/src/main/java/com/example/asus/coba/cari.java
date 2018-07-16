package com.example.asus.coba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class cari extends AppCompatActivity {
    String pilihan[]={"PILIH","Judul Buku","penulis","Penerbit","Tahun Terbit"};
    Spinner pilih;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari);
        pilih=(Spinner) findViewById(R.id.co);
        ArrayAdapter<String>adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,pilihan);
        pilih.setAdapter(adapter);
    }

}

