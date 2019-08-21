package com.example.customfragmentmenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpToolbar();

        setUpDrawer();


    }

    private void setUpToolbar(){

        toolbar= (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("NavDrawer Örnek");
        toolbar.setSubtitle("Örnek uygulama");


    }

    private void setUpDrawer(){

        NavigationDrawerFragment navFragment= (NavigationDrawerFragment) getFragmentManager().findFragmentById(R.id.fragment);
        DrawerLayout drawerLayout= (DrawerLayout) findViewById(R.id.drawerLayout);

        navFragment.setUpNavigationDrawer(drawerLayout, toolbar);



    }


}

