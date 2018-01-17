package com.example.honeysonwani.fragmentintercommunication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FragmentA extends Fragment implements View.OnClickListener{
    FragmentCommunicator comm; //step 2 create an object of interface
    interface FragmentCommunicator{ //step 1 create interface
        void FromAtoB(String text);
    }
    Button sendData,sendDatafrombutton1,sendDatafrombutton2;
    EditText edittext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        comm = (FragmentCommunicator) getActivity(); //step 3 refer interface objet to subclass i.e mainactivity(polymorphism)
        edittext = view.findViewById(R.id.edittext);
        sendData = view.findViewById(R.id.sendData);
        sendDatafrombutton1 = view.findViewById(R.id.sendDatafrombutton1);
        sendDatafrombutton2 = view.findViewById(R.id.sendDatafrombutton2);
        sendData.setOnClickListener(this);
        sendDatafrombutton1.setOnClickListener(this);
        sendDatafrombutton2.setOnClickListener(this); //step 4 register buttons and inflate ui
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){ //step 5 calling the interface method using interface obj and setting
            // the value to pass in next fragment, go to main
            case R.id.sendData:
                comm.FromAtoB("Mumbai");
                break;
            case R.id.sendDatafrombutton1:
                comm.FromAtoB("New york");
                break;
            case R.id.sendDatafrombutton2:
                comm.FromAtoB("morocco");
                break;
        }
    }
}
