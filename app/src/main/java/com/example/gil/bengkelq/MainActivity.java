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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button BtnLogin;

    private FirebaseAuth mAuth;
    private DatabaseReference dataAkun;

    private ProgressDialog progressLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        dataAkun = FirebaseDatabase.getInstance().getReference().child("akun");

        progressLogin = new ProgressDialog(this);

        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        BtnLogin = (Button) findViewById(R.id.BtnLogin);

        BtnLogin.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
//        FirebaseUser currUser = mAuth.getCurrentUser();
    }

    public void checkLogin(String email, String password) {

        if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {

            progressLogin.setMessage("Mengecek akun ...");
            progressLogin.show();
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        String user_id = mAuth.getCurrentUser().getUid();
                        DatabaseReference mauCek = dataAkun.child(user_id).child("role");

                        mauCek.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                if(dataSnapshot.getValue().equals("PENGGUNA")){
                                    progressLogin.dismiss();
                                    finish();
                                    Intent masukPengguna = new Intent(MainActivity.this, HomeActivity.class);
                                    startActivity(masukPengguna);
                                } else {
                                    progressLogin.dismiss();
                                    finish();
                                    Intent masukBengkel = new Intent(MainActivity.this, HomebklActivity.class);
                                    startActivity(masukBengkel);
                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });

                    } else {
                        progressLogin.dismiss();
                        Toast.makeText(MainActivity.this, "Email/password salah", Toast.LENGTH_LONG).show();
                    }
                }
            });
        } else {
            Toast.makeText(MainActivity.this, "Lengkapi Email dan Password", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View v) {
        if(v == BtnLogin){
            String emailMasuk = editTextEmail.getText().toString().trim();
            String passwordMasuk = editTextPassword.getText().toString().trim();
            checkLogin(emailMasuk, passwordMasuk);
        }
    }
}
