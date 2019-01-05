package com.example.dell.demo;

import android.content.ClipData;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout dl;
    private ActionBarDrawerToggle ad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dl = (DrawerLayout)findViewById(R.id.dd1);
        ad = new ActionBarDrawerToggle(this,dl,R.string.open,R.string.close);
        ad.setDrawerIndicatorEnabled(true);
        dl.addDrawerListener(ad);
        ad.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView nv =(NavigationView)findViewById(R.id.nav_view);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();

                if (id == R.id.setting){
                    Toast.makeText(MainActivity.this, "Settings",Toast.LENGTH_SHORT).show();
                }
                if (id == R.id.logout){
                    Toast.makeText(MainActivity.this, "logout",Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return ad.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }
}
