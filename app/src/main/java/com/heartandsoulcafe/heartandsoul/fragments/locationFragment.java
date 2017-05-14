package com.heartandsoulcafe.heartandsoul.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.heartandsoulcafe.heartandsoul.R;

public class locationFragment extends android.support.v4.app.Fragment implements OnMapReadyCallback{




    public locationFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_location, container,false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SupportMapFragment fragment = SupportMapFragment.newInstance();
        getChildFragmentManager().findFragmentById(R.id.map);
        fragment.getMapAsync(this);
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {

        LatLng marker = new LatLng(-34.053543, 151.153462);

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker, 20));

        googleMap.addMarker(new MarkerOptions().title("Heart and soul location!").position(marker));

        googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    }
}







