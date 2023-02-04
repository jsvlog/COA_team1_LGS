package com.example.coa_team1_lgs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private Animation animation, animation2;
    private EditText emailLogin, passwordLogin;
    private CheckBox checkBox;
    private TextView loginRegister;
    private Button loginButton;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailLogin = findViewById(R.id.emailLogin);
        passwordLogin = findViewById(R.id.passwordLogin);
        checkBox = findViewById(R.id.checkboxLogin);
        loginRegister = findViewById(R.id.loginRegister);
        loginButton = findViewById(R.id.loginButton);

        mAuth = FirebaseAuth.getInstance();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginCredential();
            }
        });
        loginRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Register.class);
                startActivity(intent);
            }
        });
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    passwordLogin.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    passwordLogin.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

    }

    private void loginCredential() {
        String email = emailLogin.getText().toString();
        String password = passwordLogin.getText().toString();

        if (email.isEmpty()){
            emailLogin.setError("input email");
        }else if (password.isEmpty()){
            passwordLogin.setError("input password");
        }else{
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(MainActivity.this, "Successfully login", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this,Dashboard.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(MainActivity.this, "error:" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }





}