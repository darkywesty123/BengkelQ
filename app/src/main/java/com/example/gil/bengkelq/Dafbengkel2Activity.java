package com.example.gil.bengkelq;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Dafbengkel2Activity extends AppCompatActivity implements View.OnClickListener {

    private EditText namaB;
    private EditText alamatB;
    private EditText descB;
    private Button submitB;

    private FirebaseAuth firebaseAuth;
    private DatabaseReference dataBengkel;

    private FBHelper fbHelper = new FBHelper();
    private ProgressDialog progressDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dafbengkel2);

        firebaseAuth = FirebaseAuth.getInstance();

        dataBengkel = FirebaseDatabase.getInstance().getReference().child("akun");

        progressDaftar = new ProgressDialog(this);

        namaB   = (EditText) findViewById(R.id.txtNamaBengkel);
        alamatB = (EditText) findViewById(R.id.txtAlamatBengkel);
        descB   = (EditText) findViewById(R.id.txtDescBengkel);
        submitB = (Button) findViewById(R.id.BtnSubmitB);

        submitB.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == submitB){
            registerBengkel();
        }
    }

    private void registerBengkel() {

        final String namaPemilik = getIntent().getStringExtra("namaPem").trim();
        final String phonePemilik = getIntent().getStringExtra("phoneB").trim();
        String email = getIntent().getStringExtra("emailB").trim();
        String password = getIntent().getStringExtra("passB").trim();
        final String namaBengkel = namaB.getText().toString().trim();
        final String alamatBengkel = alamatB.getText().toString().trim();
        final String descBengkel = descB.getText().toString().trim();

        if(!TextUtils.isEmpty(namaBengkel) && !TextUtils.isEmpty(alamatBengkel) &&!TextUtils.isEmpty(descBengkel)) {
            fbHelper.registerUser(email, password, namaPemilik, "PEMILIK", Dafbengkel2Activity.this, this, phonePemilik,namaBengkel,alamatBengkel,descBengkel);
        } else {
            Toast.makeText(Dafbengkel2Activity.this, "Identitas bengkel belum lengkap", Toast.LENGTH_SHORT).show();
        }

    }
}


