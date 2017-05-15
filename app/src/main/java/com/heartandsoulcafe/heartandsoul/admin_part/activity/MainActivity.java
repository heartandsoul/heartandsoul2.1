package com.heartandsoulcafe.heartandsoul.admin_part.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.heartandsoulcafe.heartandsoul.R;
import com.heartandsoulcafe.heartandsoul.admin_part.helper.SQLiteHandler;
import com.heartandsoulcafe.heartandsoul.admin_part.helper.SessionManager;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    TextView txt;
    Intent i;
    private TextView txtName;
    private SQLiteHandler db;
    private SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar my_toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(my_toolbar);

        getSupportActionBar().setTitle("Admin Home");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtName = (TextView) findViewById(R.id.admin_name);
        Typeface myTypeface = Typeface.createFromAsset(getAssets(), "Pacifico.ttf");
        txt = (TextView) findViewById(R.id.tvMembers);
        txt.setTypeface(myTypeface);
        txt = (TextView) findViewById(R.id.tvBooking);
        txt.setTypeface(myTypeface);
        txt = (TextView) findViewById(R.id.tvFeeds);
        txt.setTypeface(myTypeface);
        txt = (TextView) findViewById(R.id.tvItems);
        txt.setTypeface(myTypeface);

        // SqLite database handler
        db = new SQLiteHandler(getApplicationContext());

        // session manager
        session = new SessionManager(getApplicationContext());

        if (!session.isLoggedIn()) {
            logoutUser();
        }

        // Fetching user details from SQLite
        HashMap<String, String> user = db.getUserDetails();

        String name = user.get("name");

        // Displaying the user details on the screen
        txtName.setText(name);


        View.OnClickListener listener1 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(MainActivity.this, member.class);
                startActivity(i);

            }
        };
        final TextView memberLink = (TextView) findViewById(R.id.tvMembers);
        memberLink.setOnClickListener(listener1);

        View.OnClickListener listener2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(MainActivity.this, booking.class);
                startActivity(i);

            }

        };
        final TextView bookingLink = (TextView) findViewById(R.id.tvBooking);
        bookingLink.setOnClickListener(listener2);

        View.OnClickListener listener3 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(MainActivity.this, feeds.class);
                startActivity(i);

            }

        };
        final TextView feedbackLink = (TextView) findViewById(R.id.tvFeeds);
        feedbackLink.setOnClickListener(listener3);


        View.OnClickListener listener4 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(MainActivity.this, items.class);
                startActivity(i);

            }

        };
        final TextView itemLink = (TextView) findViewById(R.id.tvItems);
        itemLink.setOnClickListener(listener4);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.admin_option, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_4:
                startActivity(new Intent(this, RegisterActivity.class));
                Toast.makeText(MainActivity.this, "You are In Admin Register page", Toast.LENGTH_SHORT).show();

                break;
            case R.id.menu_5:
                logoutUser();
                Toast.makeText(MainActivity.this, "You are in Admin Login page", Toast.LENGTH_SHORT).show();

        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Logging out the user. Will set isLoggedIn flag to false in shared
     * preferences Clears the user data from sqlite users table
     * */
    private void logoutUser() {
        session.setLogin(false);

        db.deleteUsers();

        // Launching the login activity
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();

    }
}
