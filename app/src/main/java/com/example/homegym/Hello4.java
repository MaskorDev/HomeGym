package com.example.homegym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Hello4 extends AppCompatActivity {
Button but1, but2, but3, nextBut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello4);

        but1 = findViewById(R.id.button);
        but2 = findViewById(R.id.button2);
        but3 = findViewById(R.id.button3);
        nextBut = findViewById(R.id.NextBut);

    }

    public void OnClick(View view){
        switch (view.getId()){
            case R.id.button:
                but1.setBackgroundResource(R.drawable.corner_push);
                but2.setBackgroundResource(R.drawable.corner);
                but3.setBackgroundResource(R.drawable.corner);
                but1.setActivated(true);
                but2.setActivated(false);
                but3.setActivated(false);
                break;
            case R.id.button2:
                but1.setBackgroundResource(R.drawable.corner);
                but2.setBackgroundResource(R.drawable.corner_push);
                but3.setBackgroundResource(R.drawable.corner);
                but1.setActivated(false);
                but2.setActivated(true);
                but3.setActivated(false);
                break;
            case R.id.button3:
                but1.setBackgroundResource(R.drawable.corner);
                but2.setBackgroundResource(R.drawable.corner);
                but3.setBackgroundResource(R.drawable.corner_push);
                but1.setActivated(false);
                but2.setActivated(false);
                but3.setActivated(true);
                break;
            case R.id.NextBut:
                if (!(but1.isActivated() && but2.isActivated() && but3.isActivated())){
                     nextBut.setEnabled(false);
                }
                nextBut.setEnabled(true);
                if(but1.isActivated() || but2.isActivated() || but3.isActivated()){
                    nextBut.setBackgroundResource(R.drawable.corner_push);
                    intent();
                }
                break;
        }
    }

    public void intent(){
        Intent Hello5 = new Intent(Hello4.this, Hello5.class);
        startActivity(Hello5);
        finish();
    }
}