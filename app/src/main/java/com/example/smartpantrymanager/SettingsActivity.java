package com.example.smartpantrymanager;


import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    Switch switchExpiry;
    Spinner spinnerUnits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_settings);

        switchExpiry =
                findViewById(R.id.switchExpiry);

        spinnerUnits =
                findViewById(R.id.spinnerUnits);

        String[] units = {
                "Metric",
                "Imperial"
        };

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_spinner_item,
                        units
                );

        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        spinnerUnits.setAdapter(adapter);
    }
}