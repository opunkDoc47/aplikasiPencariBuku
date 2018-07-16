package com.example.asus.coba.config;

import android.database.Cursor;

/**
 * Created by ASUS on 7/11/2018.
 */

public interface bukuDAO {
    public void insert( buku buku);
    public void update(buku buku);
    public boolean delete(int idBuku);
    public Cursor read(String tabel,String value);
}
