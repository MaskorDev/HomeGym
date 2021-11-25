package com.example.homegym;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Profile extends Fragment {
TextView biometric, weight, height;
Button signOut;


    public Profile() {
        // Required empty public constructor
    }

    public static Profile newInstance() {
        return new Profile();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        biometric = v.findViewById(R.id.textView22);
        weight = v.findViewById(R.id.textView7);
        height = v.findViewById(R.id.textView12);

        signOut = v.findViewById(R.id.profile_SignOut);

        biometric.setOnClickListener(view -> {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            View promptsView = layoutInflater.inflate(R.layout.prompt, null);

            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setView(promptsView);
            final EditText inputWeight = (EditText) promptsView.findViewById(R.id.prompt_weight);
            final EditText inputHeight = (EditText) promptsView.findViewById(R.id.prompt_height);

            builder.setCancelable(false)
                    .setPositiveButton("ОК", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            weight.setText(inputWeight.getText());
                            height.setText(inputHeight.getText());
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });

            AlertDialog alertDialog = builder.create();
            alertDialog.show();

        });

        signOut.setOnClickListener(v1 -> {
            MyIntent myIntent = new MyIntent();
            myIntent.NextActivity(getContext(), SignIn.class);
        });
        return v;
    }
}