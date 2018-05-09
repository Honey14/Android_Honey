package com.example.honeysonwani.loginwithfirebase;

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

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.sign_in)
    Button sign_in;
//    @BindView(R.id.reset_pass)
//    Button reset_pass;
    @BindView(R.id.sign_up)
    Button sign_up;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        auth = FirebaseAuth.getInstance();
        if(auth.getCurrentUser() !=null){
//            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
//            startActivity(intent);
            Toast.makeText(LoginActivity.this,"User not null",Toast.LENGTH_SHORT).show();
        }
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email_id = email.getText().toString().trim();
                String password_here = password.getText().toString().trim();
                if(TextUtils.isEmpty(email_id)){
                    email.setError("Email Empty");
                }
                if(TextUtils.isEmpty(password_here)){
                    password.setError("Password Wrong");
                }else{
                    auth.signInWithEmailAndPassword(email_id,password_here).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                if(password.length()> 6){
                                    Toast.makeText(LoginActivity.this,"Please enter password at least 6 characters",Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    Toast.makeText(LoginActivity.this,"Authentication Failed",Toast.LENGTH_SHORT).show();
                                }
                            }
                            else{
                                startActivity(new Intent(LoginActivity.this,WelcomeActivity.class));
                                finish();
                            }
                        }
                    });
                }

            }
        });
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                //sign up for login activity
            }
        });
//        reset_pass.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // start reset password resent password
//            }
//        });

    }
}
