package com.example.homegym;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

public class Timer extends AppCompatActivity {
Button start, stop, reset;
TextView time;
int mCurrentPeriod = 0;
private java.util.Timer myTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        start = findViewById(R.id.Start);
        stop = findViewById(R.id.Stop);
        reset = findViewById(R.id.Reset);
        time = findViewById(R.id.Time);
    }

    public void Start(View view){
        start.setEnabled(false);
        myTimer = new java.util.Timer();
        myTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                TimerMethod();
            };
        },0 ,1000);
    }

    public void Stop(View view){
        if(myTimer != null)
            myTimer.cancel();
        start.setEnabled(true);
    }

    public void Reset(View view){
        if(myTimer != null){
            mCurrentPeriod = 0;
            myTimer.cancel();
            time.setText("00:00");
            start.setEnabled(true);
        }
    }

    private void TimerMethod(){
        this.runOnUiThread(Timer_tick);
    }

    private Runnable Timer_tick = new Runnable() {
        @Override
        public void run() {
            mCurrentPeriod++;
            String temp = (new SimpleDateFormat("mm:ss")).format(new Date(mCurrentPeriod*1000));
            time.setText(temp);
        }
    };
}