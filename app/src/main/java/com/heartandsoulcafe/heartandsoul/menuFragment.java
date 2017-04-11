package com.heartandsoulcafe.heartandsoul;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class menuFragment extends Fragment {

    View rootView;
    TextView  txt;
    Intent i;
    ImageButton btn;


    public menuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_menu, container, false);

        Typeface myTypeface = Typeface.createFromAsset(getActivity().getAssets(), "Pacifico.ttf");
        txt = (TextView) rootView.findViewById(R.id.tvHotfood);
        txt.setTypeface(myTypeface);
        txt = (TextView) rootView.findViewById(R.id.tvBreakfast);
        txt.setTypeface(myTypeface);
        txt = (TextView) rootView.findViewById(R.id.tvLunch);
        txt.setTypeface(myTypeface);
        txt = (TextView) rootView.findViewById(R.id.tvDrinks);
        txt.setTypeface(myTypeface);
        txt = (TextView) rootView.findViewById(R.id.tvSweets);
        txt.setTypeface(myTypeface);




        OnClickListener listener1 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(getActivity(), hotfoodActivity.class);
                startActivity(i);

            }
        };
        final TextView hotfoodLink = (TextView) rootView.findViewById(R.id.tvHotfood);
        hotfoodLink.setOnClickListener(listener1);

        OnClickListener listener2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(getActivity(), breakfastActivity.class);
                startActivity(i);

            }

        };
        final TextView breakfastLink = (TextView) rootView.findViewById(R.id.tvBreakfast);
        breakfastLink.setOnClickListener(listener2);

        OnClickListener listener3 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(getActivity(), launchActivity.class);
                startActivity(i);

            }

        };
        final TextView lunchLink = (TextView) rootView.findViewById(R.id.tvLunch);
        lunchLink.setOnClickListener(listener3);


        OnClickListener listener4 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(getActivity(), drinksActivity.class);
                startActivity(i);

            }

        };
        final TextView drinkLink = (TextView) rootView.findViewById(R.id.tvDrinks);
        drinkLink.setOnClickListener(listener4);


        OnClickListener listener5 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(getActivity(), sweetsActivity.class);
                startActivity(i);

            }

        };
        final TextView sweetLink = (TextView) rootView.findViewById(R.id.tvSweets);
        sweetLink.setOnClickListener(listener5);

        return rootView;
    }

}
