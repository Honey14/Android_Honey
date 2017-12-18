package com.example.honeysonwani.bottomnavigationview;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bnav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bnav = findViewById(R.id.bottomnav);
        BottomNavigationViewHelper.disableShiftMode(bnav);
        setUpBottomNavigation();
        if(savedInstanceState == null){
            loadHomeFragment();
        }

    }
    private void setUpBottomNavigation(){
        bnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.home:
                        loadHomeFragment();
                        return true;
                    case R.id.search:
                        loadSearchFragment();
                        return true;
                    case R.id.explore:
                        loadExploreFragment();
                        return true;
                    case R.id.Favorite:
                        loadFavoriteFragment();
                        return true;
                    case R.id.Setting:
                        loadSettingFragment();
                        return true;
                }
                return false;
            }
        });
    }
        private void loadHomeFragment(){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.framecontainer,new HomeFragment())
                    .commit();
    }
    private void loadSearchFragment(){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.framecontainer,new SearchFragment())
                    .commit();
    }

    private void loadExploreFragment(){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.framecontainer,new ExploreFragment())
                .commit();
    }
    private void loadFavoriteFragment(){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.framecontainer,new FavoriteFragment())
                .commit();
    }
    private void loadSettingFragment(){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.framecontainer,new SettingFragment())
                .commit();
    }
}
