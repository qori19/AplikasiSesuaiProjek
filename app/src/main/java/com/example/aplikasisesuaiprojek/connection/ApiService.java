package com.example.aplikasisesuaiprojek.connection;

import com.example.aplikasisesuaiprojek.model.PostResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("/list_propinsi.json")
    Call<PostResponse> getPost (@Path("print")String print);
}
