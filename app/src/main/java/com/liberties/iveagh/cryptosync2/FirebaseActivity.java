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

public class FirebaseActivity extends AppCompatActivity implements View.OnClickListener {

        private Button buttonRegister;
        private EditText editTextEmail;
        private EditText editTextPassword;
        private TextView textViewSignin;

        private FirebaseAuth firebaseAuth;

        private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);

            firebaseAuth = FirebaseAuth.getInstance();

            if (firebaseAuth.getCurrentUser() != null){
                //profile actgivity here
                finish();
                startActivity(new Intent(getApplicationContext(), FirebaseProfile.class));
            }

            progressDialog = new ProgressDialog(this);

            buttonRegister = (Button) findViewById(R.id.buttonRegister);
            editTextEmail = (EditText) findViewById(R.id.editTextEmail);
            editTextPassword = (EditText) findViewById(R.id.editTextPassword);
            textViewSignin = (TextView) findViewById(R.id.textViewSignin);

            buttonRegister.setOnClickListener(this);
            textViewSignin.setOnClickListener(this);
        }

    private void registerUser() {
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
        progressDialog.setMessage("Registering user now to firebase services...");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //new user is successfully registered + logged in
                            //start profile activity here
                            //start with basic Toast
                            progressDialog.setMessage("Registering user now to firebase services...");
                            Toast.makeText(FirebaseActivity.this, "New user created", Toast.LENGTH_LONG).show();
                            progressDialog.dismiss();
                            //stp function from executing further
                            //return;
                            //finish();
                            finish();
                            startActivity(new Intent(getApplicationContext(), FirebaseProfile.class));
                        } else {
                            progressDialog.setMessage("Registering user now to firebase services...");
                            Toast.makeText(FirebaseActivity.this, "Failed to create user", Toast.LENGTH_LONG).show();
                            //stp function from executing further
                            progressDialog.dismiss();
                            //progressDialog.cancel();
                            //finish();
                            return;
                        }
                    }
                });
        //progressDialog.cancel();
    }

    @Override
    public void onClick(View view) {
        if (view == buttonRegister) {
            registerUser();
        } if (view == textViewSignin){
            // login()
            startActivity(new Intent(this, FirebaseLogin.class));
        }
    }
}