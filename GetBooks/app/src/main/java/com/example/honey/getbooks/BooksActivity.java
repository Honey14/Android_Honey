package com.example.honey.getbooks;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
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
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BooksActivity extends AppCompatActivity {
    ListView listView;
    String search_received;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);
        Intent intent = getIntent();
        if (intent != null) {
            search_received = intent.getStringExtra("search_key");
        }
        Log.d("urlreceived", search_received);
        Bookstask bookstask = new Bookstask();
        bookstask.execute();
    }

    public void initViews(ArrayList<BooksDetail> booksDetail) {

        listView = findViewById(R.id.listview);
        BooksAdapter adapter = new BooksAdapter(this, booksDetail);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                BooksDetail detail = (BooksDetail) parent.getAdapter().getItem(position);
                String url = detail.previewLink;
                Log.d("urlreceived",url);
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
    }

    public class Bookstask extends AsyncTask<URL, Void, ArrayList<BooksDetail>> {

        ProgressDialog dialog = new ProgressDialog(BooksActivity.this);

        public Bookstask() {
        }

        public final String BOOKS_BASE_URL = "https://www.googleapis.com/books/v1/volumes?q=" + search_received;

        @Override
        protected void onPreExecute() {
            dialog.setMessage("Loading...");
            dialog.show();
        }

        @Override
        protected ArrayList<BooksDetail> doInBackground(URL... urls) {

            Log.d("urlreceived", BOOKS_BASE_URL);
            Log.d("urlreceived", search_received);

            URL url = createURL(BOOKS_BASE_URL); // create url
            // create an http url connection
            String urlResponse = "";
            try {
                urlResponse = createHttpConnection(url);
                Log.d("TAG12", urlResponse);
            } catch (IOException e) {
                e.printStackTrace();
            }
            ArrayList<BooksDetail> jsonParsing1 = performJSONParsing(urlResponse);
            return jsonParsing1;
        }

        @Override
        protected void onPostExecute(ArrayList<BooksDetail> booksDetails) {
            dialog.dismiss();
            initViews(booksDetails);
        }

        private URL createURL(String booksBaseUrl) {
            URL url = null;
            try {
                url = new URL(booksBaseUrl);
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
                jsonresponse = readInputStreamData(inputStream);
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

        private ArrayList<BooksDetail> performJSONParsing(String urlResponse) {
            ArrayList<BooksDetail> booksDetails = new ArrayList<>();
            try {
                JSONObject jsonObject = new JSONObject(urlResponse);
                JSONArray array = jsonObject.getJSONArray("items");
                for (int i = 0; i < array.length(); i++) {
                    JSONObject jsonObject1 = array.getJSONObject(i);
                    JSONObject jsonObject2 = jsonObject1.getJSONObject("volumeInfo");
                    String titlehere = jsonObject2.getString("title");
                    JSONArray jsonArray = jsonObject2.getJSONArray("authors");
                    String link = jsonObject2.getString("previewLink");
                    String authorhere = jsonArray.getString(0);
                    booksDetails.add(new BooksDetail(titlehere, authorhere, link));


                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return booksDetails;
        }

    }


}
