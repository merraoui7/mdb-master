package com.zeneo.tmdb.Adapters;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zeneo.tmdb.Models.Discover;
import com.zeneo.tmdb.R;
import com.zeneo.tmdb.Utility;
import com.zeneo.tmdb.util.HttpHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;


public class DiscoverListAdapter extends RecyclerView.Adapter<DiscoverListAdapter.ViewHolder> {

    private Context context;
    private List<Discover> list;
    private List<String> imgList;

    public DiscoverListAdapter(Context context, List<Discover> list,List<String> imgList) {
        this.context = context;
        this.list = list;
        this.imgList = imgList;
    }

    @NonNull
    @Override
    public DiscoverListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_discover,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiscoverListAdapter.ViewHolder holder, int position) {

        holder.title.setText(list.get(position).getTitle());
        holder.year.setText(list.get(position).getYear());

        int nOfColumns = new Utility().calculateNoOfColumns(context,125);
        int screenWidth = new Utility().screenWidth(context);
        int margin = new Utility().convertDipToPixels(8,context);
        int itemWidth = (screenWidth-nOfColumns*margin)/nOfColumns;

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(itemWidth, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(margin/2,margin/2,margin/2,margin/2);
        holder.linearLayout.setLayoutParams(params);

        holder.imageView.setLayoutParams(new LinearLayout.LayoutParams(itemWidth, (int) (itemWidth*1.5)));

        holder.title.setMaxLines(2);
        holder.title.setEllipsize(TextUtils.TruncateAt.END);

        Glide.with(context).load(imgList.get(position)).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title;
        TextView year;
        LinearLayout linearLayout;
        private ViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.discImage);
            title = itemView.findViewById(R.id.discTitle);
            year = itemView.findViewById(R.id.discYear);
            linearLayout = (LinearLayout) imageView.getParent();

        }
    }


}
