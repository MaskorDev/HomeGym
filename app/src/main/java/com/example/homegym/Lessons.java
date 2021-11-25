package com.example.homegym;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Lessons extends Fragment {
Button handsDraw, spineDraw, torsoDraw, legsDraw;
ImageView image1, image2, image3, image4;

    public Lessons(){

    }

    public static Lessons newInstance() {
        return new Lessons();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_lessons, container, false);

        handsDraw = v.findViewById(R.id.button5);
        spineDraw = v.findViewById(R.id.button6);
        torsoDraw = v.findViewById(R.id.button7);
        legsDraw = v.findViewById(R.id.button8);

        image1 = v.findViewById(R.id.biceps2);
        image2 = v.findViewById(R.id.biceps3);
        image3 = v.findViewById(R.id.biceps6);
        image4 = v.findViewById(R.id.biceps4);

        handsDraw.setOnClickListener(view ->{
            handsDraw.setActivated(true);
            handsDraw.setBackgroundResource(R.drawable.strokepush);
            handsDraw.setTextColor(getResources().getColor(R.color.white));
            unPushBut(spineDraw,torsoDraw,legsDraw);
            changeDrawable("hands");

            image1.setOnClickListener(view1 -> {
                MyIntent myIntent = new MyIntent();
                myIntent.NextActivity(getContext(), MenuPushUps.class);
            });

            image2.setOnClickListener(view1 -> {
                MyIntent myIntent = new MyIntent();
                myIntent.NextActivity(getContext(), MenuPushUps.class);
            });

            image3.setOnClickListener(view1 -> {
                MyIntent myIntent = new MyIntent();
                myIntent.NextActivity(getContext(), MenuPushUps.class);
            });

            image4.setOnClickListener(view1 -> {
                MyIntent myIntent = new MyIntent();
                myIntent.NextActivity(getContext(), MenuPushUps.class);
            });
        });

        spineDraw.setOnClickListener(view ->{
            spineDraw.setActivated(true);
            spineDraw.setBackgroundResource(R.drawable.strokepush);
            spineDraw.setTextColor(getResources().getColor(R.color.white));
            unPushBut(handsDraw,torsoDraw,legsDraw);
            changeDrawable("spine");
        });

        torsoDraw.setOnClickListener(view ->{
            torsoDraw.setActivated(true);
            torsoDraw.setBackgroundResource(R.drawable.strokepush);
            torsoDraw.setTextColor(getResources().getColor(R.color.white));
            unPushBut(handsDraw,spineDraw,legsDraw);
            changeDrawable("torso");
        });

        legsDraw.setOnClickListener(view ->{
            legsDraw.setActivated(true);
            legsDraw.setBackgroundResource(R.drawable.strokepush);
            legsDraw.setTextColor(getResources().getColor(R.color.white));
            unPushBut(handsDraw,spineDraw,torsoDraw);
            changeDrawable("legs");
        });
        return v;
    }


    private void unPushBut(Button button, Button button1, Button button2){
        button.setBackgroundResource(R.drawable.stroke);
        button1.setBackgroundResource(R.drawable.stroke);
        button2.setBackgroundResource(R.drawable.stroke);
        button.setTextColor(getResources().getColor(R.color.blue));
        button1.setTextColor(getResources().getColor(R.color.blue));
        button2.setTextColor(getResources().getColor(R.color.blue));
        button.setActivated(false);
        button1.setActivated(false);
        button2.setActivated(false);
    }

    private void changeDrawable(String muscle){
        switch (muscle){
            case "hands":
                image1.setBackgroundResource(R.drawable.bcps);
                image2.setBackgroundResource(R.drawable.bcps);
                image3.setBackgroundResource(R.drawable.bcps);
                image4.setBackgroundResource(R.drawable.bcps);
                break;
            case "spine":
                image1.setBackgroundResource(R.drawable.spn);
                image2.setBackgroundResource(R.drawable.spn);
                image3.setBackgroundResource(R.drawable.spn);
                image4.setBackgroundResource(R.drawable.spn);
                break;
            case "torso":
                image1.setBackgroundResource(R.drawable.crbs);
                image2.setBackgroundResource(R.drawable.crbs);
                image3.setBackgroundResource(R.drawable.crbs);
                image4.setBackgroundResource(R.drawable.crbs);
                break;
            case "legs":
                image1.setBackgroundResource(R.drawable.lgs);
                image2.setBackgroundResource(R.drawable.lgs);
                image3.setBackgroundResource(R.drawable.lgs);
                image4.setBackgroundResource(R.drawable.lgs);
                break;
        }
    }
}