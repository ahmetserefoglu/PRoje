package com.example.ahmet.androidprojem;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ahmet on 23.12.2014.
 */
public class veritabani extends SQLiteOpenHelper {
    private static String dbadi="veritabanim";
    private static  int versiyon=1;
    public veritabani(Context c){ super(c,dbadi,null,versiyon) ; }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE ogrenci(id INTEGER primary key AUTOINCREMENT ,ogrenciadi text,ogrencisoyadi text,onumara text,sinif text,sifre text,onay text);");
       // db.execSQL("CREATE TABLE admin(adminadi text,adminsifre text)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table ogrenci");
        onCreate(db);

    }
}
