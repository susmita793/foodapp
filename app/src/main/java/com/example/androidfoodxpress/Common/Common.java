package com.example.androidfoodxpress.Common;

import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.widget.TextView;

import com.example.androidfoodxpress.Model.CategoryModel;
import com.example.androidfoodxpress.Model.FoodModel;
import com.example.androidfoodxpress.Model.UserModel;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Common {
    public static final String USER_REFERENCES = "User";
    public static final String POPULAR_CATEGORY_REF ="MostPopular" ;
    public static final String BEST_DEALS_REF = "BestDeals";
    public static final int DEFAULT_COLUMN_COUNT =0 ;
    public static final int FULL_WIDTH_COLUMN = 1;
    public static final String CATEGORY_REF = "Category";
    public static final String COMMENT_REF ="Comments" ;
    public static UserModel currentUser;

    public static CategoryModel categorySelected;
    public static FoodModel selectedfood;


    public static void setSnapString(String welcome, String name, TextView textView) {
        SpannableStringBuilder builder=new SpannableStringBuilder();
        builder.append(welcome);
        SpannableString spannableString=new SpannableString(name);
        StyleSpan boldSpan=new StyleSpan(Typeface.BOLD);
        spannableString.setSpan(boldSpan,0,name.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        builder.append(spannableString);
        textView.setText(builder,TextView.BufferType.SPANNABLE);
    }



    }

