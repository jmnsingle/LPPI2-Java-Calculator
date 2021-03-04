package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Boolean isNewOperator = true;
    EditText editText;
    String operator = "+";
    String oldNumber = "";
    String numberInMemory = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
    }

    public void setNumberEvent(View view) {
        if (isNewOperator) {
            editText.setText("");
        }
        isNewOperator = false;

        String number = editText.getText().toString();

        switch (view.getId()) {
            case R.id.btnNine:
                number += "9";
                break;
            case R.id.btnEight:
                number += "8";
                break;
            case R.id.btnSeven:
                number += "7";
                break;
            case R.id.btnSix:
                number += "6";
                break;
            case R.id.btnFive:
                number += "5";
                break;
            case R.id.btnFour:
                number += "4";
                break;
            case R.id.btnThree:
                number += "3";
                break;
            case R.id.btnTwo:
                number += "2";
                break;
            case R.id.btnOne:
                number += "1";
                break;
            case R.id.btnZero:
                number += "0";
                break;
            case R.id.btnPlusMinus:
                number = "-"+ number;
                break;
            case R.id.btnDot:
                number += ".";
                break;
        }

        editText.setText(number);
    }

    public void clearDisplay(View view) {
        isNewOperator = true;
        editText.setText("0");
    }

    public void setOperatorEvent(View view) {
        isNewOperator = true;
        oldNumber = editText.getText().toString();
        switch (view.getId()) {
            case R.id.btnPlus :
                operator = "+";
                break;
            case R.id.btnMinus :
                operator = "-";
                break;
            case R.id.btnMultiply :
                operator = "*";
                break;
            case R.id.btnDivide :
                operator = "/";
                break;
        }
    }

    public void setResult(View view) {
        String newNumber = editText.getText().toString();
        Double result = 0.0;
        switch (operator) {
            case "+":
                result = Double.parseDouble(oldNumber) + Double.parseDouble((newNumber));
                break;
            case "-":
                result = Double.parseDouble(oldNumber) - Double.parseDouble((newNumber));
                break;
            case "*":
                result = Double.parseDouble(oldNumber) * Double.parseDouble((newNumber));
                break;
            case "/":
                result = Double.parseDouble(oldNumber) / Double.parseDouble((newNumber));
                break;
        }

        isNewOperator = true;
        editText.setText(result.toString());
    }

    public void setPercentResult(View view) {
        Double result = 0.0;
        result = Double.parseDouble(editText.getText().toString()) / 100;

        // isNewOperator = true;
        editText.setText(result.toString());
    }

    public void clearMemory(View view) {
        numberInMemory = "0";
        System.out.println(numberInMemory);
    }

    public void getResultFromMemory(View view) {
        editText.setText(numberInMemory);
    }

    public void setSubtractNumberFromMemory(View view) {
        Double result = 0.0;
        result = Double.parseDouble(numberInMemory.toString()) - Double.parseDouble(editText.getText().toString());
        numberInMemory = result.toString();
        System.out.println(numberInMemory);
    }

    public void setSumNumberFromMemory(View view) {
        Double result = 0.0;
        result = Double.parseDouble(numberInMemory.toString()) + Double.parseDouble(editText.getText().toString());
        numberInMemory = result.toString();
        System.out.println(numberInMemory);
    }
}