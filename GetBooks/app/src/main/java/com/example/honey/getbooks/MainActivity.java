package com.example.honey.getbooks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);

    }

    public void OnSearching(View view) {

        String searching = editText.getText().toString();
        if(searching.matches("")){
            editText.setError("You cannot search empty");

        }else{
            Intent intent = new Intent(MainActivity.this,BooksActivity.class);
            intent.putExtra("search_key",searching);
            startActivity(intent);
        }

    }
}
