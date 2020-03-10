package com.example.pzzz.View;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.pzzz.R;

public class Home extends AppCompatActivity {

    Button btn_home_articulos, btn_post, btn_post_articulos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        initEvents();
    }

    private void init() {

        Intent intent = getIntent();
        setContentView(R.layout.activity_home);

        btn_home_articulos = findViewById(R.id.btn_home_articulo);
        btn_post_articulos = findViewById(R.id.btn_post_articulo);

    }

    private void initEvents() {

        onClickArticulos();
        onClickPostArticulo();
    }



    public void onClickArticulos() {
        btn_home_articulos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent1 = new Intent(getApplicationContext(), ArticulosAll.class);
                startActivity(intent1);

            }
        });
    }

    public void onClickPostArticulo() {
        btn_post_articulos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent(getApplicationContext(), ArticulosPost.class);
                startActivity(intent1);

            }
        });
    }


}
