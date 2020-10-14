package com.example.androidfoodxpress.ui.foodlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.example.androidfoodxpress.Adapter.MyFoodListAdapter;
import com.example.androidfoodxpress.Common.Common;
import com.example.androidfoodxpress.Model.FoodModel;
import com.example.androidfoodxpress.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class FoodListFragment extends Fragment {

    private FoodListViewModel sendViewModel;
    Unbinder unbinder;
    @BindView(R.id.recycler_food_list)
    RecyclerView recycler_food_list;
    LayoutAnimationController layoutAnimationController;
    MyFoodListAdapter adapter;
    private Object FoodListViewModel;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        sendViewModel= ViewModelProviders.of(this).get(FoodListViewModel.class);
        View root = inflater.inflate(R.layout.food_list_fragment, container, false);
        unbinder = ButterKnife.bind(this, root);
        initViews();
        sendViewModel.getMutableLiveDataFoodList().observe(getViewLifecycleOwner(), new Observer<List<FoodModel>>() {
            @Override
              public void onChanged(List<FoodModel> foodModels) {
                adapter=new MyFoodListAdapter(getContext(),foodModels);
                recycler_food_list.setAdapter(adapter);
                recycler_food_list.setLayoutAnimation(layoutAnimationController);

            }
        });
        return root;
    }

    private void initViews() {

        ((AppCompatActivity)getActivity())
                .getSupportActionBar()
                .setTitle(Common.categorySelected.getName());
        recycler_food_list.setHasFixedSize(true);
        recycler_food_list.setLayoutManager(new LinearLayoutManager(getContext()));
        layoutAnimationController= AnimationUtils.loadLayoutAnimation(getContext(),R.anim.layout_item_from_left);
    }


}
