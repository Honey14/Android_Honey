package com.example.honeysonwani.threepanefragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
//protected void onCreate(Bundle savedInstanceState) {
//    super.onCreate(savedInstanceState);
//    setContentView(R.layout.activity_fragment);
//
//    FragmentManager fm = getSupportFragmentManager();
//    Fragment fragment = fm.findFragmentById(R.id.fragmentcontainer);
//
//    if (fragment == null) {
//        fragment = new Fragment();
//        fm.beginTransaction()
//                .replace(R.id.fragmentcontainer, new CrimeListFragment())
//                .commit();
//    }}

}
