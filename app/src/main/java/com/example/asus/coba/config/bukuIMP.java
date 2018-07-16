package com.example.asus.coba.config;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by ASUS on 7/11/2018.
 */

public class bukuIMP extends SQLiteOpenHelper implements bukuDAO {
    public bukuIMP(Context context) {
        super(context, "db_buku", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL("CREATE TABLE BUKU(idBuku INTEGER PRIMARY KEY AUTOINCREMENT ,judulBuku TEXT,penulisBuku TEXT,penerbitBuku TEXT,tahunTerbitBuku INTEGER,lokasiBuku TEXT,deskripsiBuku TEXT)");
        } catch (Exception e) {
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        try {
            db.execSQL("DROP TABLE BUKU");
        } catch (Exception e) {

        }

    }

    @Override
    public void insert(buku buku) {
        try {
            SQLiteDatabase db = getWritableDatabase();
            db.execSQL("INSERT INTO BUKU VALUES('" + buku.getIdeBuku() + "','" + buku.getJudulBuku() + "','" + buku.getpenulisBuku() + "','" + buku.getPenerbitBuku() + "','" + buku.getTahunTerbitBuku() + "','" + buku.getLokasiBuku() + "','" + buku.getDeskripsiBuku() + "')");
        } catch (Exception e) {

        }
    }

    @Override
    public void update(buku buku) {
        try {
            SQLiteDatabase db = getWritableDatabase();
            db.execSQL("UPDATE BUKU SET judulBuku ='" + buku.getJudulBuku() + "',penulisBuku ='" + buku.getpenulisBuku() + "',penerbitBuku ='" + buku.getPenerbitBuku() + "',tahunTerbitBuku ='" + buku.getTahunTerbitBuku() + "',lokasiBuku ='" + buku.getLokasiBuku() + "',deskripsiBuku ='" + buku.getDeskripsiBuku() + "' where idBuku ='" + buku.getIdeBuku() + "'");
        } catch (Exception e) {

        }
    }

    @Override
    public boolean delete(int idBuku) {
        SQLiteDatabase db = getWritableDatabase();
        String query = "delete from BUKU where idBuku ='" + idBuku + "'";
        db.execSQL(query);
    return true;}

    @Override
    public Cursor read(String tabel, String value) {
        SQLiteDatabase db = getWritableDatabase();
        if (tabel.equalsIgnoreCase("ori")) {
            return db.rawQuery("SELECT * FROM BUKU", null);
        } else {
            return db.rawQuery("SELECT * FROM BUKU where "+tabel+" = '"+value+"'", null);
        }

    }
}
