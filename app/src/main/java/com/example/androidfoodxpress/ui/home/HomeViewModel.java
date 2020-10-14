package com.example.androidfoodxpress.ui.home;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.androidfoodxpress.Callback.IBestDealCallbackListener;
import com.example.androidfoodxpress.Callback.IPopularCallbackListener;
import com.example.androidfoodxpress.Common.Common;
import com.example.androidfoodxpress.Model.BestDealModel;
import com.example.androidfoodxpress.Model.PopularCategoryModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends ViewModel implements IPopularCallbackListener, IBestDealCallbackListener {
    private MutableLiveData<List<PopularCategoryModel>> popularList;
    private MutableLiveData<String> messageError;
    private IPopularCallbackListener popularCallbackListener;
    private MutableLiveData<List<BestDealModel>>bestDealList;
    private IBestDealCallbackListener bestDealCallbackListener;


    public HomeViewModel() {
        popularCallbackListener = this;
        bestDealCallbackListener=this;

    }

    public MutableLiveData<List<BestDealModel>> getBestDealList() {
        if (bestDealList==null)
        {
            bestDealList=new MutableLiveData<>();
            messageError=new MutableLiveData<>();
            loadBestDealList();
        }
        return bestDealList;
    }

    private void loadBestDealList() {
        List<BestDealModel> tempList=new ArrayList<>();
        DatabaseReference bestDealRef= FirebaseDatabase.getInstance().getReference(Common.BEST_DEALS_REF);
        bestDealRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot itemSnapShot:snapshot.getChildren())
                {
                    BestDealModel model=itemSnapShot.getValue(BestDealModel.class);
                    tempList.add(model);
                }
                bestDealCallbackListener.onBestDealLoadSuccess(tempList);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                bestDealCallbackListener.onBestDealLoadFailed(error.getMessage());

            }
        });
    }

    public IPopularCallbackListener getiPopularCallbackListener() {
        return popularCallbackListener;
    }

    public MutableLiveData<List<PopularCategoryModel>> getPopularList() {
        if (popularList == null) {
            popularList=new MutableLiveData<>();
            messageError=new MutableLiveData<>();
            loadPopularList();

        }
        return popularList;
    }

    private void loadPopularList() {
        List<PopularCategoryModel> tempList=new ArrayList<>();
        DatabaseReference popularRef= FirebaseDatabase.getInstance().getReference(Common.POPULAR_CATEGORY_REF);
        popularRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot itemSnapShot:snapshot.getChildren())
                {
                    PopularCategoryModel model=itemSnapShot.getValue(PopularCategoryModel.class);
                    tempList.add(model);
                }
                popularCallbackListener.onPopularLoadSuccess(tempList);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                popularCallbackListener.onPopularLoadFailed(error.getMessage());

            }
        });
    }


    @Override
    public void onPopularLoadSuccess(List<PopularCategoryModel> popularCategoryModels) {
        popularList.setValue(popularCategoryModels);

    }

    @Override
    public void onPopularLoadFailed(String message) {
        messageError.setValue(message);


    }

    @Override
    public void onBestDealLoadSuccess(List<BestDealModel> bestDealModels) {
        bestDealList.setValue(bestDealModels);

    }

    @Override
    public void onBestDealLoadFailed(String message) {
        messageError.setValue(message);

    }
}