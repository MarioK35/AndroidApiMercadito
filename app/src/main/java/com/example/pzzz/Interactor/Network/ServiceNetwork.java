package com.example.pzzz.Interactor.Network;


import com.example.pzzz.Interactor.Response.PostResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public class ServiceNetwork {

    public interface postService{

        @GET("posts")
        Call<List<PostResponse>> getPost();

    }
}
