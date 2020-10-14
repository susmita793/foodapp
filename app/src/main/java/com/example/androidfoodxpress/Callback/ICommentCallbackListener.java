package com.example.androidfoodxpress.Callback;

import com.example.androidfoodxpress.Model.CommentModel;

import java.util.List;

public interface ICommentCallbackListener {
    void onCommentLoadSuccess(List<CommentModel>commentModels);
    void onCommentLoadFailed(String message);
}
