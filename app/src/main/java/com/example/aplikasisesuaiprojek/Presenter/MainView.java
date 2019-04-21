package com.example.aplikasisesuaiprojek.Presenter;

import com.example.aplikasisesuaiprojek.model.PostItem;

import java.util.List;

public interface MainView {
    void onSucces(List<PostItem> postItemList);

    void onError(String errorMessage);

    void onFailure(String failureMessage);
}
