package com.izax.devs.wrap;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new CountDownTimer(5000, 1000) {

            public void onTick(long millisUntilFinished) {
                //resutlado.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                Intent intent = new Intent(Splash.this , Home.class);
                startActivity(intent);
            }
        }.start();

    }
}