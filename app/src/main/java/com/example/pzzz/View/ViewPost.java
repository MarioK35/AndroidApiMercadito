package com.example.pzzz.View;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pzzz.R;

public class ViewPost extends AppCompatActivity {

    TextView txt_titulo, txt_desc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_post);
        init();


    }

    public void init() {
        //Intent intent = getIntent();

        txt_titulo.findViewById(R.id.text_post_titulo);
        txt_desc.findViewById(R.id.text_post_desc);
        /*txt_titulo.setText(intent.getStringExtra("titulo"));
        txt_desc.setText(intent.getStringExtra("texto"));*/

    }





    public void setTextPost(String a, String b) {
    txt_titulo.setText(a);
    txt_desc.setText(b);
}


}

