package com.example.asus.coba;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.asus.coba.config.bukuDAO;
import com.example.asus.coba.config.bukuIMP;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomButtons.SimpleCircleButton;
import com.nightonke.boommenu.BoomButtons.TextInsideCircleButton;
import com.nightonke.boommenu.BoomButtons.TextOutsideCircleButton;
import com.nightonke.boommenu.BoomMenuButton;

import java.util.ArrayList;
import java.util.HashMap;

public class ListBuku extends AppCompatActivity {
    private ListView listbuku;
    bukuDAO dao;
    ArrayList<HashMap<String, String>> arrayList;
    TextOutsideCircleButton.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_buku);
        listbuku = (ListView) findViewById(R.id.listBuku);
        dao = new bukuIMP(this);
        setTitle("DAFTAR BUKU");
        Intent intent = getIntent();
        tampil(intent.getStringExtra("tabel"), intent.getStringExtra("value"));
        buatFloatingActionButton();
        tambahAlrtMenu();

    }

    private void tampil(String tabel, String value) {
        arrayList = new ArrayList<>();
        Cursor cursor = dao.read(tabel, value);
        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> hs = new HashMap<>();
                hs.put("idBuku",String.valueOf( cursor.getString(0)));
                hs.put("judulBuku", cursor.getString(1));
                hs.put("penulisBuku", cursor.getString(2));
                hs.put("penerbitBuku", cursor.getString(3));
                hs.put("tahunTerbitBuku", cursor.getString(4));
                hs.put("lokasiBuku", cursor.getString(5));
                hs.put("deskripsiBuku", cursor.getString(6));
                arrayList.add(hs);
            } while (cursor.moveToNext());
            String key[] = {"judulBuku"};
            int komponen[] = {R.id.judulBukuItem};
            SimpleAdapter adapter = new SimpleAdapter(this, arrayList, R.layout.item, key, komponen);
            listbuku.setAdapter(adapter);

        }

    }
    private void buatFloatingActionButton(){
        BoomMenuButton bmb = (BoomMenuButton) findViewById(R.id.bmb);

        builder = new TextOutsideCircleButton.Builder()
                .normalImageRes(R.drawable.tambah)
                .normalText("TAMBAH BUKU")
                .rippleEffect(true)
                .textSize(14)
                .listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {
                        Intent i = new Intent(ListBuku.this, insertBuku.class);
                        i.putExtra("tag","0");
                        startActivity(i);
                    }
                });
        bmb.addBuilder(builder);
        builder = new TextOutsideCircleButton.Builder()
                .normalImageRes(R.drawable.cari)
                .normalText("CARI BUKU")
                .rippleEffect(true)
                .textSize(14)
                .listener(new OnBMClickListener() {
            @Override
            public void onBoomButtonClick(int index) {
                Intent i=new Intent(ListBuku.this,cari.class);
                startActivity(i);
            }
        });
        bmb.addBuilder(builder);
    }
    private void tambahAlrtMenu(){
        listbuku.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                String[] pilihan = {"Tampil data", "Ubah data", "Hapus data"};
//                    Toast.makeText(MainActivity.this,listBiodata.get(position).get("nim"), Toast.LENGTH_SHORT).show();
                final AlertDialog.Builder builder = new AlertDialog.Builder(ListBuku.this);
                final AlertDialog.Builder confirm = new AlertDialog.Builder(ListBuku.this);
                builder.setTitle("Pilihan");
                builder.setItems(pilihan, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int pilih) {
                        switch (pilih) {
                            case 0:
//                                TODO:TAMPIL DATA
                                Intent intenta = new Intent(ListBuku.this, DataBuku.class);
                                intenta.putExtra("judulBuku", arrayList.get(position).get("judulBuku"));
                                intenta.putExtra("penulisBuku", arrayList.get(position).get("penulisBuku"));
                                intenta.putExtra("penerbitBuku", arrayList.get(position).get("penerbitBuku"));
                                intenta.putExtra("tahunTerbitBuku", arrayList.get(position).get("tahunTerbitBuku"));
                                intenta.putExtra("lokasiBuku", arrayList.get(position).get("lokasiBuku"));
                                intenta.putExtra("deskripsiBuku", arrayList.get(position).get("deskripsiBuku"));
                                startActivity(intenta);
                                break;
                            case 1:
//                                TODO:EDIT DATA
                                Intent intent = new Intent(ListBuku.this, insertBuku.class);
                                intent.putExtra("tag", "1");
                                intent.putExtra("idBuku", String.valueOf(arrayList.get(position).get("idBuku")));
                                intent.putExtra("judulBuku", arrayList.get(position).get("judulBuku"));
                                intent.putExtra("penulisBuku", arrayList.get(position).get("penulisBuku"));
                                intent.putExtra("penerbitBuku", arrayList.get(position).get("penerbitBuku"));
                                intent.putExtra("tahunTerbitBuku", arrayList.get(position).get("tahunTerbitBuku"));
                                intent.putExtra("lokasiBuku", arrayList.get(position).get("lokasiBuku"));
                                intent.putExtra("deskripsiBuku", arrayList.get(position).get("deskripsiBuku"));
                                startActivity(intent);
                                break;
                            case 2:
//                               TODO:HAPUS DATA
                                confirm.setMessage("Yakin ingin hapus");
                                confirm.setNegativeButton("tidak", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                                confirm.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int i) {
                                        boolean cek = dao.delete(Integer.valueOf(arrayList.get(position).get("idBuku")));
                                        if (cek) {
                                            tampil("ori","null");
                                            Toast.makeText(ListBuku.this, "Data Berhasil di Hapus", Toast.LENGTH_SHORT).show();
                                        } else {
                                            Toast.makeText(ListBuku.this, "Data Gagal di Hapus", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                                confirm.show();
                                break;

                        }

                    }
                });
                builder.show();
            }
        });
    }
}
