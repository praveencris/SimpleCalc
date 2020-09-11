package com.sabkayar.praveen.simplecalc;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.sabkayar.praveen.simplecalc.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "CalculatorActivity";
    ActivityMainBinding mBinding;
    private Calculator mCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        // Initialize the calculator class and all the views
        mCalculator = new Calculator();
    }

    /**
     * OnClick method called when the add Button is pressed.
     */
    public void onAdd(View view) {
        compute(Calculator.Operators.ADD);
    }

    public void onSub(View view) {
        compute(Calculator.Operators.SUB);
    }

    public void onDiv(View view) {
        compute(Calculator.Operators.DIV);
    }

    public void onMul(View view) {
        compute(Calculator.Operators.MUL);
    }

    private void compute(Calculator.Operators operator) {
        double operandOne;
        double operandTwo;
        try {
            operandOne = getOperand(mBinding.firstNumber);
            operandTwo = getOperand(mBinding.secondNumber);
        } catch (NullPointerException | NumberFormatException e) {
            Log.e(TAG, e.getMessage(), e);
            mBinding.textViewResult.setText(getString(R.string.computationError));
            return;
        }

        String result;
        switch (operator) {
            case ADD:
                result = String.valueOf(mCalculator.add(operandOne, operandTwo));
                break;
            case SUB:
                result = String.valueOf(mCalculator.sub(operandOne, operandTwo));
                break;
            case DIV:
                result = String.valueOf(mCalculator.div(operandOne, operandTwo));
                break;
            case MUL:
                result = String.valueOf(mCalculator.mul(operandOne, operandTwo));
                break;
            default:
                result = getString(R.string.computationError);
                break;
        }
        mBinding.textViewResult.setText(result);
    }

    private double getOperand(EditText editText) throws NullPointerException, NumberFormatException {
        String operandString = editText.getText().toString();
        return Double.parseDouble(operandString);
    }
}