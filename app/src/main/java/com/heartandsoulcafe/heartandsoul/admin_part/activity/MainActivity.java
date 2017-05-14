package com.heartandsoulcafe.heartandsoul.admin_part.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.heartandsoulcafe.heartandsoul.R;
import com.heartandsoulcafe.heartandsoul.admin_part.helper.SQLiteHandler;
import com.heartandsoulcafe.heartandsoul.admin_part.helper.SessionManager;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
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
