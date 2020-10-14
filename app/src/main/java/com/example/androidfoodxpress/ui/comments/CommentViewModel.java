package com.example.androidfoodxpress.ui.comments;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.androidfoodxpress.Model.CommentModel;
import com.example.androidfoodxpress.Model.FoodModel;

import java.util.List;

public class CommentViewModel extends ViewModel {
    private MutableLiveData<List<CommentModel>>mutableLiveDataFoodList;

    public CommentViewModel() {
        mutableLiveDataFoodList=new MutableLiveData<>();

    }

    public MutableLiveData<List<CommentModel>> getMutableLiveDataFoodList() {
        return mutableLiveDataFoodList;
    }
    public void setCommentList(List<CommentModel> commentList)
    {
        mutableLiveDataFoodList.setValue(commentList);
    }
}
