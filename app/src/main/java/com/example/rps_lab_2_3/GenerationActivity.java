package com.example.rps_lab_2_3;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class GenerationActivity extends MainActivity {
    private String[]             genTypes = {"Full Random", "Almost Sorted", "Sorted"};
    private String               text;
    private Spinner              GenTypeSpinner;
    private ArrayAdapter<String> adapter;
    private EditText             MatrixSizeText;
    private TextView             MatrixText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generation);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        GenTypeSpinner = findViewById(R.id.GenTypeSpinner);
        adapter        = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, genTypes);
        MatrixSizeText = findViewById(R.id.MatrixSizeText);
        MatrixText     = findViewById(R.id.MatrixText);
        MatrixText.setMovementMethod(new ScrollingMovementMethod());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        GenTypeSpinner.setAdapter(adapter);
    }
    public void onGenerateButtonClick (android.view.View view) {
        if (MatrixSizeText.getText().length() != 0) {
            size = Integer.parseInt(MatrixSizeText.getText().toString());
            array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = (int) (1 + Math.random()*9);
            }
            if (GenTypeSpinner.getSelectedItem().toString() == "Full Random") {

            }
            else if (GenTypeSpinner.getSelectedItem().toString() == "Almost Sorted") {
                int tmp = 0;
                for (int i = 0; i < array.length; i++)
                {
                    for (int j = 0; j < array.length - 1; j++)
                    {
                        if (array[j] < array[j + 1])
                        {
                            tmp = array[j];
                            array[j] = array[j + 1];
                            array[j + 1] = tmp;
                        }
                    }
                }
            }
            else {
                int tmp = 0;
                for (int i = 0; i < array.length; i++)
                {
                    for (int j = 0; j < array.length - 1; j++)
                    {
                        if (array[j] > array[j + 1])
                        {
                            tmp = array[j];
                            array[j] = array[j + 1];
                            array[j + 1] = tmp;
                        }
                    }
                }
            }
            text = "Your array: ";
            for (int i = 0; i < array.length; i++) {
                text += array[i] + " ";
            }
            MatrixText.setText(text);
        }
        else {
            size = 0;
            text = "Array generation error!";
            MatrixText.setText(text);
        }
    }
}
