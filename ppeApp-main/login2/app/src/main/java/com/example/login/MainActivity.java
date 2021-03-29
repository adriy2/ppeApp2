package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button buttonL;
    private Button buttonQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonL = (Button) findViewById(R.id.buttonListe);
        buttonL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListe();
            }
        });
        buttonQ = (Button) findViewById(R.id.buttonQRCode);
        buttonQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQrcode();
            }
        });
    }
    public void openListe() {
        Intent intent = new Intent(this, liste.class);
        startActivity(intent);
    }
    public void openQrcode() {
        Intent intent = new Intent(this, qrcode.class);
        startActivity(intent);
    }
}