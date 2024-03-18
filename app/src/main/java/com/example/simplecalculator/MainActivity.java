package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);

//        Set OnClickListener for number Buttons
        findViewById(R.id.button_0).setOnClickListener(v -> appendToEditText("0"));
        findViewById(R.id.button_1).setOnClickListener(v -> appendToEditText("1"));
        findViewById(R.id.button_2).setOnClickListener(v -> appendToEditText("2"));
        findViewById(R.id.button_3).setOnClickListener(v -> appendToEditText("3"));
        findViewById(R.id.button_4).setOnClickListener(v -> appendToEditText("4"));
        findViewById(R.id.button_5).setOnClickListener(v -> appendToEditText("5"));
        findViewById(R.id.button_6).setOnClickListener(v -> appendToEditText("6"));
        findViewById(R.id.button_7).setOnClickListener(v -> appendToEditText("7"));
        findViewById(R.id.button_8).setOnClickListener(v -> appendToEditText("8"));
        findViewById(R.id.button_9).setOnClickListener(v -> appendToEditText("9"));

        findViewById(R.id.button_add).setOnClickListener(v -> appendToEditText("+"));
        findViewById(R.id.button_subtract).setOnClickListener(v -> appendToEditText("-"));
        findViewById(R.id.button_divide).setOnClickListener(v -> appendToEditText("/"));
        findViewById(R.id.button_multiply).setOnClickListener(v -> appendToEditText("*"));

        findViewById(R.id.button_clear).setOnClickListener(v -> editText.setText(""));

        findViewById(R.id.button_equal).setOnClickListener(v -> calculate());


    }

    private void calculate() {
        try {
            String input = editText.getText().toString();

//            Create an Expression using ExpressionBuilder
            Expression expression = new ExpressionBuilder(input).build();

            double result = expression.evaluate();

            editText.setText(Double.toString(result));
        } catch (Exception e) {
            editText.setText("Error");
        }
    }

    private void appendToEditText(String value) {
        editText.append(value);
    }
}