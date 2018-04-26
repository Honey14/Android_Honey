package com.example.honeysonwani.exploringmaterialdesign.ViewPagerTabLayout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.honeysonwani.exploringmaterialdesign.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabFragment extends Fragment {
    Unbinder unbinder;
    @BindView(R.id.textview)
    TextView text;

    public TabFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = LayoutInflater.from(container.getContext()).inflate(R.layout.fragment_tab,container,false);
        unbinder = ButterKnife.bind(this,v);
        text.setText(R.string.hello_blank_fragment);
        return v;
    }
}
