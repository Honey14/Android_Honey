package com.e.bottomsheetdialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button text_click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text_click = findViewById(R.id.text_click);
        text_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DocumentBottomDialogFragment fragment = DocumentBottomDialogFragment.newInstance();
                fragment.show(getSupportFragmentManager(), "see_document");
            }
        });
    }
}