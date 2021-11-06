package com.example.homegym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Hello3_Male extends AppCompatActivity {
Button hands, spine, torso, legs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello3_male);

        hands = findViewById(R.id.button);
        spine = findViewById(R.id.button2);
        torso = findViewById(R.id.button3);
        legs = findViewById(R.id.button4);
    }

    public void Clicks(View view){
        switch (view.getId()){
            case R.id.button:
                hands.setBackgroundResource(R.drawable.corner_push);
                intent();
                break;
            case R.id.button2:
                spine.setBackgroundResource(R.drawable.corner_push);
                intent();
                break;
            case R.id.button3:
                torso.setBackgroundResource(R.drawable.corner_push);
                intent();
                break;
            case R.id.button4:
                legs.setBackgroundResource(R.drawable.corner_push);
                intent();
                break;
        }
    }
    public void intent(){
        Intent intent = new Intent(Hello3_Male.this, Hello4.class);
        startActivity(intent);
        finish();
    }
}