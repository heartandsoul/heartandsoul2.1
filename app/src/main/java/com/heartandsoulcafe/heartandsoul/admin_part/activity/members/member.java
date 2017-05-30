package com.heartandsoulcafe.heartandsoul.admin_part.activity.members;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.heartandsoulcafe.heartandsoul.R;
import com.heartandsoulcafe.heartandsoul.admin_part.activity.LoginActivity;
import com.heartandsoulcafe.heartandsoul.admin_part.activity.RegisterActivity;
import com.heartandsoulcafe.heartandsoul.admin_part.helper.SQLiteHandler;
import com.heartandsoulcafe.heartandsoul.admin_part.helper.SessionManager;

public class member extends AppCompatActivity {
    final static String urlAddress = "https://heartandsoul.000webhostapp.com/connect/showMembers.php";
    private SQLiteHandler db;
    private SessionManager session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);

        Toolbar my_toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(my_toolbar);


        final ListView lv = (ListView) findViewById(R.id.lv);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Downloader(member.this, urlAddress, lv).execute();
            }
        });


        db = new SQLiteHandler(getApplicationContext());

        // session manager
        session = new SessionManager(getApplicationContext());

        if (!session.isLoggedIn()) {
            logoutUser();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.admin_option, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home)
            finish();

        switch (item.getItemId()) {
            case R.id.menu_4:
                startActivity(new Intent(this, RegisterActivity.class));
                Toast.makeText(member.this, "You are In Admin Register page", Toast.LENGTH_SHORT).show();

                break;
            case R.id.menu_5:
                logoutUser();
                Toast.makeText(member.this, "You are in Admin Login page", Toast.LENGTH_SHORT).show();

        }
        return super.onOptionsItemSelected(item);
    }



    private void logoutUser() {
        session.setLogin(false);

        db.deleteUsers();

        Intent intent = new Intent(member.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
