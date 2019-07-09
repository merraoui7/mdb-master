package com.zeneo.tmdb;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

public class Utility {

    public int convertDipToPixels(float dips , Context context)
    {
        return (int) (dips * context.getResources().getDisplayMetrics().density + 0.5f);
    }

    public int screenWidth(Context context ){
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public int calculateNoOfColumns(Context context, float columnWidthDp) { // For example columnWidthdp=180
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float screenWidthDp = displayMetrics.widthPixels / displayMetrics.density;
        int noOfColumns = (int) (screenWidthDp / columnWidthDp + 0.5); // +0.5 for correct rounding to int.
        return noOfColumns;
    }

}
