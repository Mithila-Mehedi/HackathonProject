package com.example.hackathonproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;


public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText signUpEmail,signUpPassword;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        this.setTitle("Sign up");

        mAuth = FirebaseAuth.getInstance();

        progressBar= findViewById(R.id.progressbarId);

        signUpEmail= findViewById(R.id.SignUpEmailEditTextId);
        signUpPassword= findViewById(R.id.SignUpPasswordEditTextId);
        Button signUpButton = findViewById(R.id.SignUpButtonId);
        TextView signUpTextView = findViewById(R.id.SignInTextViewId);

        signUpTextView.setOnClickListener(this);
        signUpButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.SignUpButtonId:
                UserRegister();
                break;
            case  R.id.SignInTextViewId:
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void UserRegister() {

        String email=signUpEmail.getText().toString().trim();
        final String password=signUpPassword.getText().toString().trim();

        //checking email validity
        if (email.isEmpty()) {
            signUpEmail.setError("Enter an email");
            signUpEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            signUpEmail.setError("Enter a valid email address");
            signUpEmail.requestFocus();
            return;
        }

        //checking password validity
        if (password.isEmpty()) {
            signUpPassword.setError("Enter a password");
            signUpPassword.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        if (password.length() < 6) {
            signUpPassword.setError("Minimum length of password should be 6");
            signUpPassword.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);

                if (task.isSuccessful()) {
                    startActivity(new Intent(SignUpActivity.this,LogInActivity.class));
                    finish();
                    Toast.makeText(getApplicationContext(),"Register is successfull", Toast.LENGTH_SHORT).show();
                    // Sign in success, update UI with the signed-in user's information
                } else {
                    if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                        startActivity(new Intent(SignUpActivity.this, LogInActivity.class));
                        finish();
                        Toast.makeText(getApplicationContext(),"User is already registered!\nplease sign in", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(),"Error:"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                    // If sign in fails, display a message to the user.
                }
            }
        });
    }
}
