package com.example.homegym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Hello1 extends AppCompatActivity {
Button keepFit, weightLoss, buildMuscle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello1);

        keepFit = findViewById(R.id.KeepingFit);
        weightLoss = findViewById(R.id.WeightLoss);
        buildMuscle = findViewById(R.id.BuildMuscle);

        keepFit.setOnClickListener(v -> {
            keepFit.setBackgroundResource(R.drawable.corner_push);
            intent();
        });

        weightLoss.setOnClickListener(v -> {
            weightLoss.setBackgroundResource(R.drawable.corner_push);
            intent();
        });

        buildMuscle.setOnClickListener(v -> {
            buildMuscle.setBackgroundResource(R.drawable.corner_push);
            intent();
        });
    }

    public void intent(){
        Intent hello2 = new Intent(Hello1.this, Hello2.class);
        startActivity(hello2);
        finish();
    }
}