package com.example.cricketchips;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Formatter;
import java.util.Locale;

public class MainActivity<formatter> extends AppCompatActivity {
    EditText editText;
    TextView tvResults;
    Button btnCalc;

    DecimalFormat formatter = new DecimalFormat("#0.00");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.et_enterNum);
        tvResults = findViewById(R.id.tv_crk);
        btnCalc = findViewById(R.id.btn);

        //sets tvResult invisible before user input
        tvResults.setVisibility(View.GONE);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userInput = editText.getText().toString();
                Log.d("MainActivity","Temp entered " + userInput);

                if (userInput.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter the temp", Toast.LENGTH_SHORT).show();
                }
                else{
                    int chips = Integer.parseInt(userInput.trim());
                    double temp = (chips/3.0) + 4;
                    String results = "The approximate temp is " + formatter.format(temp) + " degree celsius";
                    tvResults.setText(results);
                    //tvResults visible when button clicked
                    tvResults.setVisibility(View.VISIBLE);
                }


            }
        });
    }
}