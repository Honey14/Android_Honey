package com.example.honeysonwani.threepanefragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CountryFragment.fragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.countrycontainer,new CountryFragment())
                .commit();
    }

    @Override
    public void onCountrySelected(String country) {
        ArrayList<String> cities = new ArrayList<>();
        switch (country){
            case "india":
                cities.add("cst");
                cities.add("karela");
                cities.add("new delhi");
                break;
            case "new york":
                cities.add("aa");
                cities.add("bb");
                cities.add("cc");
                break;
            case "maldives":
                cities.add("xx");
                cities.add("ya");
                cities.add("zz");
                break;
        } View citiescontainer = findViewById(R.id.citiescontainer);

        if (citiescontainer != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.citiescontainer,CitiesFragment.newInstance(cities))
                    .commit();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.countrycontainer,new CountryFragment())
                    .addToBackStack(null)
                    .commit();
        }

    }
}