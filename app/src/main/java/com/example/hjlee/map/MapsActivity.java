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

    static final LatLng artGallery = new LatLng(33.649714, -117.844649);
    static final LatLng javaCity = new LatLng(33.643434, -117.841239);
    static final LatLng busStop = new LatLng(33.649427, -117.839849);
    static final LatLng foodCoat = new LatLng(33.648788, -117.842271);
    static final LatLng starBucks = new LatLng(33.648260, -117.842082);
    static final LatLng socialPlaza = new LatLng(33.646751, -117.839257);
    static final LatLng aldrichPark = new LatLng(33.646462, -117.843710);
    static final LatLng FredrickReinesHall = new LatLng(33.643860, -117.843573);
    static final LatLng AIRC_Terrace = new LatLng(33.646161, -117.840576);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpMapIfNeeded();

        Marker marker = mMap.addMarker(new MarkerOptions().position(artGallery).title("University Art Gallery").alpha(0.7f));
        Marker b = mMap.addMarker(new MarkerOptions().position(javaCity).title("Java City").alpha(0.7f));
        Marker c = mMap.addMarker(new MarkerOptions().position(busStop).title("Bus Stop").alpha(0.7f));
        Marker d = mMap.addMarker(new MarkerOptions().position(foodCoat).title("Food Court").alpha(0.7f));
        Marker e = mMap.addMarker(new MarkerOptions().position(starBucks).title("Star Bucks").alpha(0.7f));
        Marker f = mMap.addMarker(new MarkerOptions().position(socialPlaza).title("socialPlaza").alpha(0.7f));
        Marker g = mMap.addMarker(new MarkerOptions().position(aldrichPark).title("Aldrich Park").alpha(0.7f));
        Marker h = mMap.addMarker(new MarkerOptions().position(FredrickReinesHall).title("Fredrick Reines Hall").alpha(0.7f));
        Marker i = mMap.addMarker(new MarkerOptions().position(AIRC_Terrace).title("AIRC Terrace").alpha(0.7f));



        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            public void onInfoWindowClick(Marker arg0) {
                Log.d("d", arg0.getTitle());

                LinearLayout bottom_layout = (LinearLayout) findViewById(R.id.bottomLayout);
                TextView myText = (TextView)findViewById(R.id.bottomText);


                //myText.setVisibility(View.VISIBLE);

                //layout.setVisibility(View.VISIBLE);
                //myText.setVisibility(View.VISIBLE);

                //ImageView layout2 = (ImageView) findViewById(R.id.image);


               // bottom_layout.setVisibility(View.VISIBLE);

                    myText.setText(arg0.getTitle());

                   // layout1.setVisibility(View.VISIBLE);
                   // layout2.setVisibility(View.VISIBLE);

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
