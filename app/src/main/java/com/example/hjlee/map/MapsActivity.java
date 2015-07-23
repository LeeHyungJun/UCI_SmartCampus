package com.example.hjlee.map;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.w3c.dom.Text;

public class MapsActivity extends FragmentActivity {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.

    static final LatLng universityartgallery = new LatLng(33.649714, -117.844649);
    static final LatLng javacity = new LatLng(33.643434, -117.841239);
    static final LatLng busstop = new LatLng(33.649427, -117.839849);
    static final LatLng foodcourt = new LatLng(33.648788, -117.842271);
    static final LatLng starbucks = new LatLng(33.648260, -117.842082);
    static final LatLng musicmediabldg = new LatLng(33.649269, -117.844609);
    static final LatLng aldrichpark = new LatLng(33.646012, -117.842749);
    static final LatLng frederickreineshall = new LatLng(33.643860, -117.843573);
    static final LatLng aircterrace = new LatLng(33.646161, -117.840576);
    static final LatLng library = new LatLng(33.647261, -117.841328);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpMapIfNeeded();

        Marker a = mMap.addMarker(new MarkerOptions().position(universityartgallery).title("University Art Gallery").alpha(0.7f));
        Marker b = mMap.addMarker(new MarkerOptions().position(javacity).title("Java City").alpha(0.7f));
        Marker c = mMap.addMarker(new MarkerOptions().position(busstop).alpha(0.7f));
        Marker d = mMap.addMarker(new MarkerOptions().position(foodcourt).title("Food Court").alpha(0.7f));
        Marker e = mMap.addMarker(new MarkerOptions().position(starbucks).title("Star Bucks").alpha(0.7f));
        Marker f = mMap.addMarker(new MarkerOptions().position(musicmediabldg).title("Music Medical Bldg").alpha(0.7f));
        Marker g = mMap.addMarker(new MarkerOptions().position(aldrichpark).title("Aldrich Park").alpha(0.7f));
        Marker h = mMap.addMarker(new MarkerOptions().position(frederickreineshall).title("Frederick Reines Hall").alpha(0.7f));
        Marker i = mMap.addMarker(new MarkerOptions().position(aircterrace).title("AIRC Terrace").alpha(0.7f));
        Marker j = mMap.addMarker(new MarkerOptions().position(library).title("Library").alpha(0.7f));

        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            public void onInfoWindowClick(Marker arg0) {
                Log.d("d", arg0.getTitle());

                LinearLayout bottom_layout = (LinearLayout) findViewById(R.id.bottomLayout);
                TextView myText = (TextView)findViewById(R.id.bottomText);
                myText.setText(arg0.getTitle());
                ImageView image = (ImageView) findViewById(R.id.slidingImage);

                if(arg0.getPosition().equals(universityartgallery))
                   image.setImageResource(R.drawable.universityartgallery);
                else if(arg0.getPosition().equals(javacity))
                    image.setImageResource(R.drawable.javacity);
                else if(arg0.getPosition().equals(busstop))
                    image.setImageResource(R.drawable.busstop);
                else if(arg0.getPosition().equals(foodcourt))
                    image.setImageResource(R.drawable.foodcourt);
                else if(arg0.getPosition().equals(starbucks))
                    image.setImageResource(R.drawable.starbucks);
                else if(arg0.getPosition().equals(musicmediabldg))
                    image.setImageResource(R.drawable.musicmediabldg);
                else if(arg0.getPosition().equals(aldrichpark))
                    image.setImageResource(R.drawable.aldrichpark);
                else if(arg0.getPosition().equals(frederickreineshall))
                    image.setImageResource(R.drawable.frederickreineshall);
                else if(arg0.getPosition().equals(aircterrace))
                    image.setImageResource(R.drawable.aircterrace);
                else if(arg0.getPosition().equals(library))
                    image.setImageResource(R.drawable.library);

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    private void setUpMap() {
        mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
    }
}
