package com.example.pawan.complaintportal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.AuthFailureError;
import com.android.volley.TimeoutError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.CookieHandler;
import java.net.CookieManager;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText username,password,data;
    private Button buttonLogin;
    TextView text;
    String check;
    //private TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //t  = (TextView) findViewById(R.id.invalid);
        username = (EditText) findViewById(R.id.editUsename);
        password = (EditText) findViewById(R.id.editPassword);
        text=(TextView)findViewById(R.id.text);
        data=(EditText)findViewById(R.id.entered_data);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(this);
        check=captcha();
    }
    public String captcha(){
        Random rn = new Random();
        int[] i=new int[4];
        for(int j=0;j<4;j++) {
            i[j] = Math.abs(rn.nextInt() % 10);
        }
        String s1=" "+i[0]+" "+i[1]+" "+i[2]+" "+i[3];
        text.setText(s1);
        String s2=""+i[0]+""+i[1]+""+i[2]+""+i[3];
        return s2;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.icon){
            return true;}

        return super.onOptionsItemSelected(item);
    }

    private void login(){
        final String user=username.getText().toString();
        String pass=password.getText().toString();
        String url="http://192.168.43.253:8000/default/login.json?userid="+ user +"&password="+pass;
        Intent intent = new Intent(getApplicationContext(), Home.class);
        startActivity(intent);
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        // Result handling
//                        try {
//                            JSONObject j_respose = new JSONObject(response);
//                            String message = j_respose.getString("success");
//                            //Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
//                            if(message == "true") {
//                                String e_data = data.getText().toString().trim();
//                                if(check.equals(e_data)) {
//                                    Intent intent = new Intent(getApplicationContext(), Home.class);
//                                    startActivity(intent);
//                                }
//                                else{
//                                    check=captcha();
//                                    Toast.makeText(MainActivity.this," Enter Correct Captcha", Toast.LENGTH_SHORT).show();
//                                }
//                            }
//                            else {
//                                //t.setText("Invalid Username/Password");
//                                Toast.makeText(MainActivity.this, "Invalid Username and /or Password", Toast.LENGTH_LONG).show();
//                            }
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//                // Error handling
//                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_LONG).show();
//                error.printStackTrace();
//
//
//
//            }
//        });
//
//// Add the request to the queue
//        Volley.newRequestQueue(this).add(stringRequest);
//        CookieManager cookieManager = new CookieManager();
//        CookieHandler.setDefault(cookieManager);
    }

    @Override
    public void onClick(View v) {
        if(v == buttonLogin){
           login();
        }
    }
}