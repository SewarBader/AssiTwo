package com.example.assitwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegesterActivity extends AppCompatActivity {
    private Button regester;
    private EditText username;
    private EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regester);
        username=(EditText)findViewById(R.id.usernameRegester);
        password=(EditText)findViewById(R.id.passwordregester);
        regester=(Button)findViewById(R.id.buttonRegester);
        SharedPreferences sharedPreferences = getSharedPreferences("sharedprefrences",MODE_PRIVATE);
        regester.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String regusername = username.getText().toString();
                String regpassword = username.getText().toString();

                if(!regusername.isEmpty()&&!regpassword.isEmpty()) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("UserName", regusername);
                    editor.putString("Password", regpassword);
                    editor.apply();
                    Toast.makeText(RegesterActivity.this, "regester successful", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(RegesterActivity.this, "empty field", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}