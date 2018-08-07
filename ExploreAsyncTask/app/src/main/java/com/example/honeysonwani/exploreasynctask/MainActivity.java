package com.example.honeysonwani.exploreasynctask;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button;
    private static final String TEXT_PRESENT = "currentText";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textview);
        button = findViewById(R.id.button);
        if (savedInstanceState != null) {
            textView.setText(savedInstanceState.getString(TEXT_PRESENT));
        }
    }

    public void startTask(View view) {
        textView.setText(R.string.showup);
        new ExploringAsyncTask(textView).execute();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(TEXT_PRESENT, textView.getText().toString());
    }
}
