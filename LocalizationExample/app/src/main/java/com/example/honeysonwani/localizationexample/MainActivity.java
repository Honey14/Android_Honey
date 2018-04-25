package com.example.honeysonwani.localizationexample;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    RadioButton radioButton1,radioButton2;

//    @Override
//    protected void onResume() {
//        super.onResume();
//        radioButton2.setChecked(false);
//        radioButton1.setChecked(false);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2); //2 radio buttons to choose the language
        radioButton1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                radioButton2.setChecked(false);
                String languageToLoad  = "en_US";
                Locale locale = new Locale(languageToLoad);
                Locale.setDefault(locale);
                Resources resources = getResources();
                DisplayMetrics m = resources.getDisplayMetrics();
                Configuration conf = resources.getConfiguration();
                conf.locale = locale;
                resources.updateConfiguration(conf,m);
                Intent intent = new Intent(MainActivity.this, LanguageActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                //one way of implementing
            }
        });
        radioButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                radioButton1.setChecked(false);
                String languageToLoad  = "hi";
                Locale locale = new Locale(languageToLoad);
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getApplicationContext().getResources().updateConfiguration(config,getResources().getDisplayMetrics());
                Intent intent = new Intent(MainActivity.this, LanguageActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                //second way of implementing
            }
        });

    }
}
