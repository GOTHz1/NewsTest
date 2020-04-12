package com.strong.newstest;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.strong.newstest.Adapter.NewsAdapter;
import com.strong.newstest.Bean.News;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SecondFragment extends Fragment {

    protected RecyclerView recyclerView;
    String TAG="TAG";
    Context context;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_second2,container,false);
        recyclerView=view.findViewById(R.id.list_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        context=getContext();
        NewsAdapter adapter=new NewsAdapter(getContext(),getNews());
        recyclerView.setAdapter(adapter);
        return view;
    }


    private List<News> getNews(){
        Log.d(TAG, "getNews ");
        List<News> newsList=new ArrayList<>();
        for (int i=0;i<5;i++) {
            News news=new News();
            news.setTitle("好好学习");
            news.setNewPicUrl("https://s1.ax1x.com/2020/03/20/82JDyj.jpg");
            news.setWebUrl("https://github.com/GOTHz1");
            Log.d(TAG, "get image ");
            Log.d(TAG,news.getTitle());
            newsList.add(news);
        }
        return newsList;
    }



}
