package com.example.pzzz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;

import com.example.pzzz.R;
import com.example.pzzz.View.Home;

public class MainActivity extends AppCompatActivity {

    RelativeLayout splash;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();

    }

    public void init() {

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                splash.setVisibility(View.VISIBLE);
                init_home();
                finish();


            }
        };
        setContentView(R.layout.activity_main);
        splash = findViewById(R.id.splash);
        handler.postDelayed(runnable, 2500);

    }

    public void init_home() {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);


    }
}
