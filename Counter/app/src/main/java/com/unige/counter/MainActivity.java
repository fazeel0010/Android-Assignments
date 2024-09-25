package com.unige.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView valueText;
    EditText counterStep;

    int mainValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        valueText = findViewById(R.id.value1);
        counterStep = findViewById(R.id.numberStep);
    }

    public void minus(View view) {
        String counter = counterStep.getText().toString().trim();
        mainValue -= (counter.isEmpty()) ? 0 : Integer.parseInt(counter);
        valueText.setText(String.valueOf(mainValue));
    }

    public void plus(View view) {
        String counter = counterStep.getText().toString();
        mainValue += (counter.isEmpty()) ? 0 : Integer.parseInt(counter.trim());
        valueText.setText(String.valueOf(mainValue));
    }
}