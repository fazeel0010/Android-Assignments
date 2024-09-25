package com.unige.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String _inputText = "0";
    TextView _displayTextView;

    boolean isEqualPress = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _displayTextView = findViewById(R.id.textDis);
    }

    public void Operations(View view) {
        char lastText = ' ';
        if (_inputText.length() > 0)
            lastText = _inputText.charAt(_inputText.length() - 1);
        switch (view.getId()) {
            case R.id.plus:
                if (canWeAddOperatorAtLast('+')) {
                    _inputText += "+";
                    isEqualPress = false;
                }
                break;
            case R.id.minus:
                if (canWeAddOperatorAtLast('-')) {
                    _inputText += "-";
                    isEqualPress = false;
                }
                break;
            case R.id.multiply:
                if (canWeAddOperatorAtLast('*')) {
                    _inputText += "*";
                    isEqualPress = false;
                }
                break;
            case R.id.divide:
                if (canWeAddOperatorAtLast('/')) {
                    _inputText += "/";
                    isEqualPress = false;
                }
                break;
            case R.id.equal:
                if (_inputText.contains("+") && !isAnyOperatorAtLast()) {
                    String[] values = _inputText.split("\\+");
                    _inputText = String.valueOf(Double.parseDouble(values[0]) + Double.parseDouble((values[1])));
                    isEqualPress = true;
                } else if (_inputText.contains("-") && !isAnyOperatorAtLast()) {
                    String[] values = _inputText.split("-");
                    _inputText = String.valueOf(Double.parseDouble(values[0]) - Double.parseDouble((values[1])));
                    isEqualPress = true;
                } else if (_inputText.contains("*") && !isAnyOperatorAtLast()) {
                    String[] values = _inputText.split("\\*");
                    _inputText = String.valueOf(Double.parseDouble(values[0]) * Double.parseDouble(values[1]));
                    isEqualPress = true;
                } else if (_inputText.contains("/") && !isAnyOperatorAtLast()) {
                    String[] values = _inputText.split("/");
                    _inputText = String.valueOf((Double.parseDouble(values[0]) / Double.parseDouble(values[1])));
                    isEqualPress = true;
                }
                break;
            case R.id.clear:
                UpdateToDisplay(_inputText = "0");
                break;
        }
        UpdateToDisplay();
    }


    public void Numbers(View view) {
        isEqualPressThenSetTo0();
        switch (view.getId()) {
            case R.id.zero:
                if (!_inputText.startsWith("0") || _inputText.contains("0."))
                    _inputText += "0";
                break;
            case R.id.no1:
                isZeroAtStartThenRemove();
                _inputText += "1";
                break;
            case R.id.no2:
                isZeroAtStartThenRemove();
                _inputText += "2";
                break;
            case R.id.no3:
                isZeroAtStartThenRemove();
                _inputText += "3";
                break;
            case R.id.no4:
                isZeroAtStartThenRemove();
                _inputText += "4";
                break;
            case R.id.no5:
                isZeroAtStartThenRemove();
                _inputText += "5";
                break;
            case R.id.no6:
                isZeroAtStartThenRemove();
                _inputText += "6";
                break;
            case R.id.no7:
                isZeroAtStartThenRemove();
                _inputText += "7";
                break;
            case R.id.no8:
                isZeroAtStartThenRemove();
                _inputText += "8";
                break;
            case R.id.no9:
                isZeroAtStartThenRemove();
                _inputText += "9";
                break;
            case R.id.dot:
                if (!_inputText.contains("."))
                    _inputText += ".";
                break;
        }
        UpdateToDisplay();
    }

    private void UpdateToDisplay(String text) {
        _displayTextView.setText(text);
    }

    private void UpdateToDisplay() {
        _displayTextView.setText(_inputText);
    }

    private boolean isAnyOperatorAtLast() {
        char lastText = ' ';
        if (_inputText.length() > 0)
            lastText = _inputText.charAt(_inputText.length() - 1);
        return lastText == '-' || lastText == '*' || lastText == '+' || lastText == '/';
    }

    private boolean isAnyOperatorAtLastExcept(String operator) {
        char lastText = ' ';
        if (_inputText.length() > 0)
            lastText = _inputText.charAt(_inputText.length() - 1);
        return lastText == '-' || lastText == '*' || lastText == '+' || lastText == '/';
    }

    private boolean isAnyOperatorInText(String operator) {
        return _inputText.contains(operator);
    }

    private boolean canWeAddOperatorAtLast(char currentOperator) {
        if (_inputText.startsWith("0") && !_inputText.contains("."))
            return false;
        char lastText = ' ';
        if (_inputText.length() > 0) {
            lastText = _inputText.charAt(_inputText.length() - 1);
        }
        boolean isOkay = true;
        if (lastText == '-' || lastText == '*' || lastText == '+' || lastText == '/') {
            isOkay = false;
            if (currentOperator != lastText) {
                _inputText= _inputText.substring(0,_inputText.length()-1);
                isOkay = true;
            }
        }

        if (_inputText.length() >= 3) {
            String value = _inputText.substring(0, _inputText.length() - 1);
            if (value.contains("-") || value.contains("+") || value.contains("/") || value.contains("*"))
                isOkay = false;
        }
        return isOkay;
    }

    private boolean isAnyOperatorInText() {
        return _inputText.contains("-") || _inputText.contains("+") || _inputText.contains("/") || _inputText.contains("*");
    }

    private void isZeroAtStartThenRemove() {
        if (_inputText.length() == 1 && _inputText.startsWith("0")) _inputText = "";
    }

    private void isEqualPressThenSetTo0() {
        if (isEqualPress) {
            isEqualPress = false;
            _inputText = "0";
        }
    }
}
