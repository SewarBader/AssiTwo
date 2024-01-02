package com.example.assitwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

public class LoginActivity extends AppCompatActivity {
   private Button login;
    private EditText username;
    private EditText password;

    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        username=(EditText)findViewById(R.id.usernamelogin);
        password=(EditText)findViewById(R.id.passwordlogin);
        login=(Button)findViewById(R.id.buttonlogin);
        sharedpreferences = getSharedPreferences("sharedprefrences",MODE_PRIVATE);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String logusername = username.getText().toString();
                String log2password = username.getText().toString();

                String userRegname=sharedpreferences.getString("username","");
                String passRegname=sharedpreferences.getString("password","");

                if(logusername.equals(userRegname)&&log2password.equals(passRegname)){
                    Intent intent = new Intent(LoginActivity.this, TimeActivity.class);
                    startActivity(intent);
                }


            }
        });
    }


}