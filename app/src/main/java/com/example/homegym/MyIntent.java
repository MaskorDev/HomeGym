package com.example.homegym;

import android.content.Context;
import android.content.Intent;

public class MyIntent {
    public void NextActivity(Context context, Class GoToClass){
        Intent intent = new Intent(context, GoToClass);
        context.startActivity(intent);
    }
}


