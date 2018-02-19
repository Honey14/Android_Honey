package com.example.honey.stopwatch;
        import android.graphics.Color;
        import android.os.Handler;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.TextView;

        import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button  button_stop, button_reset;
    ImageView button_start;
    boolean running;
    boolean onpressed;
    boolean wasrunning;
    private int seconds = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_start = (ImageView) findViewById(R.id.button_start);
        button_stop = (Button) findViewById(R.id.button_stop);
        button_reset = (Button) findViewById(R.id.button_reset);
        button_start.setOnClickListener(this);
        button_stop.setOnClickListener(this);
        button_reset.setOnClickListener(this);
        if(savedInstanceState!=null){
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasrunning = savedInstanceState.getBoolean("wasrunning");
        }

        RunTimer();
//        if(onpressed == true){
//            button_stop.setBackgroundColor(Color.GRAY);
//            button_reset.setBackgroundColor(Color.GRAY);
//        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (wasrunning)
            running = true;

    }

    @Override
    protected void onPause() {
        super.onPause();
        wasrunning = running;
        running = false;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("seconds",seconds);
        outState.putBoolean("running",running);
        outState.putBoolean("wasrunning",wasrunning);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_start:
                running = true;
                onpressed = true;
                Log.d("seconds", ""+ seconds);
                button_stop.setVisibility(View.VISIBLE);
                button_stop.setBackgroundColor(Color.BLACK);
                button_reset.setBackgroundColor(Color.BLACK);
                button_start.setImageResource(R.drawable.ic_pause);
                break;
            case R.id.button_stop:
                running = false;
                onpressed = true;
                button_reset.setBackgroundColor(Color.BLACK);
                button_stop.setBackgroundColor(Color.GRAY);
                button_start.setImageResource(R.drawable.ic_play);
                break;
            case R.id.button_reset:
                running = false;
                seconds = 0;
                onpressed = true;
                button_stop.setVisibility(View.GONE);
                button_reset.setBackgroundColor(Color.GRAY);
                break;
        }
    }

    private void RunTimer() {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                TextView text_time = (TextView) findViewById(R.id.text_time);
                int hours = seconds/3600;
                int minutes = (seconds%3600)/60;
                int secs = seconds%60;
                String time = String.format(Locale.getDefault(),"%d:%02d:%02d",hours,minutes,secs);
                text_time.setText(time);
                if(running){
                    seconds++;
                }

                handler.postDelayed(this,1000);
            }
        });
    }
}
