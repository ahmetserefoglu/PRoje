package com.example.ahmet.androidprojem;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
/**
 * Created by ahmet on 23.12.2014.
 */
public class uyeol extends Activity {
    private veritabani vt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uyeol);

        final EditText ad=(EditText) findViewById(R.id.adi);
        final EditText soyad=(EditText) findViewById(R.id.soyadi);
        final EditText num=(EditText) findViewById(R.id.numara);
        final EditText sinifi=(EditText) findViewById(R.id.sinif);
        final EditText sifre=(EditText) findViewById(R.id.sifre);
        final Button kaydol=(Button) findViewById(R.id.kayit);


        vt=new veritabani(this);

        kaydol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                String onay="0";

                SQLiteDatabase db=vt.getWritableDatabase();
                ContentValues cv=new ContentValues();
                cv.put("ogrenciadi",ad.getText().toString());
                cv.put("ogrencisoyadi",soyad.getText().toString());
                cv.put("onumara",num.getText().toString());
                cv.put("sinif",sinifi.getText().toString());
                cv.put("sifre",sifre.getText().toString());
                cv.put("onay",onay);
                db.insertOrThrow("ogrenci", null, cv);
                Toast.makeText(getApplicationContext(),
                        "Kayıt Alındı Admin Onayından Sonra Giris Yapabilirsiniz", Toast.LENGTH_LONG).show();


            }
                catch(Exception e)
                {
                    Toast.makeText(getApplicationContext(),
                            e.toString(), Toast.LENGTH_LONG).show();
                }
            }
        });


    }


}
