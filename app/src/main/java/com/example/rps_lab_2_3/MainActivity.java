package com.example.rps_lab_2_3;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    int[] array;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }
    public void onGenerationButtonClick (android.view.View view) {
        Intent intent = new Intent(MainActivity.this, generation.class);
        startActivity(intent);
    }
    public void onSimulationButtonClick (android.view.View view) {
        Intent intent = new Intent(MainActivity.this, simulation.class);
        startActivity(intent);
    }
    public void onBubbleButtonClick (android.view.View view) {
        Intent intent = new Intent(MainActivity.this, bubble_sort.class);
        startActivity(intent);
    }
    public void onMergeButtonClick (android.view.View view) {
        Intent intent = new Intent(MainActivity.this, merge_sort.class);
        startActivity(intent);
    }
    public void onQuickButtonClick (android.view.View view) {
        Intent intent = new Intent(MainActivity.this, quick_sort.class);
        startActivity(intent);
    }
}