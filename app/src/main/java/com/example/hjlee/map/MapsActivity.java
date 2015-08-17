package com.example.hjlee.map;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.TransitionDrawable;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URI;
import java.net.URISyntaxException;

public class MapsActivity extends FragmentActivity implements AdapterView.OnItemClickListener{

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    public int count=0;
    public int num=0;

    String shadow = null;
    String effected_by_sun = null;

    String position;

    static final LatLng busstopart = new LatLng(33.649040, -117.844976);
    static final LatLng javacity = new LatLng(33.6434625709, -117.8411451727);
    static final LatLng busstoputc = new LatLng(33.649433, -117.839830);
    static final LatLng foodcourt = new LatLng(33.648751, -117.842266);
    static final LatLng starbucks = new LatLng(33.648330, -117.842056);
    static final LatLng phoenixfoodcourt = new LatLng(33.645531, -117.840760);
    static final LatLng aldrichpark = new LatLng(33.646003, -117.842784);
    static final LatLng utcchipotle = new LatLng(33.649583, -117.839419);
    static final LatLng aircterrace = new LatLng(33.646153, -117.840739);
    static final LatLng library = new LatLng(33.647261, -117.841328);

    static final LatLng busstopart1 = new LatLng(33.649014, -117.845126);
    static final LatLng busstopart2 = new LatLng(33.649033, -117.845037);
    static final LatLng busstopart3 = new LatLng(33.649079, -117.845123);
    static final LatLng busstopart4 = new LatLng(33.648998, -117.845104);
    static final LatLng busstopart5 = new LatLng(33.649024, -117.845168);

    static final LatLng javacity1 = new LatLng(33.643539, -117.841179);
    static final LatLng javacity2 = new LatLng(33.643431, -117.841225);
    static final LatLng javacity3 = new LatLng(33.643370, -117.841161);
    static final LatLng javacity4 = new LatLng(33.643393, -117.841046);
    static final LatLng javacity5 = new LatLng(33.643501, -117.841067);

    static final LatLng busstoputc1 = new LatLng(33.649455, -117.839884);
    static final LatLng busstoputc2 = new LatLng(33.649406, -117.839842);
    static final LatLng busstoputc3 = new LatLng(33.649446, -117.839844);
    static final LatLng busstoputc4 = new LatLng(33.649434, -117.839866);
    static final LatLng busstoputc5 = new LatLng(33.649457, -117.839859);

    static final LatLng foodcourt1 = new LatLng(33.648721, -117.842220);
    static final LatLng foodcourt2 = new LatLng(33.648797, -117.842270);
    static final LatLng foodcourt3 = new LatLng(33.648830, -117.842255);
    static final LatLng foodcourt4 = new LatLng(33.648720, -117.842282);
    static final LatLng foodcourt5 = new LatLng(33.648687, -117.842220);

    static final LatLng starbucks1 = new LatLng(33.648279, -117.841959);
    static final LatLng starbucks2 = new LatLng(33.648273, -117.842020);
    static final LatLng starbucks3 = new LatLng(33.648325, -117.842101);
    static final LatLng starbucks4 = new LatLng(33.648321, -117.842043);
    static final LatLng starbucks5 = new LatLng(33.648334, -117.842010);

    static final LatLng phoenixfoodcourt1 = new LatLng(33.645493, -117.840756);
    static final LatLng phoenixfoodcourt2 = new LatLng(33.645567, -117.840792);
    static final LatLng phoenixfoodcourt3 = new LatLng(33.645549, -117.840728);
    static final LatLng phoenixfoodcourt4 = new LatLng(33.645534, -117.840766);
    static final LatLng phoenixfoodcourt5 = new LatLng(33.645579, -117.840787);

    static final LatLng aldrichpark1 = new LatLng(33.645774, -117.842519);
    static final LatLng aldrichpark2 = new LatLng(33.645608, -117.842906);
    static final LatLng aldrichpark3 = new LatLng(33.646329, -117.842397);
    static final LatLng aldrichpark4 = new LatLng(33.646310, -117.843146);
    static final LatLng aldrichpark5 = new LatLng(33.645989, -117.843321);

    static final LatLng aircterrace1 = new LatLng(33.646093, -117.840748);
    static final LatLng aircterrace2 = new LatLng(33.646170, -117.840708);
    static final LatLng aircterrace3 = new LatLng(33.646162, -117.840776);
    static final LatLng aircterrace4 = new LatLng(33.646225, -117.840759);
    static final LatLng aircterrace5 = new LatLng(33.646117, -117.840736);

