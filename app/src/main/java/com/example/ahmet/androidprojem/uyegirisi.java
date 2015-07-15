package com.example.ahmet.androidprojem;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.database.Cursor;

/**
 * Created by ahmet on 23.12.2014.
 */
public class uyegirisi extends Activity {


    private veritabani vt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uye);
        final Button giriss=(Button) findViewById(R.id.giris);
        final EditText numm=(EditText) findViewById(R.id.onumara);
        final EditText pass=(EditText) findViewById(R.id.sifre);
        vt=new veritabani(this);


//String donusDegeri;
        giriss.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try{
                    Intent intent1=new Intent(uyegirisi.this,anasayfa.class);
                    Cursor cursor;
                    cursor = KayitGetir(numm.getText().toString(), pass.getText().toString());
                    if (cursor.getCount()!=0)
                    {
                        while(cursor.moveToNext()){

                            String num = cursor.getString((cursor.getColumnIndex("onumara")));
                            String sfr = cursor.getString((cursor.getColumnIndex("sifre")));
                            String ony=cursor.getString((cursor.getColumnIndex("onay")));
                            if(num.equals(numm.getText().toString()) && sfr.equals(pass.getText().toString()) && ony.equals("1"))
                            {
                                startActivity(intent1);
                                Toast.makeText(getApplicationContext(),
                                        "Hosgeldiniz", Toast.LENGTH_LONG).show();
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(),
                                        "Kullanıcı bulunumadi", Toast.LENGTH_LONG).show();

                            }
                        }

                    }


                }
               catch (Exception e)
               {
                  /**/
               }


            }
        });
    }


    private String[] SELECT = {"id", "ogrenciadi", "ogrencisoyadi","onumara","sinif","sifre","onay"};

    private Cursor KayitGetir(String numara, String sifre){
        SQLiteDatabase db = vt.getReadableDatabase();
        Cursor cursor = db.query("ogrenci", SELECT, null,null,"onumara="+numara,null,"sifre="+sifre,null);

        startManagingCursor(cursor);
        return cursor;
    }
    /*private void KayitGoster(Cursor cursor){
        StringBuilder builder = new StringBuilder("Kayitlar:n");

        while(cursor.moveToNext()){

            long id = cursor.getLong(cursor.getColumnIndex("id"));
            String ad = cursor.getString((cursor.getColumnIndex("ogrenciadi")));
            String soyad = cursor.getString((cursor.getColumnIndex("ogrencisoyadi")));
            String numara = cursor.getString((cursor.getColumnIndex("onumara")));
            String sinifi = cursor.getString((cursor.getColumnIndex("sinif")));
            String sifre = cursor.getString((cursor.getColumnIndex("sifre")));
            builder.append(id).append(" Adı: ");
            builder.append(ad).append(" Soyadı: ");
            builder.append(numara).append("Numara:");
            builder.append(sinifi).append(" Sinif: ");
            builder.append(sifre).append(" Sifre: ");
            builder.append(soyad).append("n");
        }


    }*/


}
