package com.zeneo.tmdb.Fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zeneo.tmdb.Activities.DiscoverActivity;
import com.zeneo.tmdb.Adapters.PopularListAdapter;
import com.zeneo.tmdb.Models.Movies;
import com.zeneo.tmdb.R;
import com.zeneo.tmdb.util.GetResFromApi;
import com.zeneo.tmdb.util.InternetConnection;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiscoverTVFragment extends Fragment {


    RecyclerView recyclerView;
    LinearLayout layout,layout1;

    GetResFromApi res;
    String url= "";




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        url = getArguments().getString("url");

        View view = inflater.inflate(R.layout.fragment_tv, container, false);
        final int[] page = {1};
        recyclerView =(RecyclerView)view.findViewById(R.id.tvList);
        layout = (LinearLayout)view.findViewById(R.id.tv_content);
        layout1 = (LinearLayout)view.findViewById(R.id.tv_load);
        if(url.contains("page")){
            res = new GetResFromApi(recyclerView,getContext(), url+ page[0],"toptv","list",layout,layout1,"toptv");
        } else {
            res = new GetResFromApi(recyclerView,getContext(), url,"toptv","list",layout,layout1,"toptv");
        }
        if(new InternetConnection().chechInternet(getContext())){
            res.clearData();
            res.getDetails();
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                    if (dy > 0 && !recyclerView.canScrollVertically(View.FOCUS_DOWN)){
                        page[0]++;
                        res.setUrl(url+ page[0]);
                        res.setRefreshed(true);
                        res.getDetails();
                    }
                }
            });
        }else {
            final View view1 = LayoutInflater.from(getContext()).inflate(R.layout.no_internet,null);
            TextView tryAgain= view1.findViewById(R.id.tryagainbtn);
            tryAgain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (new InternetConnection().chechInternet(getContext())){
                        layout.removeAllViews();
                        layout.addView(recyclerView);
                        res.getDetails();
                    }else {
                        layout.removeAllViews();
                        layout.addView(view1);
                    }

                }
            });
            view1.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            layout.removeAllViews();
            layout.addView(view1);
        }

        return view;
    }

}
