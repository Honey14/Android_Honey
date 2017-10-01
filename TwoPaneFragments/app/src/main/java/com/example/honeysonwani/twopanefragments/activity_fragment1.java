package com.example.honeysonwani.twopanefragments;

import android.os.Bundle;
import android.support.annotation.Nullable;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.Button;
public class activity_fragment1 extends Fragment implements View.OnClickListener{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i("mom","on create fragment");
        View v = inflater.inflate(R.layout.fragment1,container,false);
                return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i("mom","on fragment  create ");
        Button buttonblack = view.findViewById(R.id.black);
        Button buttongreen = view.findViewById(R.id.green);
        Button buttonblue = view.findViewById(R.id.blue);
        buttonblack.setOnClickListener(this);
        buttongreen.setOnClickListener(this);
        buttonblue.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.black:
                onSelectColor("#000000");
                break;
            case R.id.green:
                onSelectColor("#00f000");
                break;
            case R.id.blue:
                onSelectColor("#0fffff");
                break;
        }
    }
    public void onSelectColor(String color){
        if(getActivity() instanceof Fragment1Listener){
            Fragment1Listener listener = (Fragment1Listener) getActivity();
            listener.onColorSelected(color);
        }
    }
    public interface Fragment1Listener{
        void onColorSelected(String color);
    }
}
