package com.example.ahmet.androidprojem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by ahmet on 5.1.2015.
 */
public class admin extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        final Button klnc=(Button) findViewById(R.id.kullanici);
        final Button dyr=(Button) findViewById(R.id.duyuru);
        final Button rndv=(Button) findViewById(R.id.randevu);

        klnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intnt=new Intent(admin.this,kullanici.class);
                startActivity(intnt);
            }
        });
        dyr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intnt1=new Intent(admin.this,duyuru.class);
                startActivity(intnt1);
            }
        });
        rndv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intnt2=new Intent(admin.this,randevu.class);
                startActivity(intnt2);
            }
        });

    }
}
