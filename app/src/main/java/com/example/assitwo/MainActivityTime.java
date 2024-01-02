package com.example.assitwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivityTime extends AppCompatActivity {
    private Button buttonlogin;
    private Button buttonRegester;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_time);
        buttonlogin = (Button) findViewById(R.id.button3);
        buttonRegester = (Button) findViewById(R.id.button4);
        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivitylogin();

            }
        });

        buttonRegester.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityRegester();

            }
        });
    }

    public void openActivitylogin(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
    public void openActivityRegester(){
        Intent intent = new Intent(this, RegesterActivity.class);
        startActivity(intent);
    }
}
