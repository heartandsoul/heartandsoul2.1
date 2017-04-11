package com.heartandsoulcafe.heartandsoul;

import android.content.Intent;
import android.os.Bundle;

import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.common.api.GoogleApiClient;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FragmentTransaction fragmentTransaction;
    DrawerLayout drawer;

    Toolbar toolbar;
    ImageButton ImageBtn;


    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Home");




        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);




        final TextView welcomeLink = (TextView) findViewById(R.id.tvWelcome);
        welcomeLink.setOnClickListener(new View.OnClickListener()

                                       {
                                           @Override
                                           public void onClick(View v) {
                                               Intent welcomeIntent = new Intent(HomeActivity.this, WelcomeActivity.class);
                                               HomeActivity.this.startActivity(welcomeIntent);
                                           }
                                       }

        );



    }

    @Override
    public void onBackPressed() {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_1:
                Toast.makeText(HomeActivity.this, "You are In Login page", Toast.LENGTH_SHORT).show();

                break;
            case R.id.menu_2:
                Toast.makeText(HomeActivity.this, "You are Logged out successfully!", Toast.LENGTH_SHORT).show();

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        if (id == R.id.nav_home) {
            homeFragment hmFragment = new homeFragment();
            fragmentManager.beginTransaction().replace(R.id.relative_layout_for_fragment, hmFragment, hmFragment.getTag()).commit();
            getSupportActionBar().setTitle("Home");

        } else if (id == R.id.nav_menus) {
            menuFragment mnFragment = new menuFragment();
            fragmentManager.beginTransaction().replace(R.id.relative_layout_for_fragment, mnFragment, mnFragment.getTag()).commit();
            getSupportActionBar().setTitle("Menus");

       } else if (id == R.id.nav_location) {
         locationFragment locFragment = new locationFragment();
            fragmentManager.beginTransaction().replace(R.id.relative_layout_for_fragment, locFragment, locFragment.getTag()).commit();
            getSupportActionBar().setTitle("Location");

        } else if (id == R.id.nav_contact) {
            contactFragment cntFragment = new contactFragment();
            fragmentManager.beginTransaction().replace(R.id.relative_layout_for_fragment, cntFragment, cntFragment.getTag()).commit();
            getSupportActionBar().setTitle("Contact");

        }
        else if (id == R.id.nav_feedback){

            startActivity(new Intent(getApplicationContext(), feedbackActivity.class));

        }

        else if (id == R.id.nav_special){

            startActivity(new Intent(getApplicationContext(), specialActivity.class));

        }

     /*   else if (id == R.id.nav_map){

            startActivity(new Intent(getApplicationContext(), Activity.class));

        }


     */


        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}





