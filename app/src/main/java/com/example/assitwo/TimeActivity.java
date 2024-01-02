package com.example.assitwo;

import androidx.appcompat.app.AppCompatActivity;


import com.android.volley.Request;
import com.android.volley.RequestQueue;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import android.content.Context;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class TimeActivity extends AppCompatActivity {
    private final String url = "http://worldtimeapi.org/api/timezone";
    private RequestQueue queue;
    private Button time;
    private EditText country;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        time = (Button) findViewById(R.id.buttontime);
        txtResult = findViewById(R.id.textViewresult);
        country = (EditText) findViewById(R.id.countrytext);
        queue = Volley.newRequestQueue(this);


    time.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View v){
        getTime();
    }
    });
}

    private void getTime() {
        String cityName = country.getText().toString().trim();
        if (cityName.isEmpty()) {
            txtResult.setText("Please enter a country name");
        } else {
            String str = url + "?q=" + cityName;
            StringRequest stringRequest = new StringRequest(Request.Method.GET, str,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                               JSONObject Time = jsonObject.getJSONObject("time");
                                txtResult.setText("The Time in " + cityName + " is : " +Time);
//                                InputMethodManager input = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//                                input.hideSoftInputFromWindow(view.getWindowToken(), 0);
                            } catch (JSONException exception) {
                                exception.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(TimeActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                }
            });

            queue.add(stringRequest);
        }
    }
}