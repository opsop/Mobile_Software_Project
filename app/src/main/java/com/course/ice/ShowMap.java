package com.course.ice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ShowMap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_map);

        MapsFragment mapsFragment = new MapsFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.mainFragment, mapsFragment, "main").commit();
    }
}