package com.example.honeysonwani.exploringmaterialdesign;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.honeysonwani.exploringmaterialdesign.RecyclerViewCardView.RecyclerviewFragment;
import com.example.honeysonwani.exploringmaterialdesign.ViewPagerTabLayout.TabFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.view_pager)
    ViewPager view_pager;
    @BindView(R.id.tab_layout)
    TabLayout tab_layout;
    @BindView(R.id.toolbar)
    Toolbar toolbar1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar1);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Trends");
        toolbar1.setTitleTextColor(Color.WHITE);
        TabsInformation info = new TabsInformation(getSupportFragmentManager());
        view_pager.setAdapter(info);
        tab_layout.setupWithViewPager(view_pager);
    }

    public void OnClickDone(View view) {
        Snackbar snackbar = Snackbar.make(findViewById(R.id.coordinator),"You are Successful",Snackbar.LENGTH_LONG);
        snackbar.setAction("Undo", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //for any action to perform
                Toast.makeText(MainActivity.this,"Undone",Toast.LENGTH_SHORT).show();
            }
        });
        snackbar.show();
    }

    private class TabsInformation extends FragmentPagerAdapter{

        public TabsInformation(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new TabFragment();
                case 1:
                    return new RecyclerviewFragment();
                case 2:
                    return new TabFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                   return getResources().getText(R.string.Home);
                case 1:
                    return getResources().getText(R.string.About);
                case 2:
                    return getResources().getText(R.string.Blog);
            }
            return null;
        }
    }
}
