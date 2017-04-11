package com.heartandsoulcafe.heartandsoul;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Toolbar my_toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(my_toolbar);

        getSupportActionBar().setTitle(R.string.my_tb_Title);
        getSupportActionBar().setSubtitle(R.string.my_tb_subtitle);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);



        final TextView goto_homeLink = (TextView) findViewById(R.id.tvGotohome);
        goto_homeLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goto_HomeIntent = new Intent(WelcomeActivity.this, HomeActivity.class);
                WelcomeActivity.this.startActivity(goto_HomeIntent);
            }
        });

        final TextView signupLink = (TextView) findViewById(R.id.bSignup);
        signupLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Signup_Intent = new Intent(WelcomeActivity.this, SignupActivity.class);
                WelcomeActivity.this.startActivity(Signup_Intent);
            }
        });
        final TextView signinLink = (TextView) findViewById(R.id.bSignin);
        signinLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Signin_Intent = new Intent(WelcomeActivity.this, SigninActivity.class);
                WelcomeActivity.this.startActivity(Signin_Intent);
            }
        });
    }
}