    static final LatLng utcchipotle1 = new LatLng(33.649647, -117.839355);
    static final LatLng utcchipotle2 = new LatLng(33.649517, -117.839457);
    static final LatLng utcchipotle3 = new LatLng(33.649554, -117.839432);
    static final LatLng utcchipotle4 = new LatLng(33.649517, -117.839414);
    static final LatLng utcchipotle5 = new LatLng(33.649626, -117.839429);

    Marker baby_Of_Position_a;
    Marker baby_Of_Position_b;
    Marker baby_Of_Position_c;
    Marker baby_Of_Position_d;
    Marker baby_Of_Position_e;
    Marker a,b,c,d,e,f,g,h,i,j;

    LatLng star_a,star_b,star_c,star_d,star_e;

    CircleOptions circle = new CircleOptions();


    public String[] arrlist ={
            "second",
            "2",
            "3",
            "4"
    };
    private Circle mCircle;
    private Marker mMarker;

    public Circle mapCircle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        setUpMapIfNeeded();


       /* ArrayAdapter<String> Adapter;
        Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrlist);

        ListView list = (ListView)findViewById(R.id.list);
        list.setAdapter(Adapter);

        list.setOnItemClickListener(this);*/

        // title은 보여지는 글자이므로 띄어쓰기, 대문자로 알아보기 쉽게 구성한다.
        // position은 title name그대로 사용하되, 소문자로 구성하고 띄어쓰기는 허용 하지 않는다.
        a = mMap.addMarker(new MarkerOptions().position(busstopart).title("Bus Stop Art").alpha(0.7f));
        b = mMap.addMarker(new MarkerOptions().position(javacity).title("Java City").alpha(0.7f));
        c = mMap.addMarker(new MarkerOptions().position(busstoputc).title("Bus Stop UTC").alpha(0.7f));
        d = mMap.addMarker(new MarkerOptions().position(foodcourt).title("Food Court").alpha(0.7f));
        e = mMap.addMarker(new MarkerOptions().position(starbucks).title("Star Bucks").alpha(0.7f));
        f = mMap.addMarker(new MarkerOptions().position(phoenixfoodcourt).title("Phoenix Food Court").alpha(0.7f));
        g = mMap.addMarker(new MarkerOptions().position(aldrichpark).title("Aldrich Park").alpha(0.7f));
        h = mMap.addMarker(new MarkerOptions().position(utcchipotle).title("UTC Chipotle").alpha(0.7f));
        i = mMap.addMarker(new MarkerOptions().position(aircterrace).title("AIRC Terrace").alpha(0.7f));
        //j = mMap.addMarker(new MarkerOptions().position(library).title("Library").alpha(0.7f));



