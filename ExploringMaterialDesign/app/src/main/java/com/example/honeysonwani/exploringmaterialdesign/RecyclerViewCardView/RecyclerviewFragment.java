package com.example.honeysonwani.exploringmaterialdesign.RecyclerViewCardView;

import android.graphics.ColorSpace;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.honeysonwani.exploringmaterialdesign.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by honeysonwani on 4/26/2018.
 */

public class RecyclerviewFragment extends Fragment {
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        //layout integration here
        recyclerview1 = (RecyclerView) LayoutInflater.from(container.getContext()).inflate(R.layout.fragment_recyclerview,container,false);
        ButterKnife.bind(this,recyclerview1);
        // insert arrays to adapter
        String names[] = new String[ModelPizza.pizzas.length];
        for(int i=0;i<names.length;i++){
            names[i] = ModelPizza.pizzas[i].getName();
        }

        int imageids[] = new int[ModelPizza.pizzas.length];
        for(int j=0;j<imageids.length;j++){
            imageids[j] = ModelPizza.pizzas[j].getImageResourceID();
        }
        GridLayoutManager manager = new GridLayoutManager(getContext(),2);
        recyclerview1.setLayoutManager(manager);
        //set the adapter
        RecyclerviewAdapter adapter = new RecyclerviewAdapter(names,imageids);
        recyclerview1.setAdapter(adapter);
        return recyclerview1;
    }

}
