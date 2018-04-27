package com.example.honeysonwani.navigationview;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.nav_view)
    NavigationView nav_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getResources().getText(R.string.header));
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this,
                drawerLayout,
                toolbar,R.string.open,
                R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        nav_view.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else
        super.onBackPressed();
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent intent= null;
        switch (item.getItemId()){
            case R.id.blog:
            intent = new Intent(this,AboutActivity.class);
            break;
            case R.id.home:
                intent = new Intent(this,AboutActivity.class);
                break;
            case R.id.learn:
                intent = new Intent(this,AboutActivity.class);
                break;
            case R.id.contact:
                intent = new Intent(this,AboutActivity.class);
                break;
            case R.id.feedback:
                intent = new Intent(this,AboutActivity.class);
                break;
            case R.id.Rate_us:
                intent = new Intent(this,AboutActivity.class);
                break;
                default:
                    intent = new Intent(this,AboutActivity.class);
                    break;
        }
        if(intent!=null){
            startActivity(intent);
        }else{
            Toast.makeText(this,"failed to click",Toast.LENGTH_SHORT).show();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
