package com.example.gil.bengkelq;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PilihDaftarActivity extends AppCompatActivity {

    private Button pengguna;
    private Button bengkel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_daftar);

        pengguna = (Button) findViewById(R.id.BtnPengguna);
        bengkel = (Button) findViewById(R.id.BtnBengkel);

        pengguna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dafpengguna = new Intent(PilihDaftarActivity.this, DafpenggunaActivity.class);
                startActivity(dafpengguna);
            }
        });

        bengkel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dafbengkel = new Intent(PilihDaftarActivity.this, DafbengkelActivity.class);
                startActivity(dafbengkel);
            }
        });
    }
}
