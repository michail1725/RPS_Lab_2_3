package com.example.rps_lab_2_3;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class generation extends MainActivity {
    String[] genTypes = {"Full Random", "None", "None"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.generation);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        Spinner GenTypeSpinner = (Spinner) findViewById(R.id.GenTypeSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, genTypes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        GenTypeSpinner.setAdapter(adapter);
    }
}
