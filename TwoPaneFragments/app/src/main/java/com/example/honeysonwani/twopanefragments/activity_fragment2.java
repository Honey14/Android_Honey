package com.example.honeysonwani.twopanefragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class activity_fragment2 extends Fragment {

    public static activity_fragment2 newInstance(String color) {
        Bundle args = new Bundle();
        args.putString("color", color);
        activity_fragment2 fragment = new activity_fragment2();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment2, container, false);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        View backgroundView = view.findViewById(R.id.fragmentview);
        Bundle bundle = getArguments();
        if (bundle != null) {
            String selectColor = bundle.getString("color");
//            backgroundView.setBackgroundColor(Color.parseColor(selectColor));
            backgroundView.setBackgroundColor(Color.parseColor(selectColor));
        }

    }

}
