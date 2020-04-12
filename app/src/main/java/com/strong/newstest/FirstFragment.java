package com.strong.newstest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class FirstFragment extends Fragment  {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_first2, container, false);
        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new SecondFragment());
            }
        });
    return view;
    }
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction transaction=fragmentManager
                .beginTransaction()
                .addToBackStack(null)
                .replace(R.id.lowFragment,fragment);
        transaction.commit();

    }

}
