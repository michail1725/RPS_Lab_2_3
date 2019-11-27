package com.example.rps_lab_2_3;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.Button;
import android.widget.TextView;

public class QuickSortActivity extends MainActivity {
    private String   text;
    private TextView MatrixQuickText;
    private Button   QuickSortButton;
    private int      comparison = 0,
                     permutation = 0;
    private int[]    arrayForSort;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        MatrixQuickText = findViewById(R.id.MatrixQuickText);
        MatrixQuickText.setMovementMethod(new ScrollingMovementMethod());
        QuickSortButton = findViewById(R.id.QuickSortButton);
        if (size == 0) {
            text = "The array is empty. Create it!";
            MatrixQuickText.setText(text);
            QuickSortButton.setClickable(false);
        }
        else {
            arrayForSort = new int[size];
            text = "Your array: ";
            for (int i = 0; i < array.length; i++) {
                text += array[i] + " ";
                arrayForSort[i] = array[i];
            }
            MatrixQuickText.setText(text);
            QuickSortButton.setClickable(true);
        }
    }
    public void onQuickSortButtonClick (android.view.View view) {
        QuickSort(0, arrayForSort.length - 1);
        text += '\n';
        text += "Array sorted by Quick Sort method:";
        text += '\n';
        for (int i = 0; i < arrayForSort.length; i++) {
            text += arrayForSort[i] + " ";
        }
        text += '\n' + "Permutation: " + permutation + '\n';
        text += "Comparison: " + comparison + '\n';
        MatrixQuickText.setText(text);
    }
    public void onRefreshButtonClick (android.view.View view) {
        if (size == 0) {
            text = "The array is empty. Create it!";
            MatrixQuickText.setText(text);
            QuickSortButton.setClickable(false);
        }
        else {
            arrayForSort = new int[size];
            text = "Your array: ";
            for (int i = 0; i < array.length; i++) {
                text += array[i] + " ";
                arrayForSort[i] = array[i];
            }
            MatrixQuickText.setText(text);
            QuickSortButton.setClickable(true);
        }
    }
    private void QuickSort (int left, int right) {
        int temp;
        int i = left, j = right;
        int pivot = arrayForSort[(left + right) / 2];
        while (i <= j) {
            do {
                comparison++;
                if (arrayForSort[i] < pivot) {
                    i++;
                }
            } while (arrayForSort[i] < pivot);
            do {
                comparison++;
                if (arrayForSort[j] > pivot) {
                    j--;
                }
            } while (arrayForSort[j] > pivot);
            if (i <= j) {
                temp = arrayForSort[i];
                arrayForSort[i] = arrayForSort[j];
                arrayForSort[j] = temp;
                i++;
                j--;
                permutation++;
            }
        }
        if (left < j) {
            QuickSort(left, j);
        }
        if (i < right) {
            QuickSort(i, right);
        }
    }
}
