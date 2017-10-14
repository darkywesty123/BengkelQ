package com.example.gil.bengkelq;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AwalActivity extends AppCompatActivity {

    private Button BtnLoginAwal;
    private Button BtnRegisterAwal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_awal);

        BtnLoginAwal = (Button) findViewById(R.id.BtnLoginAwal);
        BtnRegisterAwal = (Button) findViewById(R.id.BtnRegisterAwal);

        BtnLoginAwal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginAwal = new Intent(AwalActivity.this, MainActivity.class);
                startActivity(loginAwal);
            }
        });

        BtnRegisterAwal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent RegisterAwal = new Intent(AwalActivity.this, PilihDaftarActivity.class);
                startActivity(RegisterAwal);
            }
        });
    }
}
