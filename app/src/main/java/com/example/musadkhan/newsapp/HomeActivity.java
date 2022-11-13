package com.example.musadkhan.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.musadkhan.newsapp.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {


    ActivityMainBinding binding;
    BottomNavigationView bottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        replaceFragment(new HomeFragment());

        bottomNavigation = findViewById(R.id.bottomNavigationView);

        bottomNavigation.setOnItemSelectedListener(item -> {

            switch(item.getItemId()){

                case R.id.homeBtn:
                    replaceFragment(new HomeFragment());
                    break;

                case R.id.bookmarkBtn:
                    replaceFragment(new BookmarkFragment());
                    break;

                case R.id.profileBtn:
                    replaceFragment(new ProfileFragment());
                    break;
            }


            return  true;
        });
    }


    private void replaceFragment(Fragment fragment)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }

}