package com.weebly.leeboxuan.mapproblemstatement;

import android.Manifest;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3;
    private GoogleMap map;
    Spinner spinner;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        SupportMapFragment mapFragment = (SupportMapFragment) fm.findFragmentById(R.id.map);

        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                map = googleMap;
                int permissionCheck = ContextCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.ACCESS_FINE_LOCATION);



                LatLng point_admiralty = new LatLng(1.441015, 103.800866);
                Marker admiralty = map.addMarker(new
                        MarkerOptions()
                        .position(point_admiralty)
                        .title("HQ - North")
                        .snippet("Block 333, Admiralty Ave 3, 765654 ")
                        .icon(BitmapDescriptorFactory.fromResource(android.R.drawable.star_big_on)));

                LatLng point_bedok = new LatLng(1.324376, 103.930151);
                Marker bedok = map.addMarker(new
                        MarkerOptions()
                        .position(point_bedok)
                        .title("HQ - Bedok")
                        .snippet("Block 555, Tampines Ave 3. 287788")
                        .icon(BitmapDescriptorFactory.fromResource(android.R.drawable.star_big_on)));


                LatLng point_orchard = new LatLng(1.304623, 103.831995);
                Marker orchard = map.addMarker(new
                        MarkerOptions()
                        .position(point_orchard)
                        .title("HQ - Central")
                        .snippet("Block 3A, Orchard Ave 3, 134542")
                        .icon(BitmapDescriptorFactory.fromResource(android.R.drawable.star_big_on)));

                UiSettings ui = map.getUiSettings();
                ui.setCompassEnabled(true);
                ui.setZoomControlsEnabled(true);

                map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(Marker marker) {
                        String title = marker.getTitle();
                        Toast.makeText(MainActivity.this, title, Toast.LENGTH_LONG).show();

                        return false;
                    }
                });

            }
        });

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        spinner = (Spinner) findViewById(R.id.spinner);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int selectedItem = spinner.getSelectedItemPosition();
                if (selectedItem == 0){
                    LatLng point_admiralty = new LatLng(1.441015, 103.800866);

                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(point_admiralty, 5));

                }else if(selectedItem == 1){
                    if (map != null){
                        LatLng point_admiralty = new LatLng(1.441015, 103.800866);

                        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(point_admiralty, 15);
                        map.moveCamera(update);

                    }

                }else if(selectedItem == 2){
                    if (map != null){
                        LatLng point_orchard = new LatLng(1.304623, 103.831995);
                        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(point_orchard, 15);

                        map.moveCamera(update);

                    }

                }else{
                    if (map != null){
                        LatLng point_bedok = new LatLng(1.324376, 103.930151);
                        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(point_bedok, 15);
                        map.moveCamera(update);



                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (map != null){
                    LatLng point_admiralty = new LatLng(1.441015, 103.800866);

                    CameraUpdate update = CameraUpdateFactory.newLatLngZoom(point_admiralty, 15);
                    map.moveCamera(update);

                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (map != null){
                    LatLng point_orchard = new LatLng(1.304623, 103.831995);
                    CameraUpdate update = CameraUpdateFactory.newLatLngZoom(point_orchard, 15);

                    map.moveCamera(update);

                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (map != null){
                    LatLng point_bedok = new LatLng(1.324376, 103.930151);
                    CameraUpdate update = CameraUpdateFactory.newLatLngZoom(point_bedok, 15);
                    map.moveCamera(update);



                }
            }
        });
}
}
