package com.example.rps_lab_2_3;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.Button;
import android.widget.TextView;

public class BubbleSortActivity extends MainActivity {
    private String   text;
    private TextView MatrixBubbleText;
    private Button   BubbleSortButton;
    private int      comparison = 0,
                     permutation = 0;
    private int[]    arrayForSort;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bubble);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        MatrixBubbleText = findViewById(R.id.MatrixBubbleText);
        MatrixBubbleText.setMovementMethod(new ScrollingMovementMethod());
        BubbleSortButton = findViewById(R.id.BubbleSortButton);
        if (size == 0) {
            text = "The array is empty. Create it!";
            MatrixBubbleText.setText(text);
            BubbleSortButton.setClickable(false);
        }
        else {
            arrayForSort = new int[size];
            text = "Your array: ";
            for (int i = 0; i < array.length; i++) {
                text += array[i] + " ";
                arrayForSort[i] = array[i];
            }
            MatrixBubbleText.setText(text);
            BubbleSortButton.setClickable(true);
        }
    }
    public void onBubbleSortButtonClick (android.view.View view) {
        int tmp = 0;
        for (int i = 0; i < arrayForSort.length; i++)
        {
            for (int j = 0; j < arrayForSort.length - 1; j++)
            {
                comparison++;
                if (arrayForSort[j] > arrayForSort[j + 1])
                {
                    tmp = arrayForSort[j];
                    arrayForSort[j] = arrayForSort[j + 1];
                    arrayForSort[j + 1] = tmp;
                    permutation++;
                }
            }
        }
        text += '\n';
        text += "Array sorted by Bubble Sort method:";
        text += '\n';
        for (int i = 0; i < arrayForSort.length; i++) {
            text += arrayForSort[i] + " ";
        }
        text += '\n' + "Permutation: " + permutation + '\n';
        text += "Comparison: " + comparison + '\n';
        MatrixBubbleText.setText(text);
    }
    public void onRefreshButtonClick (android.view.View view) {
        if (size == 0) {
            text = "The array is empty. Create it!";
            MatrixBubbleText.setText(text);
            BubbleSortButton.setClickable(false);
        }
        else {
            text = "Your array: ";
            arrayForSort = new int[size];
            text = "Your array: ";
            for (int i = 0; i < array.length; i++) {
                text += array[i] + " ";
                arrayForSort[i] = array[i];
            }
            MatrixBubbleText.setText(text);
            BubbleSortButton.setClickable(true);
            MatrixBubbleText.setText(text);
            BubbleSortButton.setClickable(true);
        }
    }
}
