package com.example.androidfoodxpress.Callback;


import com.example.androidfoodxpress.Model.BestDealModel;
import com.example.androidfoodxpress.Model.PopularCategoryModel;

import java.util.List;

public interface IBestDealCallbackListener {
    void onBestDealLoadSuccess(List<BestDealModel>bestDealModels);
    void onBestDealLoadFailed(String message);
}


