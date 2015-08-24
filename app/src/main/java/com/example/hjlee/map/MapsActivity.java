package com.example.hjlee.map;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.TransitionDrawable;
import android.os.AsyncTask;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MapsActivity extends FragmentActivity implements AdapterView.OnItemClickListener{

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    public int count=0;
    public int num=0;
    TextView myText;
    String effected_by_shadow = null;
    String effected_by_sun = null;

    int cnt=0;

    String fullsun = null;
    String shadow = null;
    String weather=null;
    String energy=null;

    String eachweater1=null;
    String eachweater2=null;
    String eachweater3=null;
    String eachweater4=null;
    String eachweater5=null;



    TextView sliding_layout_text1;
    TextView sliding_layout_text2;
    TextView sliding_layout_text3;
    TextView sliding_layout_text4;
    TextView sliding_layout_text5;

    TextView sliding_layout_text1_1;
    TextView sliding_layout_text2_2;
    TextView sliding_layout_text3_3;
    TextView sliding_layout_text4_4;
    TextView sliding_layout_text5_5;

    TextView energyText4;
    TextView energyText5;


    ImageButton shadow_graph_Button;
    ImageButton power_graph_Button;
    Button btn_draw_State;

    String position;
    String real_position;

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



    class HttpTask extends AsyncTask<String, Void, String> {
        String result = "";
        InputStream inputStream = null;
        String url = "";
        String url_position = "";
        String url_last_char="";


        Calendar calendar = Calendar.getInstance();

        DateFormat current_time = new SimpleDateFormat("yyyy -MM -dd  HH:mm.");
        String currentDateandTime = current_time.format(Calendar.getInstance().getTime());


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

                url=String.valueOf(String.valueOf(request.getURI()));
                Log.e("url", String.valueOf(request.getURI()));
                String[] arr = url.split("/");


               // Log.e("url5", arr[5]);

                url_position=arr[5].substring(10);
                Log.e("url_position1", url_position);

                url_last_char = url_position.substring(url_position.length() - 1);
                Log.e(" url_last_char",  url_last_char);


                response = client.execute(request);
                Log.e("response", String.valueOf(response));
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


            Log.e("result", result);
            JSONObject object = null;
            try {
                object = new JSONObject(result);
                Log.e("result_obj", object.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }

            JSONArray Array_effect = null;
            JSONArray Array_weather = null;
            JSONArray Array_energy = null;

            try {

                //star marker ==  not center point
                if (url_last_char.equals("1") || url_last_char.equals("2") || url_last_char.equals("3") || url_last_char.equals("4") || url_last_char.equals("5")) {
                    Array_effect = new JSONArray(object.getString("time"));
                    Array_weather = new JSONArray(object.getString("weather"));
                    Array_energy= new JSONArray(object.getString("energy"));
                    //Sting a= new sting(Array.length());
                    Log.i("result2", object.getString("data"));
                }
                // red marker == center point
                else{
                    Array_effect = new JSONArray(object.getString("effect"));
                }


            } catch (JSONException e) {
                e.printStackTrace();
            }



        ///star
            if(url_last_char.equals("1") || url_last_char.equals("2") || url_last_char.equals("3") || url_last_char.equals("4") || url_last_char.equals("5")) {

                    for (int i = 0; i < Array_weather.length(); i++) {
                        //Log.i("test", String.valueOf(i));

                        JSONObject insideObject = null;
                        try {
                            insideObject = Array_weather.getJSONObject(i);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        try {
                            weather = insideObject.getString("weather");
                            Log.e("current_weather",weather);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                }

                for (int i = 0; i < Array_energy.length(); i++) {
                    //Log.i("test", String.valueOf(i));

                    JSONObject insideObject__ = null;
                    try {
                        insideObject__ = Array_energy.getJSONObject(i);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    try {
                        energy= insideObject__.getString("energy");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

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


                    // not center point == star marker
                    if (url_last_char.equals("1") || url_last_char.equals("2") || url_last_char.equals("3") || url_last_char.equals("4") || url_last_char.equals("5")) {
                        fullsun = insideObject.getString("fullsun");
                        shadow = insideObject.getString("shadow");
                        Log.e("javacity star : ", fullsun+"    "+shadow);
                    }
                    // center point ==  red marker
                    else{
                        effected_by_shadow = insideObject.getString("effected_by_shadow");
                        Log.e("in javacity shadow: ", effected_by_shadow);
                        effected_by_sun = insideObject.getString("effected_by_sun");
                        Log.e("in javacit y sun :" , effected_by_sun);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }


                //red marker
                if (!(url_last_char.equals("1") || url_last_char.equals("2") || url_last_char.equals("3") || url_last_char.equals("4") || url_last_char.equals("5"))) {

                    sliding_layout_text1 = (TextView) findViewById(R.id.sliding_layout_text1);
                    sliding_layout_text1.setVisibility(View.INVISIBLE);
                    sliding_layout_text2 = (TextView) findViewById(R.id.sliding_layout_text2);
                    sliding_layout_text2.setText("Current Time :");
                    sliding_layout_text3 = (TextView) findViewById(R.id.sliding_layout_text3);
                    sliding_layout_text3.setText("Fullsun percent :");
                    sliding_layout_text4 = (TextView) findViewById(R.id.sliding_layout_text4);
                    sliding_layout_text4.setText("Shadow percent :");
                    sliding_layout_text5 = (TextView) findViewById(R.id.sliding_layout_text5);
                    sliding_layout_text5.setVisibility(View.INVISIBLE);

                    sliding_layout_text1_1 = (TextView) findViewById(R.id.sliding_layout_text1_1);
                    sliding_layout_text1_1.setVisibility(View.INVISIBLE);
                    sliding_layout_text2_2 = (TextView) findViewById(R.id.sliding_layout_text2_2);
                    sliding_layout_text2_2.setText(currentDateandTime);
                    sliding_layout_text3_3 = (TextView) findViewById(R.id.sliding_layout_text3_3);
                    sliding_layout_text3_3.setText(effected_by_sun);
                    sliding_layout_text4_4 = (TextView) findViewById(R.id.sliding_layout_text4_4);
                    sliding_layout_text4_4.setText(effected_by_shadow);
                    sliding_layout_text5_5 = (TextView) findViewById(R.id.sliding_layout_text5_5);
                    sliding_layout_text5_5.setVisibility(View.INVISIBLE);


                    TextView sliding_layout_text1_1;
                    TextView sliding_layout_text2_2;
                    TextView sliding_layout_text3_3;
                    TextView sliding_layout_text4_4;



                    effected_by_shadow = effected_by_shadow.substring(0, effected_by_shadow.length() - 1);
                    effected_by_sun = effected_by_sun.substring(0, effected_by_sun.length() - 1);

                    if (effected_by_shadow.equals("100"))
                        power_graph_Button.setImageResource(R.drawable.shadow_100);
                    else if (effected_by_shadow.equals("80"))
                        power_graph_Button.setImageResource(R.drawable.shadow_80);
                    else if (effected_by_shadow.equals("60"))
                        power_graph_Button.setImageResource(R.drawable.shadow_60);
                    else if (effected_by_shadow.equals("40"))
                        power_graph_Button.setImageResource(R.drawable.shadow_40);
                    else if (effected_by_shadow.equals("20"))
                        power_graph_Button.setImageResource(R.drawable.shadow_20);
                    else if (effected_by_shadow.equals("0"))
                        power_graph_Button.setImageResource(R.drawable.shadow_0);


                    if (effected_by_sun.equals("100"))
                        shadow_graph_Button.setImageResource(R.drawable.sun_100);
                    else if (effected_by_sun.equals("80"))
                        shadow_graph_Button.setImageResource(R.drawable.sun_80);
                    else if (effected_by_sun.equals("60"))
                        shadow_graph_Button.setImageResource(R.drawable.sun_60);
                    else if (effected_by_sun.equals("40"))
                        shadow_graph_Button.setImageResource(R.drawable.sun_40);
                    else if (effected_by_sun.equals("20"))
                        shadow_graph_Button.setImageResource(R.drawable.sun_20);
                    else if (effected_by_sun.equals("0"))
                        shadow_graph_Button.setImageResource(R.drawable.sun_0);


                    shadow_graph_Button.setEnabled(false);
                    power_graph_Button.setEnabled(false);
               }////////star
                else{

                    sliding_layout_text1 = (TextView) findViewById(R.id.sliding_layout_text1);
                    sliding_layout_text1.setVisibility(View.VISIBLE);
                    sliding_layout_text1.setText("Current Time :");
                    sliding_layout_text2 = (TextView) findViewById(R.id.sliding_layout_text2);
                    sliding_layout_text2.setText("Current Status :");
                    sliding_layout_text3 = (TextView) findViewById(R.id.sliding_layout_text3);
                    sliding_layout_text3.setText("Daily Radiation :");
                    sliding_layout_text4 = (TextView) findViewById(R.id.sliding_layout_text4);
                    sliding_layout_text4.setText("Fullsun time :");
                    sliding_layout_text5 = (TextView) findViewById(R.id.sliding_layout_text5);
                    sliding_layout_text5.setVisibility(View.VISIBLE);
                    sliding_layout_text5.setText("Shadow time :");

                    energy=energy.substring(0, energy.length()-9);
                    Log.e("aa",energy);

                    sliding_layout_text1_1 = (TextView) findViewById(R.id.sliding_layout_text1_1);
                    sliding_layout_text1_1.setVisibility(View.VISIBLE);
                    sliding_layout_text1_1.setText(currentDateandTime);
                    sliding_layout_text2_2 = (TextView) findViewById(R.id.sliding_layout_text2_2);
                    sliding_layout_text2_2.setText(weather);
                    sliding_layout_text3_3 = (TextView) findViewById(R.id.sliding_layout_text3_3);
                    sliding_layout_text3_3.setText(energy+" kWh/m*m");
                    sliding_layout_text4_4 = (TextView) findViewById(R.id.sliding_layout_text4_4);
                    sliding_layout_text4_4.setText(fullsun);
                    sliding_layout_text5_5 = (TextView) findViewById(R.id.sliding_layout_text5_5);
                    sliding_layout_text5_5.setVisibility(View.VISIBLE);
                    sliding_layout_text5_5.setText(shadow);


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
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        startActivity(new Intent(this, Splash.class));


        setContentView(R.layout.activity_main);




        setUpMapIfNeeded();




        a = mMap.addMarker(new MarkerOptions().position(busstopart).title("Bus Stop Art").alpha(0.7f));
        b = mMap.addMarker(new MarkerOptions().position(javacity).title("Java City").alpha(0.7f));
        c = mMap.addMarker(new MarkerOptions().position(busstoputc).title("Bus Stop UTC").alpha(0.7f));
        d = mMap.addMarker(new MarkerOptions().position(foodcourt).title("Food Court").alpha(0.7f));
        e = mMap.addMarker(new MarkerOptions().position(starbucks).title("Star Bucks").alpha(0.7f));
        f = mMap.addMarker(new MarkerOptions().position(phoenixfoodcourt).title("Phoenix Food Court").alpha(0.7f));
        g = mMap.addMarker(new MarkerOptions().position(aldrichpark).title("Aldrich Park").alpha(0.7f));
        h = mMap.addMarker(new MarkerOptions().position(utcchipotle).title("UTC Chipotle").alpha(0.7f));
        i = mMap.addMarker(new MarkerOptions().position(aircterrace).title("AIRC Terrace").alpha(0.7f));

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            LinearLayout bottomLayout_for_position_name = (LinearLayout) findViewById(R.id.bottomLayout_for_position_name);
            @Override
            public void onMapClick(LatLng arg0) {
                // TODO Auto-generated method stub
                Log.d("arg0", arg0.latitude + "-" + arg0.longitude);
                Log.d("arg0", "no point");

                bottomLayout_for_position_name.setBackgroundColor(Color.WHITE);
                myText = (TextView) findViewById(R.id.bottomText);
                myText.setTextColor(getResources().getColor(R.color.my_black));


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
                    baby_Of_Position_e = null;
                }

                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(arg0, 17));

            }
        });

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            public boolean onMarkerClick(Marker arg0) {
                position = arg0.getTitle();
                position = position.replace(" ", "");
                position = position.toLowerCase();

                String serverURLTime;
                LinearLayout bottomLayout_for_position_name = (LinearLayout) findViewById(R.id.bottomLayout_for_position_name);

                myText = (TextView) findViewById(R.id.bottomText);

                myText.setText(arg0.getTitle());
                ImageView image = (ImageView) findViewById(R.id.slidingImage);


                myText.setTextColor(Color.WHITE);
                bottomLayout_for_position_name.setBackgroundColor(getResources().getColor(R.color.my_blue));

                //mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(arg0.getPosition(), 19));
               // mMap.animateCamera(CameraUpdateFactory.);


                //mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(arg0.getPosition(), 20));
                circle.strokeColor(Color.rgb(255, 102, 102));
                circle.strokeWidth(1f);
                circle.fillColor(Color.argb(100, 255, 102, 102));
                //circle.radius(25);


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

                Calendar calendar = Calendar.getInstance();
                DateFormat minute = new SimpleDateFormat("HH");
                DateFormat sec = new SimpleDateFormat("mm");

                Log.e("minute",minute.toString());
                Log.e("sec", sec.toString());

                Integer minute_int = Integer.parseInt(minute.format(calendar.getTime()));
                Integer sec_int = Integer.parseInt(sec.format(calendar.getTime()));

                /*Calendar calendar = Calendar.getInstance();

                DateFormat current_time = new SimpleDateFormat("yyyy -MM -dd  HH:mm.");
                String currentDateandTime = current_time.format(Calendar.getInstance().getTime());
*/
                if (arg0.getPosition().equals(busstopart) || arg0.getPosition().equals(busstopart1)|| arg0.getPosition().equals(busstopart2) || arg0.getPosition().equals(busstopart3)|| arg0.getPosition().equals(busstopart4)|| arg0.getPosition().equals(busstopart5) ) {
                    image.setImageResource(R.drawable.busstopart);

                    circle.center(new LatLng(arg0.getPosition().latitude, arg0.getPosition().longitude));


                    baby_Of_Position_a = mMap.addMarker(new MarkerOptions().position(busstopart1).title("BusStop Art 1").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));
                    baby_Of_Position_b = mMap.addMarker(new MarkerOptions().position(busstopart2).title("BusStop Art 2").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));
                    baby_Of_Position_c = mMap.addMarker(new MarkerOptions().position(busstopart3).title("BusStop Art 3").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));
                    baby_Of_Position_d = mMap.addMarker(new MarkerOptions().position(busstopart4).title("BusStop Art 4").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));
                    baby_Of_Position_e = mMap.addMarker(new MarkerOptions().position(busstopart5).title("BusStop Art 5").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));

                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(arg0.getPosition(), 19));

                    if(arg0.getPosition().equals(busstopart)) {
                        serverURLTime="http://1-dot-servertest-1019.appspot.com/apis/getinfo/placename=busstopart/time="+minute_int+sec_int;
                        new HttpTask().execute(serverURLTime);
                        circle.radius(15);
                        mapCircle = mMap.addCircle(circle);
                    }
                    else{
                        circle.center(new LatLng(arg0.getPosition().latitude, arg0.getPosition().longitude));
                        circle.strokeColor(Color.rgb(254, 179, 37));
                        circle.strokeWidth(1f);
                        circle.fillColor(Color.argb(100, 254, 179, 37));
                        circle.radius(4);
                        mapCircle = mMap.addCircle(circle);

                        String a=arg0.getTitle();
                        a=a.replace(" ", "").toLowerCase();
                        Log.e("aaaa", a);

                        serverURLTime= "http://1-dot-servertest-1019.appspot.com/apis/getdata/placename="+a+"/time="+minute_int+sec_int;
                        new HttpTask().execute(serverURLTime);


                        shadow_graph_Button.setImageResource(R.drawable.shadow_graph_);
                        power_graph_Button.setImageResource(R.drawable.power_graph_);

                        shadow_graph_Button.setEnabled(true);
                        power_graph_Button.setEnabled(true);
                    }


                    return true;
                } else if (arg0.getPosition().equals(javacity) || arg0.getPosition().equals(javacity1)|| arg0.getPosition().equals(javacity2)||arg0.getPosition().equals(javacity3)||arg0.getPosition().equals(javacity4)||arg0.getPosition().equals(javacity5)) {
                    image.setImageResource(R.drawable.javacity);

                    circle.center(new LatLng(arg0.getPosition().latitude, arg0.getPosition().longitude));

                    baby_Of_Position_a = mMap.addMarker(new MarkerOptions().position(javacity1).title("Java City1").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));
                    baby_Of_Position_b = mMap.addMarker(new MarkerOptions().position(javacity2).title("Java City2").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));
                    baby_Of_Position_c = mMap.addMarker(new MarkerOptions().position(javacity3).title("Java City3").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));
                    baby_Of_Position_d = mMap.addMarker(new MarkerOptions().position(javacity4).title("Java City4").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));
                    baby_Of_Position_e = mMap.addMarker(new MarkerOptions().position(javacity5).title("Java City5").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));

                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(arg0.getPosition(), 19));




                    if(arg0.getPosition().equals(javacity)) {

                        serverURLTime="http://1-dot-servertest-1019.appspot.com/apis/getinfo/placename=javacity/time="+minute_int+sec_int;
                        new HttpTask().execute(serverURLTime);

                        circle.radius(15);
                        mapCircle = mMap.addCircle(circle);
                    }
                    else{
                        circle.center(new LatLng(arg0.getPosition().latitude, arg0.getPosition().longitude));
                        circle.strokeColor(Color.rgb(254, 179, 37));
                        circle.strokeWidth(1f);
                        circle.fillColor(Color.argb(100, 254, 179, 37));
                        circle.radius(4);
                        mapCircle = mMap.addCircle(circle);

                        String a=arg0.getTitle();
                         a=a.replace(" ", "").toLowerCase();
                        Log.e("aaaa", a);

                        serverURLTime= "http://1-dot-servertest-1019.appspot.com/apis/getdata/placename="+a+"/time="+minute_int+sec_int;
                        new HttpTask().execute(serverURLTime);


                        shadow_graph_Button.setImageResource(R.drawable.shadow_graph_);
                        power_graph_Button.setImageResource(R.drawable.power_graph_);

                        shadow_graph_Button.setEnabled(true);
                        power_graph_Button.setEnabled(true);

                    }
                    return true;
                }


                else if (arg0.getPosition().equals(busstoputc) || arg0.getPosition().equals(busstoputc1) || arg0.getPosition().equals(busstoputc2) || arg0.getPosition().equals(busstoputc3)|| arg0.getPosition().equals(busstoputc4)|| arg0.getPosition().equals(busstoputc5)) {
                    image.setImageResource(R.drawable.busstoputc);


                    circle.center(new LatLng(arg0.getPosition().latitude, arg0.getPosition().longitude));

                    baby_Of_Position_a = mMap.addMarker(new MarkerOptions().position(busstoputc1).title("BusStop UTC 1").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));
                    baby_Of_Position_b = mMap.addMarker(new MarkerOptions().position(busstoputc2).title("BusStop UTC 2").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));
                    baby_Of_Position_c = mMap.addMarker(new MarkerOptions().position(busstoputc3).title("BusStop UTC 3").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));
                    baby_Of_Position_d = mMap.addMarker(new MarkerOptions().position(busstoputc4).title("BusStop UTC 4").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));
                    baby_Of_Position_e = mMap.addMarker(new MarkerOptions().position(busstoputc5).title("BusStop UTC 5").icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));

                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(arg0.getPosition(), 20));

                    if(arg0.getPosition().equals(busstoputc)) {

                        serverURLTime="http://1-dot-servertest-1019.appspot.com/apis/getinfo/placename=busstoputc/time="+minute_int+sec_int;
                        new HttpTask().execute(serverURLTime);

                        circle.radius(7);
                        mapCircle = mMap.addCircle(circle);
                    }
                    else{

                        circle.center(new LatLng(arg0.getPosition().latitude, arg0.getPosition().longitude));
                        circle.strokeColor(Color.rgb(254, 179, 37));
                        circle.strokeWidth(1f);
                        circle.fillColor(Color.argb(100, 254, 179, 37));
                        circle.radius(4);
                        mapCircle = mMap.addCircle(circle);

                            String a=arg0.getTitle();
                            a=a.replace(" ", "").toLowerCase();
                            Log.e("aaaa", a);

                            serverURLTime= "http://1-dot-servertest-1019.appspot.com/apis/getdata/placename="+a+"/time="+minute_int+sec_int;
                            new HttpTask().execute(serverURLTime);


                            shadow_graph_Button.setImageResource(R.drawable.shadow_graph_);
                            power_graph_Button.setImageResource(R.drawable.power_graph_);

                            shadow_graph_Button.setEnabled(true);
                            power_graph_Button.setEnabled(true);

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

                        serverURLTime="http://1-dot-servertest-1019.appspot.com/apis/getinfo/placename=foodcourt/time="+minute_int+sec_int;
                        new HttpTask().execute(serverURLTime);
                        circle.radius(13);
                        mapCircle = mMap.addCircle(circle);
                    }
                    else{

                        circle.center(new LatLng(arg0.getPosition().latitude, arg0.getPosition().longitude));
                        circle.strokeColor(Color.rgb(254, 179, 37));
                        circle.strokeWidth(1f);
                        circle.fillColor(Color.argb(100, 254, 179, 37));
                        circle.radius(4);
                        mapCircle = mMap.addCircle(circle);

                        String a=arg0.getTitle();
                        a=a.replace(" ", "").toLowerCase();
                        Log.e("aaaa", a);

                        serverURLTime= "http://1-dot-servertest-1019.appspot.com/apis/getdata/placename="+a+"/time="+minute_int+sec_int;
                        new HttpTask().execute(serverURLTime);


                        shadow_graph_Button.setImageResource(R.drawable.shadow_graph_);
                        power_graph_Button.setImageResource(R.drawable.power_graph_);

                        shadow_graph_Button.setEnabled(true);
                        power_graph_Button.setEnabled(true);
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

                        serverURLTime="http://1-dot-servertest-1019.appspot.com/apis/getinfo/placename=starbucks/time="+minute_int+sec_int;
                        new HttpTask().execute(serverURLTime);

                        circle.radius(10);
                        mapCircle = mMap.addCircle(circle);
                    }
                    else{

                        circle.center(new LatLng(arg0.getPosition().latitude, arg0.getPosition().longitude));
                        circle.strokeColor(Color.rgb(254, 179, 37));
                        circle.strokeWidth(1f);
                        circle.fillColor(Color.argb(100, 254, 179, 37));
                        circle.radius(4);
                        mapCircle = mMap.addCircle(circle);

                        String a=arg0.getTitle();
                        a=a.replace(" ", "").toLowerCase();
                        Log.e("aaaa", a);

                        serverURLTime= "http://1-dot-servertest-1019.appspot.com/apis/getdata/placename="+a+"/time="+minute_int+sec_int;
                        new HttpTask().execute(serverURLTime);


                        shadow_graph_Button.setImageResource(R.drawable.shadow_graph_);
                        power_graph_Button.setImageResource(R.drawable.power_graph_);

                        shadow_graph_Button.setEnabled(true);
                        power_graph_Button.setEnabled(true);
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

                        serverURLTime="http://1-dot-servertest-1019.appspot.com/apis/getinfo/placename=phoenixfoodcourt/time="+minute_int+sec_int;
                        new HttpTask().execute(serverURLTime);
                        circle.radius(14);
                        mapCircle = mMap.addCircle(circle);
                    }
                    else{

                        circle.center(new LatLng(arg0.getPosition().latitude, arg0.getPosition().longitude));
                        circle.strokeColor(Color.rgb(254, 179, 37));
                        circle.strokeWidth(1f);
                        circle.fillColor(Color.argb(100, 254, 179, 37));
                        circle.radius(4);
                        mapCircle = mMap.addCircle(circle);

                        String a=arg0.getTitle();
                        a=a.replace(" ", "").toLowerCase();
                        Log.e("aaaa", a);

                        serverURLTime= "http://1-dot-servertest-1019.appspot.com/apis/getdata/placename="+a+"/time="+minute_int+sec_int;
                        new HttpTask().execute(serverURLTime);


                        shadow_graph_Button.setImageResource(R.drawable.shadow_graph_);
                        power_graph_Button.setImageResource(R.drawable.power_graph_);

                        shadow_graph_Button.setEnabled(true);
                        power_graph_Button.setEnabled(true);
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
                        serverURLTime="http://1-dot-servertest-1019.appspot.com/apis/getinfo/placename=aldrichpark/time="+minute_int+sec_int;
                        new HttpTask().execute(serverURLTime);
                        circle.radius(55);
                        mapCircle = mMap.addCircle(circle);
                    }
                    else{

                        circle.center(new LatLng(arg0.getPosition().latitude, arg0.getPosition().longitude));
                        circle.strokeColor(Color.rgb(254, 179, 37));
                        circle.strokeWidth(1f);
                        circle.fillColor(Color.argb(100, 254, 179, 37));
                        circle.radius(9);
                        mapCircle = mMap.addCircle(circle);


                        String a=arg0.getTitle();
                        a=a.replace(" ", "").toLowerCase();
                        Log.e("aaaa", a);

                        serverURLTime= "http://1-dot-servertest-1019.appspot.com/apis/getdata/placename="+a+"/time="+minute_int+sec_int;
                        new HttpTask().execute(serverURLTime);


                        shadow_graph_Button.setImageResource(R.drawable.shadow_graph_);
                        power_graph_Button.setImageResource(R.drawable.power_graph_);

                        shadow_graph_Button.setEnabled(true);
                        power_graph_Button.setEnabled(true);
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
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(arg0.getPosition(), 20));

                    if(arg0.getPosition().equals(utcchipotle)) {
                        serverURLTime="http://1-dot-servertest-1019.appspot.com/apis/getinfo/placename=utc/time="+minute_int+sec_int;
                        new HttpTask().execute(serverURLTime);
                        circle.radius(10);
                        mapCircle = mMap.addCircle(circle);
                    }
                    else{

                        circle.center(new LatLng(arg0.getPosition().latitude, arg0.getPosition().longitude));
                        circle.strokeColor(Color.rgb(254, 179, 37));
                        circle.strokeWidth(1f);
                        circle.fillColor(Color.argb(100, 254, 179, 37));
                        circle.radius(3);
                        mapCircle = mMap.addCircle(circle);


                        if( arg0.getPosition().equals(utcchipotle1))
                        {
                            serverURLTime= "http://1-dot-servertest-1019.appspot.com/apis/getdata/placename=utc1/time="+minute_int+sec_int;
                            new HttpTask().execute(serverURLTime);
                        }
                        else if(arg0.getPosition().equals(utcchipotle2)){
                            serverURLTime= "http://1-dot-servertest-1019.appspot.com/apis/getdata/placename=utc2/time="+minute_int+sec_int;
                            new HttpTask().execute(serverURLTime);
                        }
                        else if(arg0.getPosition().equals(utcchipotle3)){
                            serverURLTime= "http://1-dot-servertest-1019.appspot.com/apis/getdata/placename=utc3/time="+minute_int+sec_int;
                            new HttpTask().execute(serverURLTime);
                        }
                        else if(arg0.getPosition().equals(utcchipotle4)){
                            serverURLTime= "http://1-dot-servertest-1019.appspot.com/apis/getdata/placename=utc4/time="+minute_int+sec_int;
                            new HttpTask().execute(serverURLTime);
                        }
                        else if(arg0.getPosition().equals(utcchipotle5)){
                            serverURLTime= "http://1-dot-servertest-1019.appspot.com/apis/getdata/placename=utc5/time="+minute_int+sec_int;
                            new HttpTask().execute(serverURLTime);
                        }



                        shadow_graph_Button.setImageResource(R.drawable.shadow_graph_);
                        power_graph_Button.setImageResource(R.drawable.power_graph_);

                        shadow_graph_Button.setEnabled(true);
                        power_graph_Button.setEnabled(true);
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


                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(arg0.getPosition(), 20));
                    if(arg0.getPosition().equals(aircterrace)) {
                        serverURLTime="http://1-dot-servertest-1019.appspot.com/apis/getinfo/placename=aircterrace/time="+minute_int+sec_int;
                        new HttpTask().execute(serverURLTime);
                        circle.radius(13);
                        mapCircle = mMap.addCircle(circle);
                    }
                    else{

                        circle.center(new LatLng(arg0.getPosition().latitude, arg0.getPosition().longitude));
                        circle.strokeColor(Color.rgb(254, 179, 37));
                        circle.strokeWidth(1f);
                        circle.fillColor(Color.argb(100, 254, 179, 37));
                        circle.radius(3);
                        mapCircle = mMap.addCircle(circle);



                        String a=arg0.getTitle();
                        a=a.replace(" ", "").toLowerCase();
                        Log.e("aaaa", a);

                        serverURLTime= "http://1-dot-servertest-1019.appspot.com/apis/getdata/placename="+a+"/time="+minute_int+sec_int;
                        new HttpTask().execute(serverURLTime);


                        shadow_graph_Button.setImageResource(R.drawable.shadow_graph_);
                        power_graph_Button.setImageResource(R.drawable.power_graph_);

                        shadow_graph_Button.setEnabled(true);
                        power_graph_Button.setEnabled(true);
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
        final LinearLayout bottomLayout_for_position_name = (LinearLayout) findViewById(R.id.bottomLayout_for_position_name);
        final TextView t1 = (TextView) findViewById(R.id.bottomText);

        bottomLayout_for_position_name.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        t1.setTextColor(Color.WHITE);
                        bottomLayout_for_position_name.setBackgroundResource(R.drawable.translate);
                        TransitionDrawable transition = (TransitionDrawable) bottomLayout_for_position_name.getBackground();
                        transition.startTransition(700);
                        break;
                }

                return false;
            }
        });


        shadow_graph_Button = (ImageButton) findViewById(R.id.ImageButton);
        power_graph_Button = (ImageButton) findViewById(R.id.ImageButton2);

        power_graph_Button.setOnClickListener(new View.OnClickListener() {

           @Override
            public void onClick(View v) {

                Intent intent_columChart = new Intent(MapsActivity.this, ColumnChartActivity.class);
                Log.e("intenttext",position);
               intent_columChart.putExtra("text", position);
                startActivity(intent_columChart);

            }
        });

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


        btn_draw_State=(Button) findViewById(R.id.btn_draw_State);
        btn_draw_State.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cnt++;
                if(cnt%2==1)
                    mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                else if(cnt%2==0)
                    mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
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








}
