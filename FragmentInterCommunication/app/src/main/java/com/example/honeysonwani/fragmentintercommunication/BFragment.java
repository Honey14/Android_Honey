package com.example.honeysonwani.fragmentintercommunication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

public class BFragment extends Fragment{
    private static final String KEY_COUNTRIES = "nameofcountries";
    public static BFragment newInstance(ArrayList<String> nameofcountries) {
//step 9 create arraylist instance and put the key,value in bundle
        Bundle args = new Bundle();
        args.putStringArrayList(KEY_COUNTRIES,nameofcountries);
        BFragment fragment = new BFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View v =inflater.inflate(R.layout.fragment_b,container,false);
        return v;
    }
//step 10 inflate ui
    @Override
    public void onViewCreated(View v, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);
//step 11 receive the bundle and get the array string here
        Bundle bundle = getArguments();
        ArrayList<String> nameofcountries = bundle.getStringArrayList(KEY_COUNTRIES);

        TextView  datareceived = v.findViewById(R.id.datareceivedtextview);
        TextView  datareceivedtextview2 = v.findViewById(R.id.datareceivedtextview2);
        TextView datareceivedtextview3 = v.findViewById(R.id.datareceivedtextview3);
//step 12 lastly, set the index to corresponding text views
        datareceived.setText(nameofcountries.get(0));
        datareceivedtextview2.setText(nameofcountries.get(1));
        datareceivedtextview3.setText(nameofcountries.get(2));
    }
}
