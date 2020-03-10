package com.example.pzzz.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.example.pzzz.Interactor.Network.ServiceArticulos;
import com.example.pzzz.Interactor.Response.ArticulosResponse;
import com.example.pzzz.R;
import com.example.pzzz.Router.App_ApiRoute;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ArticulosPost extends AppCompatActivity {

    EditText txt_titulo, txt_descripcion, txt_precio, txt_categoria, txt_img;
    TextView v_titulo, v_descripcion, v_precio, v_categoria;
    Button btn_summit;
    ImageView imageView;
    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        initEvents();


    }

    public void init() {

        setContentView(R.layout.activity_post_articulos);

        txt_titulo = findViewById(R.id.txt_titulo);
        txt_categoria = findViewById(R.id.txt_categoria);
        txt_descripcion = findViewById(R.id.txt_descripcion);
        txt_precio = findViewById(R.id.txt_Precio);
        txt_img = findViewById(R.id.txt_img);


        btn_summit = findViewById(R.id.btn_summit);



    }

    public void initEvents() {

        initValidation();
        onSummit();

    }

    public void initValidation() {

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        setValidation();

    }

    public void onSummit() {

        btn_summit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (awesomeValidation.validate()) {

                    createArticulo();
                    clearText();

                } else {

                    Toast.makeText(getApplicationContext(), "Campos no Validos", Toast.LENGTH_LONG).show();
                    clearText();
                }
            }
        });


    }


    public void clearText() {

       txt_titulo.setText("");
       txt_categoria.setText("");
       txt_descripcion.setText("");
       txt_precio.setText("");
       txt_img.setText("");

    }

    public void setValidation() {
        awesomeValidation.addValidation(this, R.id.txt_titulo, RegexTemplate.NOT_EMPTY, R.id.invalid_empty);
        awesomeValidation.addValidation(this, R.id.txt_categoria, RegexTemplate.NOT_EMPTY, R.id.invalid_emptydes);
        awesomeValidation.addValidation(this, R.id.txt_descripcion, RegexTemplate.NOT_EMPTY, R.id.invalid_emptydes);
        awesomeValidation.addValidation(this, R.id.txt_Precio, RegexTemplate.NOT_EMPTY, R.id.invalid_emptydes);
    }

    private void createArticulo(){

        ArticulosResponse articulo = new ArticulosResponse(txt_titulo.getText().toString()
                ,txt_categoria.getText().toString()
                ,txt_descripcion.getText().toString()
                ,txt_precio.getText().toString()
                ,txt_img.getText().toString());

        Retrofit retrofit = App_ApiRoute.getRetrofit();
        ServiceArticulos.ArticuloService postService = retrofit.create(ServiceArticulos.ArticuloService.class);

        Call<ArticulosResponse> call = postService.createPost(articulo);

        call.enqueue(new Callback<ArticulosResponse>() {
            @Override
            public void onResponse(Call<ArticulosResponse> call, Response<ArticulosResponse> response) {
                Intent intent1 = new Intent(getApplicationContext(), ArticulosAll.class);
                startActivity(intent1);

            }


            @Override
            public void onFailure(Call<ArticulosResponse> call, Throwable t) {

            }
        });

    }


}
