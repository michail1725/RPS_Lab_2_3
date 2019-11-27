package com.example.rps_lab_2_3;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

public class EnterMatrixActivity extends MainActivity {
    private String   text,
                     matrix;
    private EditText MatrixEnterText;
    private TextView EnterMatrixText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        MatrixEnterText = findViewById(R.id.MatrixEnterText);
        EnterMatrixText = findViewById(R.id.EnterMatrixText);
        EnterMatrixText.setMovementMethod(new ScrollingMovementMethod());
    }
    public void onEnterMatrixButtonClick(android.view.View view) {
        if (MatrixEnterText.getText().length() != 0) {
            matrix = MatrixEnterText.getText().toString();
            char[] chArray = matrix.toCharArray();
            size = matrix.length();
            array = new int[size];
            text = "Your array: ";
            for (int i = 0; i < array.length; i++) {
                array[i] = chArray[i] - 48;
                text += array[i] + " ";
            }
            EnterMatrixText.setText(text);
        }
        else {
            size = 0;
            text = "Array entering error!";
            EnterMatrixText.setText(text);
        }
    }
}
