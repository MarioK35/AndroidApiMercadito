package com.example.pzzz.View;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pzzz.Data.datamanager.postModelDataManager;
import com.example.pzzz.Data.Model.postModel;
import com.example.pzzz.Presenter.CustomAdapter;
import com.example.pzzz.R;
import com.example.pzzz.Interactor.MiProyectoApp;
import com.example.pzzz.Interactor.Network.ServiceNetwork;
import com.example.pzzz.Interactor.Response.PostResponse;
import com.example.pzzz.Router.App_ApiRoute;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class TercerActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private List<PostResponse> postResponses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercer);
        recyclerView = findViewById(R.id.recycler_tercero);
        fillList();

    }


    private void fillList()
    {

        getPosts(new Callback<List<PostResponse>>() {
            @Override
            public void onResponse(Call<List<PostResponse>> call,
                                   Response<List<PostResponse>> response) {
                if(!response.isSuccessful())
                {
                    Toast.makeText(getApplicationContext(),"algo tronó más",Toast.LENGTH_SHORT).show();
                    return;
                }

                postResponses = response.body();
                postModelDataManager dataManager = new postModelDataManager();
                List<postModel> model = new ArrayList<>();

                for (PostResponse pResponse: postResponses) {
                    postModel postModel = new postModel();
                    postModel.setId(new Long(pResponse.getId()));
                    postModel.setUserId(new Long(pResponse.getUserId()));
                    postModel.setTitle(pResponse.getTitle());
                    postModel.setText(pResponse.getText());

                    model.add(postModel);
                }

                dataManager.savePosts(model);

                CustomAdapter adapter = new CustomAdapter(postResponses,getApplicationContext());
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<PostResponse>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"algo tronó",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getPosts(Callback<List<PostResponse>> callback)
    {
        Retrofit retrofit = MiProyectoApp.getRetrofit();
        ServiceNetwork.postService postService = retrofit.create(ServiceNetwork.postService.class);
        Call<List<PostResponse>> call = postService.getPost();
        call.enqueue(callback);
    }
}
