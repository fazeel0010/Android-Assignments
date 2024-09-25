package com.unige.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView flagImage;
    TextView flagtext;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        SetRadioGroup();
    }

    private void init() {
        radioGroup = findViewById(R.id.myRadioGroup);
        flagImage = findViewById(R.id.flagImage);
        flagtext = findViewById(R.id.textFlag);
    }

    private void SetRadioGroup() {
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.ukFlag:
                    flagImage.setImageDrawable(getResources().getDrawable(R.drawable.uk));
                    flagtext.setText(getResources().getString(R.string.UK));
                    break;
                case R.id.itFlag:
                    flagImage.setImageDrawable(getResources().getDrawable(R.drawable.it));
                    flagtext.setText(getResources().getString(R.string.It));
                    break;
                case R.id.esFlag:
                    flagImage.setImageDrawable(getResources().getDrawable(R.drawable.es));
                    flagtext.setText(getResources().getString(R.string.ES));
                    break;
                case R.id.frFlag:
                    flagImage.setImageDrawable(getResources().getDrawable(R.drawable.fr));
                    flagtext.setText(getResources().getString(R.string.FR));
                    break;
            }
        });
    }
}