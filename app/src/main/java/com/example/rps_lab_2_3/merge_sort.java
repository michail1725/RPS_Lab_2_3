package com.example.rps_lab_2_3;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Button;

public class merge_sort extends MainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.merge);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }
    public void onGenerationButtonClick (android.view.View view) {
        Intent intent = new Intent(merge_sort.this, generation.class);
        startActivity(intent);
    }
}
