package com.heartandsoulcafe.heartandsoul.loginRegister;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.heartandsoulcafe.heartandsoul.R;
import com.heartandsoulcafe.heartandsoul.general_classes.HomeActivity;

public class SigninActivity extends AppCompatActivity {

    EditText UsernameEt, PasswordEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        Toolbar my_toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(my_toolbar);

        getSupportActionBar().setTitle(R.string.title_activity_login);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        UsernameEt = (EditText) findViewById(R.id.et_email);
        PasswordEt = (EditText)findViewById(R.id.et_password);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }


    public void OnLogin(View view){
        String username = UsernameEt.getText().toString();
        String password = PasswordEt.getText().toString();
        String type = "login";

        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, username, password);

        Intent intent = new Intent(SigninActivity.this,
                HomeActivity.class);
        startActivity(intent);
        Toast.makeText(SigninActivity.this, "Welcome!", Toast.LENGTH_SHORT).show();

    }
}
