package com.example.pzzz.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.pzzz.Data.Model.Producto;
import com.example.pzzz.Data.datamanager.DataManagerEntityArticulo;
import com.example.pzzz.Presenter.AdapterArticulos;
import com.example.pzzz.R;
import com.example.pzzz.Router.App_ApiRoute;
import com.example.pzzz.Interactor.Network.ServiceArticulos;
import com.example.pzzz.Interactor.Response.ArticulosResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ArticulosAll extends AppCompatActivity {

    RecyclerView recyclerView;
    private List<ArticulosResponse> articulosResponseList;
    Producto producto = new Producto();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        fillList();


    }

    private void init() {
        setContentView(R.layout.activity_articulos);
        recyclerView = findViewById(R.id.recyclear_Articulos);


    }

    private void fillList() {





        getPosts(new Callback<List<ArticulosResponse>>() {
            @Override
            public void onResponse(Call<List<ArticulosResponse>> call,
                                   Response<List<ArticulosResponse>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "algo tronó más", Toast.LENGTH_LONG).show();
                    return;
                }



                articulosResponseList = response.body();
                DataManagerEntityArticulo dataManager = new DataManagerEntityArticulo();
                List<Producto> model = new ArrayList<>();

                for (ArticulosResponse pResponse : articulosResponseList) {


                    producto.setFolio(pResponse.getFolio());
                    producto.setTitulo(pResponse.getTitulo());
                    producto.setText(pResponse.getText());
                    producto.setCategoria(pResponse.getCategoria());
                    producto.setPrecio(pResponse.getPrecio());
                    producto.setImg(pResponse.getImg());


                    /*postModel.setId(new Long(pResponse.getId()));
                    postModel.setUserId(new Long(pResponse.getUserId()));
                    postModel.setTitle(pResponse.getTitle());
                    postModel.setText(pResponse.getText());

                    model.add(postModel);*/
                   model.add(producto);

                }


                //dataManager.saveArticulos(model);


               AdapterArticulos adapter = new AdapterArticulos(articulosResponseList, getApplicationContext());
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recyclerView.setAdapter(adapter);

            }
            @Override
            public void onFailure(Call<List<ArticulosResponse>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"algo tronó",Toast.LENGTH_SHORT).show();
            }


        });
    }

    private void getPosts(Callback<List<ArticulosResponse>> callback) {

        Retrofit retrofit = App_ApiRoute.getRetrofit();
        ServiceArticulos.ArticuloService postService = retrofit.create(ServiceArticulos.ArticuloService.class);

        Call<List<ArticulosResponse>> call = postService.getArticulos();

        call.enqueue(callback);


    }

    private void deletePost(int id){

        Retrofit retrofit = App_ApiRoute.getRetrofit();
        ServiceArticulos.ArticuloService postService = retrofit.create(ServiceArticulos.ArticuloService.class);

        Call<ArticulosResponse> call = postService.deleteArticulo(id);
        call.enqueue(new Callback<ArticulosResponse>() {
            @Override
            public void onResponse(Call<ArticulosResponse> call, Response<ArticulosResponse> response) {
                Toast.makeText(getApplicationContext(),"Articulo Eliminado", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<ArticulosResponse> call, Throwable t) {

            }
        });


    }




}
