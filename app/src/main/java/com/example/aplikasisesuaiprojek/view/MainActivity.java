package com.example.aplikasisesuaiprojek.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.aplikasisesuaiprojek.Adapter.PostAdapter;
import com.example.aplikasisesuaiprojek.Presenter.MainPresenter;
import com.example.aplikasisesuaiprojek.Presenter.MainView;
import com.example.aplikasisesuaiprojek.R;
import com.example.aplikasisesuaiprojek.model.PostItem;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {
    private RecyclerView A;
    private PostAdapter adapter;
    private MainPresenter mainPresenter;
    private String print = "pretty";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        A = findViewById(R.id.rec_post);
        mainPresenter = new MainPresenter(this, this);
        mainPresenter.loadArtikel(print);
    }

    @Override
    public void onSucces(List<PostItem> postItemList) {
        adapter = new PostAdapter(getApplicationContext(), postItemList);
        A.setLayoutManager(new LinearLayoutManager(this));
        A.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onError(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFailure(String failureMessage) {
        Toast.makeText(this, failureMessage, Toast.LENGTH_SHORT).show();
    }
}
