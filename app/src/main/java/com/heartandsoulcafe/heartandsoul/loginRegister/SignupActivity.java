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

public class SignupActivity extends AppCompatActivity {
    EditText name, email, password, rePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        name = (EditText) findViewById(R.id.et_Name);
        email = (EditText) findViewById(R.id.et_email);
        password = (EditText) findViewById(R.id.et_password);
        rePassword = (EditText) findViewById(R.id.et_rePassword);

        Toolbar my_toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(my_toolbar);

        getSupportActionBar().setTitle(R.string.title_activity_signup);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

    public void OnReg(View view) {
        String str_name = name.getText().toString();
        String str_email = email.getText().toString();
        String str_password = password.getText().toString();
        String str_rePassword = rePassword.getText().toString();
        String type = "Register";

        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, str_name, str_email, str_password, str_rePassword);

        Intent intent = new Intent(SignupActivity.this,
                SigninActivity.class);
        startActivity(intent);
        Toast.makeText(SignupActivity.this, "Registered successfully!", Toast.LENGTH_SHORT).show();
    }


    }


