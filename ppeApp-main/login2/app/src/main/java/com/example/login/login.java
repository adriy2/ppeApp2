package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class login extends AppCompatActivity {

    TextInputEditText textInputEditText, textInputEditText2;
    Button ButtonLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textInputEditText = findViewById(R.id.login);
        textInputEditText2 = findViewById(R.id.mdp);


        ButtonLogin = findViewById(R.id.buttonlogin);
        ButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String login, mdp;
                login = String.valueOf(textInputEditText.getText());
                mdp = String.valueOf(textInputEditText2.getText());

                if(!login.equals("") && !mdp.equals("")) {

                        String[] field = new String[2];
                        field[0] = "login";
                        field[1] = "mdp";
                        String[] data = new String[2];
                        data[0] = login;
                        data[1] = mdp;
                        PutData putData;
                        putData = new PutData("http://172.16.106.40/ppe-appli/Controller/?login="+login+"&mdp="+mdp,  "GET", field, data);
                        if (putData.startPut()) {
                            if (putData.onComplete()) {
                                String result = putData.getResult();
                                if (result.equals("Login Success")) {
                                    Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                } else if (result.equals("Login Fail")) {
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                        startActivity(intent);
                                        finish();
                                    } else {
                                    Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                }
                            }

                    }
                }
                    else{
                    Toast.makeText(getApplicationContext(),"Ve",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
