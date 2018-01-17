package com.example.honeysonwani.fragmentintercommunication;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements FragmentA.FragmentCommunicator {
//step 6 implement interface
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragmentcontainer1,new FragmentA())
                .addToBackStack(null)
                .commit();

    }

    @Override
    public void FromAtoB(String text) { //step 7
        ArrayList<String> listofcountrytogo = new ArrayList<>();
        switch (text){ //create arraylist and add values to array that will go in fragment b textviews
            case "Mumbai":
                listofcountrytogo.add("To Pune");
                listofcountrytogo.add("To Kashmir");
                listofcountrytogo.add("To kolkata");
                break;
            case "New york":
                listofcountrytogo.add("to bali");
                listofcountrytogo.add("to dubai");
                listofcountrytogo.add("to mauritius");
                break;
            case "morocco":
                listofcountrytogo.add("to london");
                listofcountrytogo.add("to us");
                listofcountrytogo.add("to India");
                break;
        }
        getSupportFragmentManager() //step 8 refer fragment b and go to bfragment
                .beginTransaction()
                .replace(R.id.fragmentcontainer2, BFragment.newInstance(listofcountrytogo))
                .commit();
    }
}
