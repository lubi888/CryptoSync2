package com.liberties.iveagh.cryptosync2;

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

public class FirebaseLogin extends AppCompatActivity implements View.OnClickListener {

    private Button buttonSignin;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewSignup;

    private FirebaseAuth firebaseAuth;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_login);

        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() != null){
            //profile actgivity here
            finish();
            startActivity(new Intent(getApplicationContext(), FirebaseProfile.class));
        }

        progressDialog = new ProgressDialog(this);

        buttonSignin = (Button) findViewById(R.id.buttonSignin);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        textViewSignup = (TextView) findViewById(R.id.textViewSignup);

        buttonSignin.setOnClickListener(this);
        textViewSignup.setOnClickListener(this);
    }

    private void userLogin() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            //dummy
            Toast.makeText(this, "What was that? Enter email address tot proceed", Toast.LENGTH_LONG).show();
            //stp function from executing further
            return;
        }
        if (TextUtils.isEmpty(password)) {
            //dummy
            Toast.makeText(this, "What was that? Enter password to proceed", Toast.LENGTH_LONG).show();
            //stp function from executing further
            return;
        }
        //show progress bar
        progressDialog.setMessage("Logging in now to firebase services...");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //progressDialog.dismiss();
                        if (task.isSuccessful()) {
                            //new user is successfully registered + logged in
                            //start profile activity here
                            //start with basic Toast
                            progressDialog.setMessage("Login successful! User now on firebase services...");
                            Toast.makeText(FirebaseLogin.this, "Welcome to Android + Firebase...", Toast.LENGTH_LONG).show();
                            //progressDialog.dismiss();
                            finish();
                            startActivity(new Intent(getApplicationContext(), FirebaseProfile.class));
                            //stp function from executing further
                            //return;
                            //finish();
                        } else {
                            progressDialog.setMessage("Failed to login to firebase services...");
                            Toast.makeText(FirebaseLogin.this, "Failed to create user", Toast.LENGTH_LONG).show();
                            //stp function from executing further
                            progressDialog.dismiss();
                            //progressDialog.cancel();
                            //finish();
                            return;
                        }
                    }
                });
    }

    @Override
    public void onClick(View view){
        if (view == buttonSignin) {
            userLogin();
        }

        if (view == textViewSignup){
            finish();
            startActivity(new Intent(this, FirebaseActivity.class));
        }
    }
}

