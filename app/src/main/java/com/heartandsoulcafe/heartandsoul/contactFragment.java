package com.heartandsoulcafe.heartandsoul;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.*;
import android.view.ViewGroup;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.net.Uri;

import android.widget.*;


public class contactFragment extends Fragment {

    View rootView;
    ImageButton btn;
    Intent i;
    TextView tv;

    public contactFragment() {
        // Required empty public constructor
    }

@Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_contact, container, false);



        View.OnClickListener listener1 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.phone)));
                startActivity(i);

            }
        };
        tv = (TextView) rootView.findViewById(R.id.tvCall);
        tv.setOnClickListener(listener1);


        View.OnClickListener listener2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.email)));
                startActivity(i);

            }
        };
    tv = (TextView) rootView.findViewById(R.id.tvEmailCafe);
    tv.setOnClickListener(listener2);

    View.OnClickListener listener3 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            i = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.facebook)));
            startActivity(i);

        }
    };
    btn = (ImageButton) rootView.findViewById(R.id.btnFacebook);
    btn.setOnClickListener(listener3);

    View.OnClickListener listener4 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            i = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.insta)));
            startActivity(i);

        }
    };
    btn = (ImageButton) rootView.findViewById(R.id.btnInsta);
    btn.setOnClickListener(listener4);



    return rootView;
    }

}
