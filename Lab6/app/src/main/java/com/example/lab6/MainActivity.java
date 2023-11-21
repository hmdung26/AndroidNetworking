package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtFC;
    Button btnF, btnC;
    String strFC;
    TextView tvResult;
    int convertStyle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtFC = findViewById(R.id.edtC);
        btnF = (Button) findViewById(R.id.btnF);
        btnC = (Button) findViewById(R.id.btnC);
        tvResult = (TextView) findViewById(R.id.tvResult);
        btnF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                invokeAsyncTask("Fahrenheit", Constants.F_TO_C_SOAP_ACTION,
                        Constants.F_TO_C_METHOD_NAME);
                convertStyle = 1;
            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                invokeAsyncTask("Celsius", Constants.C_TO_F_SOAP_ACTION,
                        Constants.C_TO_F_METHOD_NAME);
                convertStyle = 0;
            }
        });

    }
    private void invokeAsyncTask(String convertParams, String soapAction,
                                 String methodName) {
        new ConvertTemperatureTask(this, soapAction, methodName,
                convertParams).execute(edtFC.getText().toString().trim());
        strFC = edtFC.getText().toString().trim();
        Log.i("Text",strFC);
    }



    public void callBackDataFromAsyncTask(String result) {
        double resultTemperature = Double.parseDouble(result); //parse String to double
        if (convertStyle == 0) {// C degree to F degree
            tvResult.setText(edtFC.getText().toString().trim() + " degree Celsius = "
                            + String.format("%.2f", resultTemperature) + " degree Fahrenheit");
        } else {// F degree to C degree
            tvResult.setText(edtFC.getText().toString().trim() + " degree Fahrenheit = "
                            + String.format("%.2f", resultTemperature) + " degree Celsius");
        }
    }


    }
