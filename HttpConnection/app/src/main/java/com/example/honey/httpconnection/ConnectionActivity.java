package com.example.honey.httpconnection;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;

public class ConnectionActivity extends AppCompatActivity {
    TextView textTitle, textTime, textAlert;
    public final String REQUESTURL = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2012-01-01&endtime=2012-12-01&minmagnitude=6";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection);
        ConnectingInternet task = new ConnectingInternet();
        task.execute();
    }

    private void initViews(Events events) {
        textTitle = findViewById(R.id.textTitle);
        textTime = findViewById(R.id.textTime);
        textAlert = findViewById(R.id.textAlert);
        textTitle.setText(events.title);
        textTime.setText(SetDate(events.time));
        textAlert.setText(SetAlert(events.alert));
    }

    private String SetAlert(int alert) {
        switch (alert) {
            case 0:
                return getString(R.string.yes);
            case 1:
                return getString(R.string.no);
            default:
                return getString(R.string.notavailable);
        }
    }

    private String SetDate(long time) {
        SimpleDateFormat formatter = new SimpleDateFormat("EEE, ddd mm yyyy HH:mm:ss z");
        return formatter.format(time);
    }

    public class ConnectingInternet extends AsyncTask<URI, Void, Events> {
        @Override
        protected Events doInBackground(URI... uris) {
            URL url = createURL(REQUESTURL);
            String response = "";
            try {
                response = createHttpConnection(url);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Events events = ParseJsonData(response);
            return events;
        }

        @Override
        protected void onPostExecute(Events events) {
            initViews(events);
        }

        private URL createURL(String requesturl) {
            URL url = null;
            try {
                url = new URL(requesturl);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return url;
        }

        private String createHttpConnection(URL url) throws IOException {
            HttpURLConnection urlConnection = null;
            InputStream inputStream = null;
            String jsonresponse = "";
            try {
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.setConnectTimeout(10000);
                urlConnection.connect();
                inputStream = urlConnection.getInputStream();
                jsonresponse = readInputStreamData(inputStream); // method to read data

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            }
            return jsonresponse;
        }

        private String readInputStreamData(InputStream inputStream) {
            StringBuilder builder = new StringBuilder();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            try {
                String line = reader.readLine();
                while (line != null) {
                    builder.append(line);
                    line = reader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return builder.toString();
        }

        private Events ParseJsonData(String response) {
            try {
                JSONObject jsonObject = new JSONObject(response);
                JSONArray jsonArray = jsonObject.getJSONArray("features");

                for (int j = 0; j < jsonArray.length(); j++) {
                    JSONObject jsonObject1 = jsonArray.getJSONObject(0);
                    JSONObject properties = jsonObject1.getJSONObject("properties");
                    String title = properties.getString("title");
                    long time = properties.getLong("time");
                    int alert = properties.getInt("tsunami");
                    return new Events(title, time, alert);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

    }
}
