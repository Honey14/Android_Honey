package com.example.honeysonwani.threepanefragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class CountryFragment extends Fragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_country,container,false);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i("mom","on fragment  create ");
        Button buttonindia = view.findViewById(R.id.buttonindia);
        Button buttonnewyork = view.findViewById(R.id.buttonnewyork);
        Button buttonlasvegas = view.findViewById(R.id.buttonlasvegas);
        buttonindia.setOnClickListener(this);
        buttonnewyork.setOnClickListener(this);
        buttonlasvegas.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        fragmentListener listener = (fragmentListener) getActivity();
        if(listener!=null){
        switch(view.getId()){
            case R.id.buttonindia:
            listener.onCountrySelected("india");
                break;
            case R.id.buttonnewyork:
                listener.onCountrySelected("new york");
                break;
            case R.id.buttonlasvegas:
                listener.onCountrySelected("maldives");
                break;
        }}
    }
    public interface fragmentListener{
        public void onCountrySelected(String country);
    }
}
