package com.example.hjlee.map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;

public class informationActivity extends Activity{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information);

        Intent intent = getIntent();
        String text = intent.getStringExtra("text");
        Log.d("d", text);

        TextView a=(TextView) findViewById(R.id.Activity_2_text);
        a.setText(text);


        Button terminate = (Button)findViewById(R.id.terminateActivity);
        terminate.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                finish();
            }

        });

    }
}