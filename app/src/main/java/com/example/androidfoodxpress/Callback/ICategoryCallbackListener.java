package com.example.androidfoodxpress.Callback;

import com.example.androidfoodxpress.Model.BestDealModel;
import com.example.androidfoodxpress.Model.CategoryModel;

import java.util.List;

public interface ICategoryCallbackListener {
    void onCategoryLoadSuccess(List<CategoryModel> categoryModelList);
    void onCategoryLoadFailed(String message);
}
