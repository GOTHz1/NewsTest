package com.strong.newstest;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    String TAG = "TAG";
    Button buttonMain;
    FrameLayout frameLayout;
    static WebView webView;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
       frameLayout=findViewById(R.id.lowFragment);
        buttonMain=findViewById(R.id.main_button);
        webView=findViewById(R.id.web_news);
        replaceFragment(new FirstFragment());
      //  frameLayout.setVisibility(View.INVISIBLE);
        buttonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new SecondFragment());
            }
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager
                .beginTransaction()
                .addToBackStack(null)
                .replace(R.id.lowFragment,fragment);
        transaction.commit();

    }
    public static void startWeb(String Url){
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(Url);
    }

}
