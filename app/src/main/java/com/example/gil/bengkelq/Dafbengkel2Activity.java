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

    private ProgressDialog progressDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dafbengkel2);

        firebaseAuth = FirebaseAuth.getInstance();

        dataBengkel = FirebaseDatabase.getInstance().getReference().child("akun");

        progressDaftar = new ProgressDialog(this);

        namaB   = (EditText) findViewById(R.id.editTextNamaBengkel);
        alamatB = (EditText) findViewById(R.id.editTextAlamatBengkel);
        descB   = (EditText) findViewById(R.id.editTextDescBengkel);
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

        final String role = getIntent().getStringExtra("roleB").trim();
        final String namaPemilik = getIntent().getStringExtra("namaPem").trim();
        final String phonePemilik = getIntent().getStringExtra("phoneB").trim();
        String email = getIntent().getStringExtra("emailB").trim();
        String password = getIntent().getStringExtra("passB").trim();
        final String namaBengkel = namaB.getText().toString().trim();
        final String alamatBengkel = alamatB.getText().toString().trim();
        final String descBengkel = descB.getText().toString().trim();

        if(!TextUtils.isEmpty(namaBengkel) && !TextUtils.isEmpty(alamatBengkel) &&!TextUtils.isEmpty(descBengkel)) {

            progressDaftar.setMessage("Mendaftarkan bengkel ...");
            progressDaftar.show();

            firebaseAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()) {
                                String user_id = firebaseAuth.getCurrentUser().getUid();
                                DatabaseReference baruDaftarPengguna = dataBengkel.child(user_id);

                                baruDaftarPengguna.child("nama").setValue(namaPemilik);
                                baruDaftarPengguna.child("role").setValue(role);
                                baruDaftarPengguna.child("phone").setValue(phonePemilik);
                                baruDaftarPengguna.child("namaBengkel").setValue(namaBengkel);
                                baruDaftarPengguna.child("alamatBengkel").setValue(alamatBengkel);
                                baruDaftarPengguna.child("descBengkel").setValue(descBengkel);

                                progressDaftar.dismiss();

                                Toast.makeText(Dafbengkel2Activity.this, "Pendaftaran berhasil", Toast.LENGTH_LONG).show();
                                startActivity(new Intent(Dafbengkel2Activity.this, HomebklActivity.class));
                            } else {
                                progressDaftar.dismiss();
                                Toast.makeText(Dafbengkel2Activity.this, "Terdapat kesalahan", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
        }

    }
}