        /*mMap.addCircle(new CircleOptions()
                .center(new LatLng(universityartgallery.latitude, universityartgallery.longitude))
                .radius(100)
                .strokeColor(Color.rgb(238, 213, 210))
                .fillColor(Color.argb(200, 238, 213, 210)));*/

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {

            @Override
            public void onMapClick(LatLng arg0) {
                // TODO Auto-generated method stub
                Log.d("arg0", arg0.latitude + "-" + arg0.longitude);
                Log.d("arg0", "no point");

                if (mapCircle != null) {
                    mapCircle.remove();
                    mapCircle = null;

                }

                if (baby_Of_Position_a != null) {

                    baby_Of_Position_a.remove();
                    baby_Of_Position_b.remove();
                    baby_Of_Position_c.remove();
                    baby_Of_Position_d.remove();
                    baby_Of_Position_e.remove();

                    baby_Of_Position_a=null;
                    baby_Of_Position_b=null;
                    baby_Of_Position_c=null;
                    baby_Of_Position_d=null;
                    baby_Of_Position_e=null;
                }

                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(arg0, 17));

            }
        });

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            public boolean onMarkerClick(Marker arg0) {
                position = arg0.getTitle();
                position = position.replace(" ", "");
                position = position.toLowerCase();
                Log.d("testests", position);
                Log.d("testests", position);
                Log.d("testests", position);
                Log.d("testests", position);



                LinearLayout bottom_layout = (LinearLayout) findViewById(R.id.bottomLayout);
                TextView myText = (TextView) findViewById(R.id.bottomText);
                myText.setText(arg0.getTitle());
                ImageView image = (ImageView) findViewById(R.id.slidingImage);


                myText.setTextColor(Color.DKGRAY);
                bottom_layout.setBackgroundColor(Color.WHITE);

                //mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(arg0.getPosition(), 19));
               // mMap.animateCamera(CameraUpdateFactory.);


                //mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(arg0.getPosition(), 20));
                circle.strokeColor(Color.rgb(255, 102, 102));
                circle.strokeWidth(1f);
                circle.fillColor(Color.argb(100, 255, 102, 102));
                //circle.radius(25);

///////////////////////////////////////////////////////////////////////////////////////////////
                //String serverURL = "http://1-dot-servertest-1019.appspot.com/apis/getdata/placename=ga";
                //new HttpTask().execute(serverURL);
                //////////////////////////////////////////////////////////////////////////////



                if (mapCircle != null) {
                    mapCircle.remove();
                }

                if (baby_Of_Position_a != null) {

                    baby_Of_Position_a.remove();
                    baby_Of_Position_b.remove();
                    baby_Of_Position_c.remove();
                    baby_Of_Position_d.remove();
                    baby_Of_Position_e.remove();

                    baby_Of_Position_a=null;
                    baby_Of_Position_b=null;
                    baby_Of_Position_c=null;
                    baby_Of_Position_d=null;
                    baby_Of_Position_e=null;
                }

               // mapCircle = mMap.addCircle(circle);


                if (arg0.getPosition().equals(busstopart) || arg0.getPosition().equals(busstopart1)|| arg0.getPosition().equals(busstopart2) || arg0.getPosition().equals(busstopart3)|| arg0.getPosition().equals(busstopart4)|| arg0.getPosition().equals(busstopart5) ) {
                    image.setImageResource(R.drawable.busstopart);

                    circle.center(new LatLng(arg0.getPosition().latitude, arg0.getPosition().longitude));


                    baby_Of_Position_a = mMap.addMarker(new MarkerOptions().position(busstopart1).title("BusStop Art 1").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));
                    baby_Of_Position_b = mMap.addMarker(new MarkerOptions().position(busstopart2).title("BusStop Art 2").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));
                    baby_Of_Position_c = mMap.addMarker(new MarkerOptions().position(busstopart3).title("BusStop Art 3").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));
                    baby_Of_Position_d = mMap.addMarker(new MarkerOptions().position(busstopart4).title("BusStop Art 4").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));
                    baby_Of_Position_e = mMap.addMarker(new MarkerOptions().position(busstopart5).title("BusStop Art 5").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));

                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(arg0.getPosition(), 18));

                    if(arg0.getPosition().equals(busstopart)) {
                        circle.radius(15);
                        mapCircle = mMap.addCircle(circle);
                    }


                    return true;
                } else if (arg0.getPosition().equals(javacity)|| arg0.getPosition().equals(javacity1)|| arg0.getPosition().equals(javacity2)||arg0.getPosition().equals(javacity3)||arg0.getPosition().equals(javacity4)||arg0.getPosition().equals(javacity5)) {
                    image.setImageResource(R.drawable.javacity);

                    circle.center(new LatLng(arg0.getPosition().latitude, arg0.getPosition().longitude));

                    baby_Of_Position_a = mMap.addMarker(new MarkerOptions().position(javacity1).title("Java City1").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));
                    baby_Of_Position_b = mMap.addMarker(new MarkerOptions().position(javacity2).title("Java City2").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));
                    baby_Of_Position_c = mMap.addMarker(new MarkerOptions().position(javacity3).title("Java City3").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));
                    baby_Of_Position_d = mMap.addMarker(new MarkerOptions().position(javacity4).title("Java City4").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));
                    baby_Of_Position_e = mMap.addMarker(new MarkerOptions().position(javacity5).title("Java City5").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));


                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(arg0.getPosition(), 19));

                    if(arg0.getPosition().equals(javacity)) {
                        circle.radius(15);
                        mapCircle = mMap.addCircle(circle);
                    }

                    return true;
                } else if (arg0.getPosition().equals(busstoputc) || arg0.getPosition().equals(busstoputc1) || arg0.getPosition().equals(busstoputc2) || arg0.getPosition().equals(busstoputc3)|| arg0.getPosition().equals(busstoputc4)|| arg0.getPosition().equals(busstoputc5)) {
                    image.setImageResource(R.drawable.busstoputc);


                    circle.center(new LatLng(arg0.getPosition().latitude, arg0.getPosition().longitude));

                    baby_Of_Position_a = mMap.addMarker(new MarkerOptions().position(busstoputc1).title("BusStop UTC 1").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));
                    baby_Of_Position_b = mMap.addMarker(new MarkerOptions().position(busstoputc2).title("BusStop UTC 2").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));
                    baby_Of_Position_c = mMap.addMarker(new MarkerOptions().position(busstoputc3).title("BusStop UTC 3").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));
                    baby_Of_Position_d = mMap.addMarker(new MarkerOptions().position(busstoputc4).title("BusStop UTC 4").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));
                    baby_Of_Position_e = mMap.addMarker(new MarkerOptions().position(busstoputc5).title("BusStop UTC 5").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));

                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(arg0.getPosition(), 20));

                    if(arg0.getPosition().equals(busstoputc)) {
                        circle.radius(7);
                        mapCircle = mMap.addCircle(circle);
                    }
                    return true;
                } else if (arg0.getPosition().equals(foodcourt) || arg0.getPosition().equals(foodcourt1) || arg0.getPosition().equals(foodcourt2)|| arg0.getPosition().equals(foodcourt3)|| arg0.getPosition().equals(foodcourt4) || arg0.getPosition().equals(foodcourt5)) {
                    image.setImageResource(R.drawable.foodcourt);



                    circle.center(new LatLng(arg0.getPosition().latitude, arg0.getPosition().longitude));

                    baby_Of_Position_a = mMap.addMarker(new MarkerOptions().position(foodcourt1).title("Food Court 1").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));
                    baby_Of_Position_b = mMap.addMarker(new MarkerOptions().position(foodcourt2).title("Food Court 2").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));
                    baby_Of_Position_c = mMap.addMarker(new MarkerOptions().position(foodcourt3).title("Food Court 3").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));
                    baby_Of_Position_d = mMap.addMarker(new MarkerOptions().position(foodcourt4).title("Food Court 4").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));
                    baby_Of_Position_e = mMap.addMarker(new MarkerOptions().position(foodcourt5).title("Food Court 5").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));

                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(arg0.getPosition(), 20));

                    if(arg0.getPosition().equals(foodcourt)) {
                        circle.radius(13);
                        mapCircle = mMap.addCircle(circle);
                    }

                    return true;
                } else if (arg0.getPosition().equals(starbucks) || arg0.getPosition().equals(starbucks1) || arg0.getPosition().equals(starbucks2) || arg0.getPosition().equals(starbucks3) || arg0.getPosition().equals(starbucks4) || arg0.getPosition().equals(starbucks5)){
                    image.setImageResource(R.drawable.starbucks);



                    circle.center(new LatLng(arg0.getPosition().latitude, arg0.getPosition().longitude));

                    baby_Of_Position_a = mMap.addMarker(new MarkerOptions().position(starbucks1).title("Star Bucks1").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));
                    baby_Of_Position_b = mMap.addMarker(new MarkerOptions().position(starbucks2).title("Star Bucks2").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));
                    baby_Of_Position_c = mMap.addMarker(new MarkerOptions().position(starbucks3).title("Star Bucks3").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));
                    baby_Of_Position_d = mMap.addMarker(new MarkerOptions().position(starbucks4).title("Star Bucks4").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));
                    baby_Of_Position_e = mMap.addMarker(new MarkerOptions().position(starbucks5).title("Star Bucks5").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));

                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(arg0.getPosition(), 20));

                    if(arg0.getPosition().equals(starbucks)) {
                        circle.radius(10);
                        mapCircle = mMap.addCircle(circle);
                    }




                    return true;
                } else if (arg0.getPosition().equals(phoenixfoodcourt) || arg0.getPosition().equals(phoenixfoodcourt1) || arg0.getPosition().equals(phoenixfoodcourt2) || arg0.getPosition().equals(phoenixfoodcourt3) || arg0.getPosition().equals(phoenixfoodcourt4) || arg0.getPosition().equals(phoenixfoodcourt5) ) {
                    image.setImageResource(R.drawable.phoenixfoodcourt);
                    circle.center(new LatLng(arg0.getPosition().latitude, arg0.getPosition().longitude));



                    baby_Of_Position_a = mMap.addMarker(new MarkerOptions().position(phoenixfoodcourt1).title("Phoenix Food Court 1").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));
                    baby_Of_Position_b = mMap.addMarker(new MarkerOptions().position(phoenixfoodcourt2).title("Phoenix Food Court 2").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));
                    baby_Of_Position_c = mMap.addMarker(new MarkerOptions().position(phoenixfoodcourt3).title("Phoenix Food Court 3").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));
                    baby_Of_Position_d = mMap.addMarker(new MarkerOptions().position(phoenixfoodcourt4).title("Phoenix Food Court 4").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));
                    baby_Of_Position_e = mMap.addMarker(new MarkerOptions().position(phoenixfoodcourt5).title("Phoenix Food Court 5").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));

                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(arg0.getPosition(), 20));

                    if(arg0.getPosition().equals(phoenixfoodcourt)) {
                        circle.radius(14);
                        mapCircle = mMap.addCircle(circle);
                    }
                    return true;
                } else if (arg0.getPosition().equals(aldrichpark) || arg0.getPosition().equals(aldrichpark1) || arg0.getPosition().equals(aldrichpark2)  || arg0.getPosition().equals(aldrichpark3)  || arg0.getPosition().equals(aldrichpark4) || arg0.getPosition().equals(aldrichpark5)) {
                    image.setImageResource(R.drawable.aldrichpark);
                    circle.center(new LatLng(arg0.getPosition().latitude, arg0.getPosition().longitude));


                    baby_Of_Position_a = mMap.addMarker(new MarkerOptions().position(aldrichpark1).title("Aldrich Park 1").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));
                    baby_Of_Position_b = mMap.addMarker(new MarkerOptions().position(aldrichpark2).title("Aldrich Park 2").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));
                    baby_Of_Position_c = mMap.addMarker(new MarkerOptions().position(aldrichpark3).title("Aldrich Park 3").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));
                    baby_Of_Position_d = mMap.addMarker(new MarkerOptions().position(aldrichpark4).title("Aldrich Park 4").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));
                    baby_Of_Position_e = mMap.addMarker(new MarkerOptions().position(aldrichpark5).title("Aldrich Park 5").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(arg0.getPosition(), 18));

                    if(arg0.getPosition().equals(aldrichpark)) {
                        circle.radius(55);
                        mapCircle = mMap.addCircle(circle);
                    }
                    return true;
                } else if (arg0.getPosition().equals(utcchipotle) || arg0.getPosition().equals(utcchipotle1)|| arg0.getPosition().equals(utcchipotle2) || arg0.getPosition().equals(utcchipotle3)|| arg0.getPosition().equals(utcchipotle4)|| arg0.getPosition().equals(utcchipotle5)) {
                    image.setImageResource(R.drawable.aldrichpark);
                    circle.center(new LatLng(arg0.getPosition().latitude, arg0.getPosition().longitude));

                    baby_Of_Position_a = mMap.addMarker(new MarkerOptions().position(utcchipotle1).title("UTC Chipotle 1").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));
                    baby_Of_Position_b = mMap.addMarker(new MarkerOptions().position(utcchipotle2).title("UTC Chipotle 2").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));
                    baby_Of_Position_c = mMap.addMarker(new MarkerOptions().position(utcchipotle3).title("UTC Chipotle 3").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));
                    baby_Of_Position_d = mMap.addMarker(new MarkerOptions().position(utcchipotle4).title("UTC Chipotle 4").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));
                    baby_Of_Position_e = mMap.addMarker(new MarkerOptions().position(utcchipotle5).title("UTC Chipotle 5").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(arg0.getPosition(), 19));

                    if(arg0.getPosition().equals(utcchipotle)) {
                        circle.radius(10);
                        mapCircle = mMap.addCircle(circle);
                    }
                    return true;
                } else if (arg0.getPosition().equals(aircterrace) || arg0.getPosition().equals(aircterrace1) || arg0.getPosition().equals(aircterrace2)|| arg0.getPosition().equals(aircterrace3)|| arg0.getPosition().equals(aircterrace4) || arg0.getPosition().equals(aircterrace5)) {
                    image.setImageResource(R.drawable.aircterrace);
                    circle.center(new LatLng(arg0.getPosition().latitude, arg0.getPosition().longitude));


                    baby_Of_Position_a = mMap.addMarker(new MarkerOptions().position(aircterrace1).title("AIRC Terrace 1").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));
                    baby_Of_Position_b = mMap.addMarker(new MarkerOptions().position(aircterrace2).title("AIRC Terrace 2").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));
                    baby_Of_Position_c = mMap.addMarker(new MarkerOptions().position(aircterrace3).title("AIRC Terrace 3").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));
                    baby_Of_Position_d = mMap.addMarker(new MarkerOptions().position(aircterrace4).title("AIRC Terrace 4").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));
                    baby_Of_Position_e = mMap.addMarker(new MarkerOptions().position(aircterrace5).title("AIRC Terrace 5").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));


                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(arg0.getPosition(), 18));
                    if(arg0.getPosition().equals(aircterrace)) {
                        circle.radius(20);
                        mapCircle = mMap.addCircle(circle);
                    }
                    return true;
                } else {
                    return false;
                }
            }


            public void addStarMarker(LatLng star_a , LatLng star_b , LatLng star_c,LatLng star_d,LatLng star_e){

            }



        });



        final LinearLayout b2 = (LinearLayout) findViewById(R.id.whole);
        final LinearLayout b1 = (LinearLayout) findViewById(R.id.bottomLayout);
        final TextView t1 = (TextView) findViewById(R.id.bottomText);

        b1.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        t1.setTextColor(Color.WHITE);
                        b1.setBackgroundResource(R.drawable.translate);
                        TransitionDrawable transition = (TransitionDrawable) b1.getBackground();
                        transition.startTransition(700);
                        break;
                }

                return false;
            }
        });


        ImageButton shadow_graph_Button = (ImageButton) findViewById(R.id.ImageButton);
       // shadow_graph_Button.setBackgroundDrawable(null);
        shadow_graph_Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MapsActivity.this, informationActivity.class);
                Log.e("intenttext",position);
                intent.putExtra("text", position);
                startActivity(intent);

            }
        });

       /* ImageButton power_graph_Button = (ImageButton) findViewById(R.id.ImageButton2);
        power_graph_Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapsActivity.this, informationActivity.class);
                intent.putExtra("text",position);
                startActivity(intent);

            }
        });*/


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

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
        String c_list =arrlist[i];
        Intent intent =new Intent(MapsActivity.this, informationActivity.class);
        intent.putExtra("arr_text", c_list);
        startActivity(intent);
    }




    /*class HttpTask extends AsyncTask<String, Void, String> {
        String result = "";
        InputStream inputStream = null;

        protected void onPreExecute() {
            //display progress dialog.
            // NOTE: You can call UI Element here.
        }

        // Call after onPreExecute method
        protected String doInBackground(String... urls) {
            HttpResponse response = null;

            try {
                HttpClient client = new DefaultHttpClient();
                HttpGet request = new HttpGet();
                //"http://1-dot-servertest-1019.appspot.com/apis/sample/hello/name=insert"
                request.setURI(new URI(urls[0]));
                response = client.execute(request);
                inputStream = response.getEntity().getContent();
                result = convertStreamToString(inputStream);

            } catch (URISyntaxException e) {
                e.printStackTrace();
            } catch (ClientProtocolException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return result;
        }


        protected void onPostExecute(String result) {
            super.onPostExecute(result);


            JSONObject object = null;
            try {
                object = new JSONObject(result);
                Log.i("result", object.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }

            JSONArray Array_effect = null;

            try {
                Array_effect = new JSONArray(object.getString("effect"));
                //Sting a= new sting(Array.length());
                //Log.i("result2", object.getString("data"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
///////////////shadow data////////////////////////////////////////////////////////
            for (int i = 0; i < Array_effect.length(); i++) {
                //Log.i("test", String.valueOf(i));

                JSONObject insideObject = null;
                try {
                    insideObject = Array_effect.getJSONObject(i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }


                try {
                    shadow = insideObject.getString("shadow");
                    //shadow_degreeArray.add(Float.parseFloat(degree));

                    Log.e("test", shadow);
                    effected_by_sun = insideObject.getString("effected_by_sun");
                    //shadow_azimuthArray.add(Float.parseFloat(azimuth));
                    Log.e("test2", effected_by_sun);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        }

        public String convertStreamToString(InputStream inputStream) throws IOException {
            if (inputStream != null) {
                Writer writer = new StringWriter();

                char[] buffer = new char[1024];
                try {
                    Reader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 1024);
                    int n;
                    while ((n = reader.read(buffer)) != -1) {
                        writer.write(buffer, 0, n);
                    }
                } finally {
                    inputStream.close();
                }
                return writer.toString();
            } else {
                return "";
            }
        }
    }*/



}
