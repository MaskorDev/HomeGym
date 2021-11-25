package com.example.homegym;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ReportFragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.MenuItem;
import android.view.Window;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainMenu extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.navigation_lessons:
                    loadFragment(Lessons.newInstance());
                    return true;
                case R.id.navigation_plan:
                    loadFragment(Plan.newInstance());
                    return true;
                case R.id.navigation_reports:
                    loadFragment(Reports.newInstance());
                    return true;
                case R.id.navigation_profile:
                    loadFragment(Profile.newInstance());
                    return true;
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        loadFragment(Plan.newInstance());

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.BottomNavigationView);
        navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
    }
}