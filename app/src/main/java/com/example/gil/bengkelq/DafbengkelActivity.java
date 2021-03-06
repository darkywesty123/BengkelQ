package com.example.gil.bengkelq;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

public class DafbengkelActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText namaPemilik;
    private EditText emailBengkel;
    private EditText passwordBengkel;
    private EditText phoneBengkel;
    private Button buttonLanjut1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dafbengkel);

        namaPemilik     = (EditText) findViewById(R.id.txtNamaPemilik);
        emailBengkel    = (EditText) findViewById(R.id.txtEmailBengkel);
        passwordBengkel = (EditText) findViewById(R.id.txtPasswordBengkel);
        phoneBengkel    = (EditText) findViewById(R.id.txtPhoneBengkel);
        buttonLanjut1   = (Button) findViewById(R.id.BtnLanjut1);

        buttonLanjut1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == buttonLanjut1){
            cekKonten();
        }
    }

    private void cekKonten() {
        String nama = namaPemilik.getText().toString().trim();
        String email = emailBengkel.getText().toString().trim();
        String pass = passwordBengkel.getText().toString().trim();
        String phone = phoneBengkel.getText().toString().trim();
        if(!TextUtils.isEmpty(nama) && !TextUtils.isEmpty(email)
                && !TextUtils.isEmpty(pass) && !TextUtils.isEmpty(phone)) {
            Intent intent = new Intent(DafbengkelActivity.this, Dafbengkel2Activity.class);
            intent.putExtra("namaPem", namaPemilik.getText().toString());
            intent.putExtra("emailB", emailBengkel.getText().toString());
            intent.putExtra("passB", passwordBengkel.getText().toString());
            intent.putExtra("phoneB", phoneBengkel.getText().toString());
            startActivity(intent);
        } else {
            Toast.makeText(DafbengkelActivity.this, "Identitas pemilik belum lengkap", Toast.LENGTH_LONG).show();
        }
    }

}
