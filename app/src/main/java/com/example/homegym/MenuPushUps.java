package com.example.homegym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuPushUps extends AppCompatActivity {
Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_push_ups);
        Declaration();
    }

    public void menuPushUps_OnClick(View view){
        switch (view.getId()){
            case R.id.push_ups_button:
                menuPushUps_SwapDraw(b1);
                Intent();
                break;
            case R.id.push_ups_button1:
                menuPushUps_SwapDraw(b2);
                Intent();
                break;
            case R.id.push_ups_button2:
                menuPushUps_SwapDraw(b3);
                Intent();
                break;
            case R.id.push_ups_button3:
                menuPushUps_SwapDraw(b4);
                Intent();
                break;
            case R.id.push_ups_button4:
                menuPushUps_SwapDraw(b5);
                Intent();
                break;
            case R.id.push_ups_button5:
                menuPushUps_SwapDraw(b6);
                Intent();
                break;
        }
    }

    private void menuPushUps_SwapDraw(Button button){
        button.setBackgroundResource(R.drawable.circles_push);
        button.setTextColor(getResources().getColor(R.color.white));
    }

    private void Intent(){
        Intent intent = new Intent(MenuPushUps.this, PushUps.class);
        startActivity(intent);
    }


    private void Declaration(){
        b1 = findViewById(R.id.push_ups_button);
        b2 = findViewById(R.id.push_ups_button1);
        b3 = findViewById(R.id.push_ups_button2);
        b4 = findViewById(R.id.push_ups_button3);
        b5 = findViewById(R.id.push_ups_button4);
        b6 = findViewById(R.id.push_ups_button5);
        b7 = findViewById(R.id.push_ups_button6);
        b8 = findViewById(R.id.push_ups_button7);
        b9 = findViewById(R.id.push_ups_button8);
        b10 = findViewById(R.id.push_ups_button9);
    }
}