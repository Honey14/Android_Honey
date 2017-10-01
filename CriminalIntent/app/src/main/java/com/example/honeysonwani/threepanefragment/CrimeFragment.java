package com.example.honeysonwani.threepanefragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class CrimeFragment extends Fragment{
    Crime obj;
    TextView text2;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        obj = new Crime();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_crime,container,false);
        text2 = v.findViewById(R.id.text1);
        text2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //do notihng
            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                text2.setText(s.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //do nothing
            }
        });
        Button dateButton = v.findViewById(R.id.dateButton);
        dateButton.setText(obj.getMdate().toString());
        dateButton.setEnabled(false);
        CheckBox checkbox = v.findViewById(R.id.checkbox);
        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                obj.setSolved(b);
            }
        });
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
