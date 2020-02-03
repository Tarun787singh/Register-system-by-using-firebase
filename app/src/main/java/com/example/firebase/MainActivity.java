package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {


    EditText email;
    EditText password;
    Button buttton;
    private FirebaseAuth mAuth;

    //Make sureto check email and password are not empty and null.


    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        Toast.makeText(this,"AlreadyIn",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = (EditText) findViewById(R.id.Email);
        password = (EditText) findViewById(R.id.Password);


        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
    }

    public void onRegister(View view){
       final String myEmail = email.getText().toString();
       final String myPass = password.getText().toString();
        mAuth.createUserWithEmailAndPassword(myEmail, myPass)
                .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.i("TAG", "createUserWithEmail:success");
                            Toast.makeText(MainActivity.this,"Success",Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(MainActivity.this,"failure",Toast.LENGTH_SHORT).show();
                            // If sign in fails, display a message to the user.


                        }

                        // ...
                    }
                });

    }


}
