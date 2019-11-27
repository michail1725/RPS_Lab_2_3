package com.example.rps_lab_2_3;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    public static int[] array;
    public static int   size = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }
    public void onGenerationButtonClick (android.view.View view) {
        Intent intent = new Intent(MainActivity.this, GenerationActivity.class);
        startActivity(intent);
    }
    public void onSimulationButtonClick (android.view.View view) {
        Intent intent = new Intent(MainActivity.this, SimulationActivity.class);
        startActivity(intent);
    }
    public void onBubbleSortButtonClick (android.view.View view) {
        Intent intent = new Intent(MainActivity.this, BubbleSortActivity.class);
        startActivity(intent);
    }
    public void onMergeSortButtonClick (android.view.View view) {
        Intent intent = new Intent(MainActivity.this, MergeSortActivity.class);
        startActivity(intent);
    }
    public void onQuickSortButtonClick (android.view.View view) {
        Intent intent = new Intent(MainActivity.this, QuickSortActivity.class);
        startActivity(intent);
    }
    public void onEnterMatrixButtonClick (android.view.View view) {
        Intent intent = new Intent(MainActivity.this, EnterMatrixActivity.class);
        startActivity(intent);
    }
}