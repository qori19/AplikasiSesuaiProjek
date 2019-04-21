package com.example.aplikasisesuaiprojek.Presenter;

import android.content.Context;

import com.example.aplikasisesuaiprojek.connection.BaseApp;
import com.example.aplikasisesuaiprojek.model.PostResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {
    private Context context;
    private MainView mainView;

    public MainPresenter (Context context, MainView mainView){
        this.context = context;
        this.mainView = mainView;
    }
    public void loadArtikel(String print){
        BaseApp.service.getPost(print).enqueue(new Callback<PostResponse>() {
            @Override
            public void onResponse(Call<PostResponse> call, Response<PostResponse> response) {
                if (response.isSuccessful()){
                    mainView.onSucces(response.body().getPosts());
                } else {
                    mainView.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<PostResponse> call, Throwable t) {
                mainView.onFailure(t.getMessage());
            }
        });
    }
}
