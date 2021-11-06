package com.example.homegym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Hello2 extends AppCompatActivity {

    Button next;
    ImageButton male, female;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello2);

        next = findViewById(R.id.Next);
        male = findViewById(R.id.Male);
        female = findViewById(R.id.Female);
    }

    public void Click(View view){
        switch (view.getId()){
            case R.id.Male:
                male.setBackgroundResource(R.drawable.corner_push);
                female.setBackgroundResource(R.drawable.corner);
                male.setActivated(true);
                female.setActivated(false);
                break;
            case R.id.Female:
                male.setBackgroundResource(R.drawable.corner);
                female.setBackgroundResource(R.drawable.corner_push);
                female.setActivated(true);
                male.setActivated(false);
                break;
            case R.id.Next:
                if (!(male.isActivated() || female.isActivated())){
                    next.setEnabled(false);
                }
                next.setEnabled(true);
                if(male.isActivated()){
                    next.setBackgroundResource(R.drawable.corner_push);
                    next.setTextColor(getResources().getColor(R.color.white));
                    manIntent();
                }
                else if (female.isActivated()) {
                    next.setBackgroundResource(R.drawable.corner_push);
                    next.setTextColor(getResources().getColor(R.color.white));
                    womanIntent();
                }
        }
    }
    public void manIntent(){
        Intent man = new Intent(Hello2.this, Hello3_Male.class);
        startActivity(man);
        finish();
    }
    public void womanIntent(){
        Intent woman = new Intent(Hello2.this, Hello3_Fem.class);
        startActivity(woman);
        finish();
    }
}