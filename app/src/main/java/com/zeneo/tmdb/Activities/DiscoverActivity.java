package com.zeneo.tmdb.Activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.zeneo.tmdb.Fragments.DiscoverMovieFragment;
import com.zeneo.tmdb.Fragments.DiscoverTVFragment;
import com.zeneo.tmdb.Fragments.MoviesFragment;
import com.zeneo.tmdb.R;
import com.zeneo.tmdb.UI.CustomPagerAdapter;

public class DiscoverActivity extends AppCompatActivity {

    CustomPagerAdapter adapter;
    ViewPager viewPager;
    TabLayout tabLayout;
    String type = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        adapter = new CustomPagerAdapter(getSupportFragmentManager());
        viewPager = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tablt);

        type = getIntent().getStringExtra("type");
        if(type.equals("tv")){
            adapter.addFrag(new DiscoverTVFragment(),"Trending","https://api.themoviedb.org/3/trending/tv/week?api_key=5d173b53167711178472dc9d98603e31");
            adapter.addFrag(new DiscoverTVFragment(),"Popular","https://api.themoviedb.org/3/tv/popular?api_key=5d173b53167711178472dc9d98603e31&language=en-US&page=");
            adapter.addFrag(new DiscoverTVFragment(),"Top Rated","https://api.themoviedb.org/3/tv/top_rated?api_key=5d173b53167711178472dc9d98603e31&language=en-US&page=");
            adapter.addFrag(new DiscoverTVFragment(),"On The Air","https://api.themoviedb.org/3/tv/on_the_air?api_key=5d173b53167711178472dc9d98603e31&language=en-US&page=");
            adapter.addFrag(new DiscoverTVFragment(),"Airing Today","https://api.themoviedb.org/3/tv/airing_today?api_key=5d173b53167711178472dc9d98603e31&language=en-US&page=");
        } else {
            adapter.addFrag(new DiscoverMovieFragment(),"Trending","https://api.themoviedb.org/3/trending/movie/week?api_key=5d173b53167711178472dc9d98603e31");
            adapter.addFrag(new MoviesFragment(),"Popular","https://api.themoviedb.org/3/movie/popular?api_key=5d173b53167711178472dc9d98603e31&language=en-US&page=");
            adapter.addFrag(new MoviesFragment(),"Top Rated","https://api.themoviedb.org/3/movie/top_rated?api_key=5d173b53167711178472dc9d98603e31&language=en-US&page=");
            adapter.addFrag(new MoviesFragment(),"Upcoming","https://api.themoviedb.org/3/movie/upcoming?api_key=5d173b53167711178472dc9d98603e31&language=en-US&page=");
            adapter.addFrag(new MoviesFragment(),"Now Playing","https://api.themoviedb.org/3/movie/now_playing?api_key=5d173b53167711178472dc9d98603e31&language=en-US&page=");

        }

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}
