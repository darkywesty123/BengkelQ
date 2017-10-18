package com.example.gil.bengkelq;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
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

/**
 * Created by root on 10/17/17.
 */

public class FBHelper {
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference ref = db.getReference();
    private ProgressDialog progress;

    public void login(final String email, final String password, final Activity activity){
        progress = new ProgressDialog(activity);
        progress.setMessage("Mengecek akun ...");
        progress.show();

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    final String user_id = mAuth.getCurrentUser().getUid();
                    ref.child(user_id).child("role");
                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if(dataSnapshot.getValue().equals("PENGGUNA")){
                                progress.dismiss();
                                activity.finish();
                            } else {
                                progress.dismiss();
                                activity.finish();
                            }
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                } else {
                    progress.dismiss();
                    Toast.makeText(activity, "Email/password salah", Toast.LENGTH_LONG).show();
                }
            }
        });
    }



    public void getRole(final Activity activity){
        String user_id = mAuth.getCurrentUser().getUid();
        DatabaseReference chill = ref.child("akun").child(user_id).child("role");

        chill.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String role=dataSnapshot.getValue(String.class);
                if(role.equals("PENGGUNA")){
                    activity.finish();
                    activity.startActivity(new Intent(activity, HomeActivity.class));
                }else {
                    activity.finish();
                    activity.startActivity(new Intent(activity, HomebklActivity.class));
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void registerUser(String email, String password, final String nama, final String role, final Activity activity, final Context context,
                             final String phonePemilik, final String namaBengkel, final String alamatBengkel, final String descBengkel){
        progress = new ProgressDialog(activity);
        progress.setMessage("Mendaftarkan User ...");
        progress.show();

        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()) {
                        String user_id = mAuth.getCurrentUser().getUid();
                        DatabaseReference newUser = ref.child("akun").child(user_id);

                        addUser(newUser, nama, role, phonePemilik, namaBengkel, alamatBengkel, descBengkel);
                        progress.dismiss();

                        Toast.makeText(context, "Pendaftaran berhasil", Toast.LENGTH_LONG).show();
                        if(role.equals("PENGGUNA"))
                            activity.startActivity(new Intent(activity, HomeActivity.class));
                        else
                            activity.startActivity(new Intent(activity, HomebklActivity.class));
                    } else {
                        progress.dismiss();
                        Toast.makeText(context, "Terdapat kesalahan", Toast.LENGTH_LONG).show();
                    }
                }
            });
    }

    public void addUser(DatabaseReference newUser, String nama, String role, String phonePemilik, String namaBengkel, String alamatBengkel, String descBengkel){
        newUser.child("nama").setValue(nama);
        newUser.child("role").setValue(role);
        if(role=="PEMILIK"){
            newUser.child("phone").setValue(phonePemilik);
            newUser.child("namaBengkel").setValue(namaBengkel);
            newUser.child("alamatBengkel").setValue(alamatBengkel);
            newUser.child("descBengkel").setValue(descBengkel);
        }
    }

}
