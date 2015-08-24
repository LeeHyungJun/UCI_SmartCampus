package com.example.hjlee.map;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.gesture.ZoomType;
import lecho.lib.hellocharts.listener.ColumnChartOnValueSelectListener;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Column;
import lecho.lib.hellocharts.model.ColumnChartData;
import lecho.lib.hellocharts.model.SubcolumnValue;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.Chart;
import lecho.lib.hellocharts.view.ColumnChartView;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.gesture.ZoomType;
import lecho.lib.hellocharts.listener.ColumnChartOnValueSelectListener;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.Column;
import lecho.lib.hellocharts.model.ColumnChartData;
import lecho.lib.hellocharts.model.SubcolumnValue;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.Chart;
import lecho.lib.hellocharts.view.ColumnChartView;

public class ColumnChartActivity extends ActionBarActivity {


    static String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_column_chart);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.container, new PlaceholderFragment()).commit();
        }

        Intent intent_columChart = getIntent();
        text = intent_columChart.getStringExtra("text");
        Log.d("d", text);
        Log.d("d", text);
        Log.d("d", text);

    }

    /**
     * A fragment containing a column chart.
     */
    public static class PlaceholderFragment extends Fragment {

        private static final int DEFAULT_DATA = 0;
        private static final int SUBCOLUMNS_DATA = 1;
        private static final int STACKED_DATA = 2;
        private static final int NEGATIVE_SUBCOLUMNS_DATA = 3;
        private static final int NEGATIVE_STACKED_DATA = 4;

        private ColumnChartView chart;
        private ColumnChartData data;
        private boolean hasAxes = true;
        private boolean hasAxesNames = true;
        private boolean hasLabels = true;
        private boolean hasLabelForSelected = true;
        private int dataType = DEFAULT_DATA;


        String[] strArr_montly_energy = new String[12];

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
           // setHasOptionsMenu(true);
            View rootView = inflater.inflate(R.layout.fragment_column_chart, container, false);

            chart = (ColumnChartView) rootView.findViewById(R.id.chart);
            chart.setOnValueTouchListener(new ValueTouchListener());
            chart.setZoomEnabled(true);

            String serverURL = "http://1-dot-servertest-1019.appspot.com/apis/energy/get/placename="+text;
            new HttpTask().execute(serverURL);
            Log.e("column chart Url",serverURL);



            return rootView;
        }

        class HttpTask extends AsyncTask<String, Void, String> {
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
                    //Log.i("result", object.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                JSONArray Array_energy = null;

                try {
                    Array_energy =new JSONArray(object.getString("energy"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
///////////////////////////////time////////////////////////////////////////////////////
                for (int i = 0; i < Array_energy.length(); i++) {
                    //Log.i("test", String.valueOf(i));

                    JSONObject insideObject__ = null;
                    try {
                        insideObject__ = Array_energy.getJSONObject(i);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    try {
                        strArr_montly_energy[0] = insideObject__.getString("1");
                        strArr_montly_energy[1] = insideObject__.getString("2");
                        strArr_montly_energy[2] = insideObject__.getString("3");
                        strArr_montly_energy[3] = insideObject__.getString("4");
                        strArr_montly_energy[4] = insideObject__.getString("5");
                        strArr_montly_energy[5] = insideObject__.getString("6");
                        strArr_montly_energy[6] = insideObject__.getString("7");
                        strArr_montly_energy[7] = insideObject__.getString("8");
                        strArr_montly_energy[8] = insideObject__.getString("9");
                        strArr_montly_energy[9] = insideObject__.getString("10");
                        strArr_montly_energy[10] = insideObject__.getString("11");
                        strArr_montly_energy[11] = insideObject__.getString("12");


                        Log.e("1", strArr_montly_energy[0]);
                        Log.e("2", strArr_montly_energy[1]);
                        Log.e("3", strArr_montly_energy[2]);
                        Log.e("4", strArr_montly_energy[3]);
                        Log.e("5", strArr_montly_energy[4]);
                        Log.e("6", strArr_montly_energy[5]);
                        Log.e("7", strArr_montly_energy[6]);
                        Log.e("8", strArr_montly_energy[7]);
                        Log.e("9", strArr_montly_energy[8]);
                        Log.e("10", strArr_montly_energy[9]);
                        Log.e("11", strArr_montly_energy[10]);
                        Log.e("12", strArr_montly_energy[11]);



                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }


                generateData();

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

        private void reset() {
            hasAxes = true;
            hasAxesNames = true;
            hasLabels = false;
            hasLabelForSelected = false;
            dataType = DEFAULT_DATA;
            chart.setValueSelectionEnabled(hasLabelForSelected);

        }

        private void generateDefaultData() {
            //int numSubcolumns = 1;
            int numColumns = 12;
            // Column can have many subcolumns, here by default I use 1 subcolumn in each of 8 columns.
            List<Column> columns = new ArrayList<Column>();
            List<SubcolumnValue> values;
            for (int i = 0; i < numColumns; ++i) {

                values = new ArrayList<SubcolumnValue>();
                values.add(new SubcolumnValue(Float.parseFloat(strArr_montly_energy[i]), ChartUtils.COLOR_GREEN));

                Column column = new Column(values);
                column.setHasLabels(hasLabels);
                column.setHasLabelsOnlyForSelected(hasLabelForSelected);
                columns.add(column);
            }

            data = new ColumnChartData(columns);



            if (hasAxes) {
                //Axis axisX = new Axis();
               // Axis axisY = new Axis().setHasLines(true);
                if (hasAxesNames) {
                   // axisX.setName("Montly");
                   // axisY.setName("kWh Output").setMaxLabelChars(4).setTextColor(getResources().getColor(R.color.my_black));


                    List<AxisValue> axisValues_y = new ArrayList<AxisValue>();
                    for (float i = 0; i < 8; i += 0.5) {
                        // I'am translating float to minutes because I don't have data in minutes, if You store some time data
                        // you may skip translation.
                        axisValues_y.add(new AxisValue(i).setLabel(String.valueOf(i)));
                    }

                    Axis tempoAxis_y = new Axis(axisValues_y).setName("kWh").setHasLines(true).setMaxLabelChars(4)
                            .setTextColor(getResources().getColor(R.color.my_black));



                    List<AxisValue> axisValues = new ArrayList<AxisValue>();
                    for (int i = 0; i < 12; i += 1) {
                        // I'am translating float to minutes because I don't have data in minutes, if You store some time data
                        // you may skip translation.
                        axisValues.add(new AxisValue(i).setLabel(formatMinutes(i)));
                    }

                    Axis tempoAxis = new Axis(axisValues).setName("Month").setHasLines(true).setMaxLabelChars(4)
                            .setTextColor(getResources().getColor(R.color.my_black));

                    data.setAxisXBottom(tempoAxis);
                    //data.setAxisYLeft(axisY);
                    data.setAxisYLeft(tempoAxis_y);
                }

            }
            else {
                data.setAxisXBottom(null);
                data.setAxisYLeft(null);
            }

            chart.setColumnChartData(data);

        }

        private String formatMinutes(int value) {
            StringBuilder sb = new StringBuilder();
            String mon = "";
            String str_value="";
            //str_value=String.valueOf(value);
            if(value == 0)
                mon="Jan";
            else if(value == 1)
                mon = "Feb";
            else if(value ==2)
                mon = "Mar";
            else if(value ==3)
                mon = "Apr";
            else if(value ==4)
                mon = "May";
            else if(value ==5)
                mon = "June";
            else if(value ==6)
                mon = "July";
            else if(value ==7)
                mon = "Aug";
            else if(value ==8)
                mon = "Sept";
            else if(value ==9)
                mon = "Oct";
            else if(value ==10)
                mon = "Nov";
            else if(value ==11)
                mon = "Dec";
            else
                mon ="hj";


            sb.append(mon);
            return sb.toString();
        }
        /**
         * Generates columns with subcolumns, columns have larger separation than subcolumns.
         */
        private void generateSubcolumnsData() {
            int numSubcolumns = 4;
            int numColumns = 4;
            // Column can have many subcolumns, here I use 4 subcolumn in each of 8 columns.
            List<Column> columns = new ArrayList<Column>();
            List<SubcolumnValue> values;
            for (int i = 0; i < numColumns; ++i) {

                values = new ArrayList<SubcolumnValue>();
                for (int j = 0; j < numSubcolumns; ++j) {
                    values.add(new SubcolumnValue((float) Math.random() * 50f + 5, ChartUtils.pickColor()));
                }

                Column column = new Column(values);
                column.setHasLabels(hasLabels);
                column.setHasLabelsOnlyForSelected(hasLabelForSelected);
                columns.add(column);
            }

            data = new ColumnChartData(columns);

            if (hasAxes) {
                Axis axisX = new Axis();
                Axis axisY = new Axis().setHasLines(true);
                if (hasAxesNames) {
                    axisX.setName("Axis X");
                    axisY.setName("Axis Y");
                }
                data.setAxisXBottom(axisX);
                data.setAxisYLeft(axisY);
            } else {
                data.setAxisXBottom(null);
                data.setAxisYLeft(null);
            }

            chart.setColumnChartData(data);

        }

        /**
         * Generates columns with stacked subcolumns.
         */
        private void generateStackedData() {
            int numSubcolumns = 4;
            int numColumns = 8;
            // Column can have many stacked subcolumns, here I use 4 stacke subcolumn in each of 4 columns.
            List<Column> columns = new ArrayList<Column>();
            List<SubcolumnValue> values;
            for (int i = 0; i < numColumns; ++i) {

                values = new ArrayList<SubcolumnValue>();
                for (int j = 0; j < numSubcolumns; ++j) {
                    values.add(new SubcolumnValue((float) Math.random() * 20f + 5, ChartUtils.pickColor()));
                }

                Column column = new Column(values);
                column.setHasLabels(hasLabels);
                column.setHasLabelsOnlyForSelected(hasLabelForSelected);
                columns.add(column);
            }

            data = new ColumnChartData(columns);

            // Set stacked flag.
            data.setStacked(true);

            if (hasAxes) {
                Axis axisX = new Axis();
                Axis axisY = new Axis().setHasLines(true);
                if (hasAxesNames) {
                    axisX.setName("Axis X");
                    axisY.setName("Axis Y");
                }
                data.setAxisXBottom(axisX);
                data.setAxisYLeft(axisY);
            } else {
                data.setAxisXBottom(null);
                data.setAxisYLeft(null);
            }

            chart.setColumnChartData(data);
        }

        private void generateNegativeSubcolumnsData() {

            int numSubcolumns = 4;
            int numColumns = 4;
            List<Column> columns = new ArrayList<Column>();
            List<SubcolumnValue> values;
            for (int i = 0; i < numColumns; ++i) {

                values = new ArrayList<SubcolumnValue>();
                for (int j = 0; j < numSubcolumns; ++j) {
                    int sign = getSign();
                    values.add(new SubcolumnValue((float) Math.random() * 50f * sign + 5 * sign, ChartUtils.pickColor
                            ()));
                }

                Column column = new Column(values);
                column.setHasLabels(hasLabels);
                column.setHasLabelsOnlyForSelected(hasLabelForSelected);
                columns.add(column);
            }

            data = new ColumnChartData(columns);

            if (hasAxes) {
                Axis axisX = new Axis();
                Axis axisY = new Axis().setHasLines(true);
                if (hasAxesNames) {
                    axisX.setName("Axis X");
                    axisY.setName("Axis Y");
                }
                data.setAxisXBottom(axisX);
                data.setAxisYLeft(axisY);
            } else {
                data.setAxisXBottom(null);
                data.setAxisYLeft(null);
            }

            chart.setColumnChartData(data);
        }

        private void generateNegativeStackedData() {

            int numSubcolumns = 4;
            int numColumns = 8;
            // Column can have many stacked subcolumns, here I use 4 stacke subcolumn in each of 4 columns.
            List<Column> columns = new ArrayList<Column>();
            List<SubcolumnValue> values;
            for (int i = 0; i < numColumns; ++i) {

                values = new ArrayList<SubcolumnValue>();
                for (int j = 0; j < numSubcolumns; ++j) {
                    int sign = getSign();
                    values.add(new SubcolumnValue((float) Math.random() * 20f * sign + 5 * sign, ChartUtils.pickColor()));
                }

                Column column = new Column(values);
                column.setHasLabels(hasLabels);
                column.setHasLabelsOnlyForSelected(hasLabelForSelected);
                columns.add(column);
            }

            data = new ColumnChartData(columns);

            // Set stacked flag.
            data.setStacked(true);

            if (hasAxes) {
                Axis axisX = new Axis();
                Axis axisY = new Axis().setHasLines(true);
                if (hasAxesNames) {
                    axisX.setName("Axis X");
                    axisY.setName("Axis Y");
                }
                data.setAxisXBottom(axisX);
                data.setAxisYLeft(axisY);
            } else {
                data.setAxisXBottom(null);
                data.setAxisYLeft(null);
            }

            chart.setColumnChartData(data);
        }

        private int getSign() {
            int[] sign = new int[]{-1, 1};
            return sign[Math.round((float) Math.random())];
        }

        private void generateData() {
            switch (dataType) {
                case DEFAULT_DATA:
                    generateDefaultData();
                break;
                /*case SUBCOLUMNS_DATA:
                    generateSubcolumnsData();
                    break;
                case STACKED_DATA:
                    generateStackedData();
                    break;
                case NEGATIVE_SUBCOLUMNS_DATA:
                    generateNegativeSubcolumnsData();
                    break;
                case NEGATIVE_STACKED_DATA:
                    generateNegativeStackedData();
                    break;*/
                default:
                    generateDefaultData();
                    break;
            }
        }

        private void toggleLabels() {
            hasLabels = !hasLabels;

            if (hasLabels) {
                hasLabelForSelected = false;
                chart.setValueSelectionEnabled(hasLabelForSelected);
            }

            generateData();
        }

        private void toggleLabelForSelected() {
            hasLabelForSelected = !hasLabelForSelected;
            chart.setValueSelectionEnabled(hasLabelForSelected);

            if (hasLabelForSelected) {
                hasLabels = false;
            }

            generateData();
        }

        private void toggleAxes() {
            hasAxes = !hasAxes;

            generateData();
        }

        private void toggleAxesNames() {
            hasAxesNames = !hasAxesNames;

            generateData();
        }

        /**
         * To animate values you have to change targets values and then call {@link Chart#startDataAnimation()}
         * method(don't confuse with View.animate()).
         */
        private void prepareDataAnimation() {
            for (Column column : data.getColumns()) {
                for (SubcolumnValue value : column.getValues()) {
                    value.setTarget((float) Math.random() * 100);
                }
            }
        }

            private class ValueTouchListener implements ColumnChartOnValueSelectListener {

                @Override
                public void onValueSelected(int columnIndex, int subcolumnIndex, SubcolumnValue value) {
                    Toast.makeText(getActivity(), "Selected: " + value, Toast.LENGTH_SHORT).show();
                }

            @Override
            public void onValueDeselected() {
                // TODO Auto-generated method stub

            }

        }

    }
}
