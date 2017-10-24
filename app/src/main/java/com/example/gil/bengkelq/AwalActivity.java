package com.example.gil.bengkelq;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AwalActivity extends AppCompatActivity implements View.OnClickListener{

    private Button BtnLoginAwal;
    private Button BtnRegisterAwal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_awal);

        BtnLoginAwal = (Button) findViewById(R.id.BtnLoginAwal);
        BtnRegisterAwal = (Button) findViewById(R.id.BtnRegisterAwal);

        BtnLoginAwal.setOnClickListener(this);
        BtnRegisterAwal.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == BtnLoginAwal){
            startActivity(new Intent(AwalActivity.this, MainActivity.class));
        }
        else if(v == BtnRegisterAwal){
            startActivity(new Intent(AwalActivity.this, PilihDaftarActivity.class));
        }
    }
}
