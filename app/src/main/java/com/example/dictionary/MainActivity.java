package com.example.dictionary;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.menu_english:
                    startActivity(new Intent(MainActivity.this, EnglishActivity.class));
                    return true;
                case R.id.menu_yoruba:
                    startActivity(new Intent(MainActivity.this, YorubaActivity.class));
                    return true;
            }
            return false;
        });
    }
}

