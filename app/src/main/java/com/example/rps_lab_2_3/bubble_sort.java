package com.example.rps_lab_2_3;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

public class bubble_sort extends MainActivity {
    String text;
    TextView sortedMatrixText = findViewById(R.id.sortedMatrixText);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bubble);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        text += "Your matrix: ";
    }
    public void onGenerationButtonClick (android.view.View view) {
        Intent intent = new Intent(bubble_sort.this, generation.class);
        startActivity(intent);
    }
    public void onSortButtonClick (android.view.View view) {
        int tmp = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                //comparison++;
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    //permutation++;
                }
            }
        }
        text += "Bubble Sort:";
        for (int i = 0; i < array.length; i++) {
            text += array[i] + " ";
        }
        sortedMatrixText.setText(text);
    }
}
