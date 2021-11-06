package com.example.homegym;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Hello5 extends AppCompatActivity {
TextView height, weight;
Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello5);

        height = findViewById(R.id.Height);
        weight = findViewById(R.id.Weight);
        next = findViewById(R.id.NextBut);
    }

    public void onCLick(View view){
        if(height.length() == 0 && weight.length() == 0)
            Dialog("Все поля пустые !");
        else if(height.length() == 0 || weight.length() == 0)
            Dialog("Заполните все поля !");
        else {
            next.setBackgroundResource(R.drawable.corner_push);
            Intent signIn = new Intent(Hello5.this, SignIn.class);
            startActivity(signIn);
            finish();
        }
    }

    public void Dialog(String messege){
        AlertDialog.Builder builder = new AlertDialog.Builder(Hello5.this);
        builder.setTitle("Ошибка !")
                .setMessage(messege)
                .setCancelable(false)
                .setNegativeButton("Ok",
                        (dialog, id) -> dialog.cancel());
        AlertDialog alert = builder.create();
        alert.show();
    }
}