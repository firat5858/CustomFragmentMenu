package com.example.customfragmentmenu;

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class NavigationDrawerFragment extends Fragment {

    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    TextView tvEslNews,tvEslTv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragment_navigation_drawer_layout, container, false);
        setUpRecyclerView(v);

            tvEslNews = v.findViewById(R.id.textView);
            tvEslTv = v.findViewById(R.id.textView3);


            tvEslNews.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getActivity(), "tıklandı.", Toast.LENGTH_SHORT).show();
                }
            });


            Typeface title = Typeface.createFromAsset(getActivity().getAssets(), "Fonts/OpenSans-SemiBold.ttf");


            tvEslNews.setTypeface(title);
            tvEslTv.setTypeface(title);


        return v;

    }

   private void setUpRecyclerView(View v) {

        RecyclerView recyclerView= (RecyclerView) v.findViewById(R.id.drawerList);

        EmreAdapter adapter=new EmreAdapter(getActivity(), NavigationDrawerItem.getData());

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));



    }




    public void setUpNavigationDrawer(DrawerLayout drawerLayout, Toolbar toolbar){

       mDrawerLayout=drawerLayout;
        mDrawerToggle=new ActionBarDrawerToggle(getActivity(),mDrawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);

        mDrawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                mDrawerToggle.onDrawerSlide(drawerView, slideOffset);
            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });

        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });


    }
}
