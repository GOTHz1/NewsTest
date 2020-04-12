package com.strong.newstest.Adapter;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.strong.newstest.Bean.News;
import com.strong.newstest.MainActivity;
import com.strong.newstest.R;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    String TAG="TAG";
    private List<News> mNewsList;
    Context mContext;
    public NewsAdapter(Context context,List<News> newsList) {
        mNewsList=newsList;
        mContext=context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView NewsPic;
        TextView title;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            Log.d(TAG, "ViewHolder: ");
            NewsPic=itemView.findViewById(R.id.news_image);
            title=itemView.findViewById(R.id.news_title_text);

        }
    }
    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: ");
        final News news=mNewsList.get(position);
        holder.title.setText(news.getTitle());
        Glide.with(mContext ).load(news.getNewPicUrl()).into(holder.NewsPic);
        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.startWeb(news.getWebUrl());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }


}
