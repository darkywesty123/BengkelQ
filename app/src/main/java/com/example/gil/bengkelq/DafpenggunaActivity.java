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

public class DafpenggunaActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText namaPengguna;
    private EditText emailPengguna;
    private EditText passwordPengguna;
    private Button buttonDaftarPengguna;
    private FBHelper fbHelper = new FBHelper();

    private FirebaseAuth firebaseAuth;
    private DatabaseReference dataPengguna;

    private ProgressDialog progressDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dafpengguna);

        firebaseAuth = FirebaseAuth.getInstance();
        dataPengguna = FirebaseDatabase.getInstance().getReference().child("akun");

        namaPengguna = (EditText) findViewById(R.id.txtNamaPengguna);
        emailPengguna = (EditText) findViewById(R.id.txtEmailPengguna);
        passwordPengguna = (EditText) findViewById(R.id.txtPasswordPengguna);
        buttonDaftarPengguna = (Button) findViewById(R.id.BtnDaftarPengguna);

        buttonDaftarPengguna.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == buttonDaftarPengguna){
            registerUser();
        }
    }

    private void registerUser() {

        final String nama = namaPengguna.getText().toString().trim();
        String email = emailPengguna.getText().toString().trim();
        String password = passwordPengguna.getText().toString().trim();

        if(!TextUtils.isEmpty(nama) && !TextUtils.isEmpty(email) &&!TextUtils.isEmpty(password)) {
            fbHelper.registerUser(email, password, nama, "PENGGUNA", this, DafpenggunaActivity.this, null,null,null,null);
        } else {
            Toast.makeText(DafpenggunaActivity.this, "Identitas pengguna belum lengkap", Toast.LENGTH_LONG).show();
        }

    }
}
