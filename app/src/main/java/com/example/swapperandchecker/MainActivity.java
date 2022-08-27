package com.example.swapperandchecker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.registration.MESSAGE";
    EditText String1, String2;
    Button swap,check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String1 = (EditText) findViewById(R.id.editTextTextPersonName);
        String2 = (EditText) findViewById(R.id.editTextTextPersonName2);
        swap=findViewById(R.id.button);
        swap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstText, secondText, hold;
                firstText = String1.getText().toString();
                secondText = String2.getText().toString();
                String1.setText(secondText);
                String2.setText(firstText);
            }
        });
        check=findViewById(R.id.button2);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Chcker();
            }
        });
    }
    private String isChecked = "";
    public void Chcker() {
        boolean checkString = String1.getText().toString().equals(String2.getText().toString());
        if (checkString)
            isChecked = "SAME";
        else
            isChecked = "NOT THE SAME";

        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra(EXTRA_MESSAGE, isChecked);
        startActivity(intent);
    }
}