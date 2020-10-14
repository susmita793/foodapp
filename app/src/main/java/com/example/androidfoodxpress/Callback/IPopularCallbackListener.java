package com.example.androidfoodxpress.Callback;

import com.example.androidfoodxpress.Model.PopularCategoryModel;

import java.util.List;

public interface IPopularCallbackListener {
    void onPopularLoadSuccess(List<PopularCategoryModel>popularCategoryModels);
    void onPopularLoadFailed(String message);
}
