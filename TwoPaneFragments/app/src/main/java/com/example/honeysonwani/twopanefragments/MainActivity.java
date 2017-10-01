package com.example.honeysonwani.twopanefragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements activity_fragment1.Fragment1Listener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("mom","on create activity");
        setContentView(R.layout.activity_main);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment1Container,new activity_fragment1())
                .commit();
    }

    @Override
    public void onColorSelected(String color) {
        View fragment2Container = findViewById(R.id.fragment2Container);

        if (fragment2Container != null) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment2Container,activity_fragment2.newInstance(color))
                .commit();

    }
}}
