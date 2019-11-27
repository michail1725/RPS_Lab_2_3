package com.example.rps_lab_2_3;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Arrays;

public class SimulationActivity extends MainActivity {
    private String[]             genTypes = {"Full Random", "Almost Sorted", "Sorted"},
                                 entTypes = {"Generation Array", "Enter Array"};
    private String               text,
                                 matrix;
    private Spinner              GenTypeSpinner,
                                 EntTypeSpinner;
    private ArrayAdapter<String> Genadapter,
                                 Entadapter;
    private TextView             choiceGenTypeText,
                                 MatrixSimText,
                                 MatrixSizeText,
                                 MatrixText,
                                 MatrixSizeSimText;
    private Switch               BubbleSwitch,
                                 MergeSwitch,
                                 QuickSwitch;
    private int                  comparisonBubble  = 0,
                                 permutationBubble = 0,
                                 comparisonMerge   = 0,
                                 permutationMerge  = 0,
                                 comparisonQuick   = 0,
                                 permutationQuick  = 0;
    private int[]                arrayBubble,
                                 arrayMerge,
                                 arrayQuick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulation);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        GenTypeSpinner       = findViewById(R.id.GenTypeSpinner);
        EntTypeSpinner       = findViewById(R.id.EntTypeSpinner);
        choiceGenTypeText    = findViewById(R.id.ChoiceGenTypeText);
        MatrixSizeSimText    = findViewById(R.id.MatrixSizeSimText);
        MatrixText           = findViewById(R.id.MatrixText);
        MatrixSimText        = findViewById(R.id.MatrixSimText);
        MatrixSizeText       = findViewById(R.id.MatrixSizeText);
        BubbleSwitch         = findViewById(R.id.BubbleSwitch);
        MergeSwitch          = findViewById(R.id.MergeSwitch);
        QuickSwitch          = findViewById(R.id.QuickSwitch);
        Genadapter           = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, genTypes);
        Entadapter           = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, entTypes);
        Genadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Entadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        MatrixText.setMovementMethod(new ScrollingMovementMethod());
        GenTypeSpinner.setAdapter(Genadapter);
        EntTypeSpinner.setAdapter(Entadapter);
        EntTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, android.view.View view, int position, long id) {
                if (EntTypeSpinner.getSelectedItem().toString() == "Enter Array") {
                    GenTypeSpinner.setVisibility(android.view.View.INVISIBLE);
                    MatrixSizeSimText.setVisibility(android.view.View.INVISIBLE);
                    MatrixSizeText.setVisibility(android.view.View.INVISIBLE);
                    MatrixSimText.setVisibility(android.view.View.VISIBLE);
                    choiceGenTypeText.setText("Enter matrix:");
                }
                else {
                    GenTypeSpinner.setVisibility(android.view.View.VISIBLE);
                    MatrixSizeSimText.setVisibility(android.view.View.VISIBLE);
                    MatrixSizeText.setVisibility(android.view.View.VISIBLE);
                    MatrixSimText.setVisibility(android.view.View.INVISIBLE);
                    choiceGenTypeText.setText("Choice generation type:");
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
    }
    public void onSimulateButtonClick (android.view.View view) {
        if (MatrixSizeSimText.getText().length() != 0 || MatrixSimText.getText().length() != 0) {
            if (EntTypeSpinner.getSelectedItem().toString() == "Generation Array") {
                size = Integer.parseInt(MatrixSizeSimText.getText().toString());
                array = new int[size];
                for (int i = 0; i < size; i++) {
                    array[i] = (int) (1 + Math.random()*9);
                }
                if (GenTypeSpinner.getSelectedItem().toString() == "Full Random") {
                }
                else if (GenTypeSpinner.getSelectedItem().toString() == "Almost Sorted") {
                    int tmp = 0;
                    for (int i = 0; i < array.length; i++) {
                        for (int j = 0; j < array.length - 1; j++) {
                            if (array[j] < array[j + 1]) {
                                tmp = array[j];
                                array[j] = array[j + 1];
                                array[j + 1] = tmp;
                            }
                        }
                    }
                }
                else {
                    int tmp = 0;
                    for (int i = 0; i < array.length; i++) {
                        for (int j = 0; j < array.length - 1; j++) {
                            if (array[j] > array[j + 1]) {
                                tmp = array[j];
                                array[j] = array[j + 1];
                                array[j + 1] = tmp;
                            }
                        }
                    }
                }
                arrayBubble = new int[size];
                arrayMerge  = new int[size];
                arrayQuick  = new int[size];
                text = "Your array: ";
                for (int i = 0; i < array.length; i++) {
                    text += array[i] + " ";
                    arrayBubble[i] = array[i];
                    arrayMerge[i]  = array[i];
                    arrayQuick[i]  = array[i];
                }
            }
            else {
                matrix         = MatrixSimText.getText().toString();
                char[] chArray = matrix.toCharArray();
                size           = matrix.length();
                array          = new int[size];
                arrayBubble    = new int[size];
                arrayMerge     = new int[size];
                arrayQuick     = new int[size];
                text = "Your array: ";
                for (int i = 0; i < array.length; i++) {
                    array[i] = chArray[i] - 48;
                    text += array[i] + " ";
                    arrayBubble[i] = array[i];
                    arrayMerge[i]  = array[i];
                    arrayQuick[i]  = array[i];
                }
            }
            if (BubbleSwitch.isChecked()) {
                int tmp = 0;
                for (int i = 0; i < arrayBubble.length; i++)
                {
                    for (int j = 0; j < arrayBubble.length - 1; j++)
                    {
                        comparisonBubble++;
                        if (arrayBubble[j] > arrayBubble[j + 1])
                        {
                            tmp = arrayBubble[j];
                            arrayBubble[j] = arrayBubble[j + 1];
                            arrayBubble[j + 1] = tmp;
                            permutationBubble++;
                        }
                    }
                }
                text += '\n';
                text += "Array sorted by Bubble Sort method: ";
                text += '\n' + "    ";
                for (int i = 0; i < arrayBubble.length; i++) {
                    text += arrayBubble[i] + " ";
                }
                text += '\n' + "    Permutation: " + permutationBubble + '\n';
                text += "   Comparison: " + comparisonBubble + '\n';
            }
            if (MergeSwitch.isChecked()) {
                arrayMerge = Sort(arrayMerge);
                text += '\n';
                text += "Array sorted by Merge Sort method: ";
                text += '\n' + "    ";
                for (int i = 0; i < arrayMerge.length; i++) {
                    text += arrayMerge[i] + " ";
                }
                text += '\n' + "    Permutation: " + permutationMerge + '\n';
                text += "   Comparison: " + comparisonMerge + '\n';
            }
            if (QuickSwitch.isChecked()) {
                QuickSort(0, arrayQuick.length - 1);
                text += '\n';
                text += "Array sorted by Quick Sort method: ";
                text += '\n'  + "    ";
                for (int i = 0; i < arrayQuick.length; i++) {
                    text += arrayQuick[i] + " ";
                }
                text += '\n' + "    Permutation: " + permutationQuick + '\n';
                text += "   Comparison: " + comparisonQuick + '\n';
            }
            if (permutationBubble < permutationQuick) {
                if (permutationBubble < permutationMerge) {
                    text += "Bubble sorting is most effective.";
                }
                else {
                    text += "Merge sorting is most effective.";
                }
            }
            else {
                if (permutationQuick < permutationMerge) {
                    text += "Quick sort is most effective.";
                }
                else {
                    text += "Merge sorting is most effective.";
                }
            }
            MatrixText.setText(text);
        }
        else {
            text = "Simulation error!";
            MatrixText.setText(text);
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
            comparisonQuick++;
            if (b < len_2 && a < len_1) {
                comparisonMerge++;
                if (arr_1[a] > arr_2[b]){
                    permutationMerge++;
                    result[i] = arr_2[b++];
                }
                else {
                    permutationMerge++;
                    result[i] = arr_1[a++];
                }
            }
            else if (b < len_2) {
                comparisonMerge++;
                permutationMerge++;
                result[i] = arr_2[b++];
            }
            else {
                comparisonMerge++;
                permutationMerge++;
                result[i] = arr_1[a++];
            }
        }
        return result;
    }
    private void QuickSort (int left, int right) {
        int temp;
        int i = left, j = right;
        int pivot = arrayQuick[(left + right) / 2];
        while (i <= j) {
            do {
                comparisonQuick++;
                if (arrayQuick[i] < pivot) {
                    i++;
                }
            } while (arrayQuick[i] < pivot);
            do {
                comparisonQuick++;
                if (arrayQuick[j] > pivot) {
                    j--;
                }
            } while (arrayQuick[j] > pivot);
            if (i <= j) {
                temp = arrayQuick[i];
                arrayQuick[i] = arrayQuick[j];
                arrayQuick[j] = temp;
                i++;
                j--;
                permutationQuick++;
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
