package com.example.ahmet.androidprojem;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by ahmet on 5.1.2015.
 */
public class admingiris extends Activity {
    private veritabani vt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admingiris);
        final EditText adi=(EditText) findViewById(R.id.ad);
        final EditText sifrem=(EditText) findViewById(R.id.sifre);
        final Button grs=(Button) findViewById(R.id.giris);
        grs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent1=new Intent(admingiris.this,admin.class);
                            if(adi.getText().toString().equals("ahmet") && sifrem.getText().toString().equals("2230"))
                            {
                                startActivity(intent1);
                                Toast.makeText(getApplicationContext(),
                                        "Hosgeldiniz", Toast.LENGTH_LONG).show();
                            }

                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(),
                            e.toString(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }


}


