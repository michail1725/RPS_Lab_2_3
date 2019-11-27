package com.example.rps_lab_2_3;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;

public class MergeSortActivity extends MainActivity {
    private String   text;
    private TextView MatrixMergeText;
    private Button   MergeSortButton;
    private int      comparison = 0,
                     permutation = 0;
    private int[]    arrayForSort;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merge);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        MatrixMergeText = findViewById(R.id.MatrixMergeText);
        MatrixMergeText.setMovementMethod(new ScrollingMovementMethod());
        MergeSortButton = findViewById(R.id.MergeSortButton);
        if (size == 0) {
            text = "The array is empty. Create it!";
            MatrixMergeText.setText(text);
            MergeSortButton.setClickable(false);
        }
        else {
            arrayForSort = new int[size];
            text = "Your array: ";
            for (int i = 0; i < array.length; i++) {
                text += array[i] + " ";
                arrayForSort[i] = array[i];
            }
            MatrixMergeText.setText(text);
            MergeSortButton.setClickable(true);
        }
    }
    public void onMergeSortButtonClick (android.view.View view) {
        arrayForSort = Sort(arrayForSort);
        text += '\n';
        text += "Array sorted by Merge Sort method:";
        text += '\n';
        for (int i = 0; i < arrayForSort.length; i++) {
            text += arrayForSort[i] + " ";
        }
        text += '\n' + "Permutation: " + permutation + '\n';
        text += "Comparison: " + comparison + '\n';
        MatrixMergeText.setText(text);
    }
    public void onRefreshButtonClick (android.view.View view) {
        if (size == 0) {
            text = "The array is empty. Create it!";
            MatrixMergeText.setText(text);
            MergeSortButton.setClickable(false);
        }
        else {
            arrayForSort = new int[size];
            text = "Your array: ";
            for (int i = 0; i < array.length; i++) {
                text += array[i] + " ";
                arrayForSort[i] = array[i];
            }
            MatrixMergeText.setText(text);
            MergeSortButton.setClickable(true);
        }
    }
    private int[] Sort(int[] arr) {
        int len = arr.length;
        if (len < 2) return arr;
        int middle = len / 2;
        return merge(Sort(Arrays.copyOfRange(arr, 0, middle)), Sort(Arrays.copyOfRange(arr, middle, len)));
    }
    private int[] merge(int[] arr_1, int[] arr_2) {
        int len_1 = arr_1.length, len_2 = arr_2.length;
        int a = 0, b = 0, len = len_1 + len_2;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            comparison++;
            if (b < len_2 && a < len_1) {
                comparison++;
                if (arr_1[a] > arr_2[b]){
                    permutation++;
                    result[i] = arr_2[b++];
                }
                else {
                    permutation++;
                    result[i] = arr_1[a++];
                }
            }
            else if (b < len_2) {
                comparison++;
                permutation++;
                result[i] = arr_2[b++];
            }
            else {
                comparison++;
                permutation++;
                result[i] = arr_1[a++];
            }
        }
        return result;
    }
}
