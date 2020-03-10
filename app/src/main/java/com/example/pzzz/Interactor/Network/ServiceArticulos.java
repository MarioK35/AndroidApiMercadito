package com.example.pzzz.Interactor.Network;

import com.example.pzzz.Data.Model.Producto;
import com.example.pzzz.Interactor.Response.ArticulosResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public class ServiceArticulos {

    public interface ArticuloService {
        @GET("api/Product")
        Call<List<ArticulosResponse>> getArticulos();

        @POST("api/Product")
        Call<ArticulosResponse> createPost(@Body ArticulosResponse producto);

        @PUT("/api/Product/{id}")
        Call<ArticulosResponse> editArticulo(@Path("id") int id, @Body ArticulosResponse articulosResponse);

        @DELETE("/api/Product/{id}")
        Call<ArticulosResponse> deleteArticulo(@Path("id") int id);
    }
}
