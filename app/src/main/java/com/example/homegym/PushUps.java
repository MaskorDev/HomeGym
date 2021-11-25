package com.example.homegym;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import java.net.URI;

public class PushUps extends AppCompatActivity {
VideoView videoView;
Button stop, tap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push_ups);

        videoView = findViewById(R.id.videoView);
        stop = findViewById(R.id.Push_Stop);
        tap = findViewById(R.id.Push_Start);


        Uri myVideoUri = Uri.parse( "android.resource://" + getPackageName() + "/" + R.raw.pushup);
        videoView.setVideoURI(myVideoUri);
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });

    }

    public void Click_PushUps(View view){
        switch (view.getId()){
            case R.id.Push_Start:
                videoView.start();
                break;
            case R.id.Push_Stop:
                videoView.pause();
                videoView.setVisibility(View.GONE);
                stop.setVisibility(View.GONE);
                tap.setText("Succes");
                break;
        }
    }
}