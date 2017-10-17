package com.example.gil.bengkelq;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PilihDaftarActivity extends AppCompatActivity implements View.OnClickListener{

    private Button pengguna;
    private Button bengkel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_daftar);

        pengguna = (Button) findViewById(R.id.BtnPengguna);
        bengkel = (Button) findViewById(R.id.BtnBengkel);

        pengguna.setOnClickListener(this);
        bengkel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == pengguna) {
            startActivity(new Intent(this, DafpenggunaActivity.class));
        } else if (v == bengkel) {
            startActivity(new Intent(this, DafbengkelActivity.class));
        }
    }
}
