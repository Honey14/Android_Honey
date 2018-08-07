package com.example.honeysonwani.exploreasynctask;


import android.os.AsyncTask;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by honeysonwani on 8/7/2018.
 */

public class ExploringAsyncTask extends AsyncTask<Void, Void, String> {
    TextView txt;
    public ExploringAsyncTask(TextView textView) {
        txt = textView;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Void... voids) {
        Random random = new Random();
        int number = random.nextInt(11);
        int noMultiply = number * 200;
        try {
            Thread.sleep(noMultiply);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Awake at last after sleeping for " + noMultiply + " milliseconds";
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        txt.setText(s);
    }
}
