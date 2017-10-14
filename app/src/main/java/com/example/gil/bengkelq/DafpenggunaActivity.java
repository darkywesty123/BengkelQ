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
    private TextView rolePengguna;
    private EditText NamaPengguna;
    private EditText EmailPengguna;
    private EditText PasswordPengguna;
    private Button buttonDaftarPengguna;

    private FirebaseAuth firebaseAuth;
    private DatabaseReference dataPengguna;

    private ProgressDialog progressDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dafpengguna);

        firebaseAuth = FirebaseAuth.getInstance();

        dataPengguna = FirebaseDatabase.getInstance().getReference().child("akun");

        progressDaftar = new ProgressDialog(this);

        rolePengguna = (TextView) findViewById(R.id.textViewRolePengguna);
        NamaPengguna = (EditText) findViewById(R.id.editTextNamaPengguna);
        EmailPengguna = (EditText) findViewById(R.id.editTextEmailPengguna);
        PasswordPengguna = (EditText) findViewById(R.id.editTextPasswordPengguna);
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

        final String nama = NamaPengguna.getText().toString().trim();
        final String role = rolePengguna.getText().toString().trim();
        String email = EmailPengguna.getText().toString().trim();
        String password = PasswordPengguna.getText().toString().trim();

        if(!TextUtils.isEmpty(nama) && !TextUtils.isEmpty(email) &&!TextUtils.isEmpty(password)) {

            progressDaftar.setMessage("Mendaftarkan pengguna ...");
            progressDaftar.show();

            firebaseAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            String user_id = firebaseAuth.getCurrentUser().getUid();
                            DatabaseReference baruDaftarPengguna = dataPengguna.child(user_id);

                            baruDaftarPengguna.child("nama").setValue(nama);
                            baruDaftarPengguna.child("role").setValue(role);

                            progressDaftar.dismiss();

                            Toast.makeText(DafpenggunaActivity.this, "Pendaftaran berhasil", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(DafpenggunaActivity.this, HomeActivity.class));
                        } else {
                            progressDaftar.dismiss();
                            Toast.makeText(DafpenggunaActivity.this, "Terdapat kesalahan"+role, Toast.LENGTH_LONG).show();
                        }
                        }
                    });
        }

    }
}
