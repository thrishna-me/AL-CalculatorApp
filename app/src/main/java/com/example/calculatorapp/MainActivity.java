package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    boolean isNewOp = true;
    String oldNumber;
    String operator = "+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);


    }

    public void numberPressed(View view) {
        if (isNewOp) {editText.setText("");}
        isNewOp = false;
        String number = editText.getText().toString();
        switch (view.getId()) {
            case R.id.buttonNine:
                number += 9;
                break;
            case R.id.buttonEight:
                number += 8;
                break;
            case R.id.buttonSeven:
                number += 7;
                break;
            case R.id.buttonSix:
                number += 6;
                break;
            case R.id.buttonFive:
                number += 5;
                break;
            case R.id.buttonFour:
                number += 4;
                break;
            case R.id.buttonThree:
                number += 3;
                break;
            case R.id.buttonTwo:
                number += 2;
                break;
            case R.id.buttonOne:
                number += 1;
                break;
            case R.id.buttonZero:
                number += 0;
                break;
            case R.id.buttonDot:
                number += ".";
                break;
            case R.id.buttonPlusMinus:
                number = "-" + number;
                break;
        }
        editText.setText(number);
    }

    public void operatorPressed(View view) {
        isNewOp = true;
        oldNumber = editText.getText().toString();
        switch (view.getId()) {
            case R.id.buttonDivide:
                operator = "/";
                break;
            case R.id.buttonMultiply:
                operator = "*";
                break;
            case R.id.buttonMinus:
                operator = "-";
                break;
            case R.id.buttonPlus:
                operator = "+";
                break;
        }
    }

    public void equalPressed(View view) {
        String newNumber = editText.getText().toString();
        double result = 0.0;
        switch (operator) {
            case "/":
                result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
                break;
            case "*":
                result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
                break;
            case "-":
                result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
                break;
            case "+":
                result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
                break;
        }
        editText.setText(result + "");
    }

    public void acPressed(View view) {
        editText.setText("0");
        isNewOp = true;
    }

    public void percentPressed(View view) {
        double percent = Double.parseDouble(editText.getText().toString()) / 100;
        editText.setText(percent + "");
        isNewOp = true;
    }
}