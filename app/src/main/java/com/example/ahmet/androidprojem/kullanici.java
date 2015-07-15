package com.example.ahmet.androidprojem;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ahmet on 5.1.2015.
 */
public class kullanici extends Activity{
    private veritabani vt;
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kullanici);
        vt=new veritabani(this);


        try
        {

            cursor = KayitGetir();
            KayitGoster(cursor);

        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),
                    e.toString(), Toast.LENGTH_LONG).show();
        }
        final CheckBox chc=(CheckBox) findViewById(R.id.checked);
        final Button ony=(Button) findViewById(R.id.onay);


        chc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(chc.isChecked())
                {

                    ony.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            try {
                                String guncel = "1";
                                veritabaniNumaraGuncelle(guncel);
                            }
                            catch(Exception e)
                            {
                                Toast.makeText(getApplicationContext(),e.toString(),
                                    Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

    }

    private String[] SELECT = {"id","ogrenciadi", "ogrencisoyadi","onumara","sinif","sifre","onay"};

    private Cursor KayitGetir(){
        SQLiteDatabase db = vt.getReadableDatabase();
        Cursor cursor = db.query("ogrenci", SELECT,null,null,null,null,null,null);
        startManagingCursor(cursor);
        return cursor;
    }
    private void KayitGoster(Cursor cursor){
        StringBuilder builder = new StringBuilder("Kayitlar:n");
        String veriler="";
        while(cursor.moveToNext()){

            //int id = cursor.getInt(cursor.getColumnIndex("id"));
            String ad = cursor.getString((cursor.getColumnIndex("ogrenciadi")));
            String soyad = cursor.getString((cursor.getColumnIndex("ogrencisoyadi")));
            String numara = cursor.getString((cursor.getColumnIndex("onumara")));
            String sinifi = cursor.getString((cursor.getColumnIndex("sinif")));
            //String sifre = cursor.getString((cursor.getColumnIndex("sifre")));
            String onay = cursor.getString((cursor.getColumnIndex("onay")));
            if(onay.equals("0"))
            {
                veriler=veriler+ad+"-"+soyad+"-"+numara+"-"+sinifi+"-"+onay;
            }

            /*builder.append(id).append(" Adı: ");
            builder.append(ad).append(" Soyadı: ");
            builder.append(soyad).append("Numara");
            builder.append(numara).append("Sinif:");
            builder.append(sinifi).append(" Sifre: ");
            builder.append(sifre);*/

        }

        TextView text = (TextView)findViewById(R.id.textView1);
        text.setText(veriler);

    }
    private void veritabaniNumaraGuncelle(String guncelOperatorKodu) {
        int donus_id=0;
        String guncelhal="0";
        SQLiteDatabase db = vt.getReadableDatabase();
        Cursor cursorKayit = db.query("ogrenci", SELECT, null,null,null,null,"onay="+guncelhal);
        if (cursorKayit.getCount()!=0)
        {
            while(cursorKayit.moveToNext()){
                donus_id = Integer.parseInt(cursorKayit.getString((cursorKayit.getColumnIndex("id"))));
            }
            cursorKayit.close();
        }else{
            donus_id=0;
        }
        SQLiteDatabase db2 = vt.getWritableDatabase();
        ContentValues cv=new ContentValues();
        String[] idArray = { String.valueOf(donus_id) };
        cv.put("onay", guncelOperatorKodu);
        try
        {
            db2.update("ogrenci",cv, "id" + "=?",idArray);
        }
        catch(Exception e)
        {  }
        Toast.makeText(getApplicationContext(), "ONAYLADINIZ",
                Toast.LENGTH_SHORT).show();
        try
        {

            cursor = KayitGetir();
            KayitGoster(cursor);

        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),
                    e.toString(), Toast.LENGTH_LONG).show();
        }


    }
}



