package com.example.mystopwatch;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    TextView textView;
    int seconds=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.timerText);
    }

    public void onclickstart(View view) {
        startTimer();
    }
    public void onclickstop(View view) {

    }
    public void onclickreset(View view) {

    }
    public void startTimer(){
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
               int s = seconds%60;
               int m = seconds%60;
               int h = m/60;


               seconds++;


               String formatString = String.format(Locale.getDefault(),"%02d:%02d:%02d",h,m,s);
               textView.setText(formatString);
               handler.postDelayed(this, 1000);

            }
        };
        handler.post(runnable);
    }
}
