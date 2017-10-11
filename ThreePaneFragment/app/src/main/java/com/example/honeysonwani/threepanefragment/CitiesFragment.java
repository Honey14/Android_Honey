package com.example.honeysonwani.threepanefragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

public class CitiesFragment extends Fragment{
    public static final String KEY_CITIES = "cities";
    public static CitiesFragment newInstance(ArrayList<String> cities) {
        
        Bundle args = new Bundle();
        args.putStringArrayList(KEY_CITIES, cities);
        CitiesFragment fragment = new CitiesFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cities,container,false);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = getArguments();
        ArrayList<String> cities = bundle.getStringArrayList(KEY_CITIES);
        Button buttonmumbai = view.findViewById(R.id.buttonmumbai);
        Button buttondelhi = view.findViewById(R.id.buttondelhi);
        Button buttongoa = view.findViewById(R.id.buttongoa);
        buttonmumbai.setText(cities.get(0));
        buttondelhi.setText(cities.get(1));
        buttongoa.setText(cities.get(2));
    }


}
