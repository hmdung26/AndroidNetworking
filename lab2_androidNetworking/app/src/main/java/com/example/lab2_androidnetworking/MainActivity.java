package com.example.lab2_androidnetworking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public  static final String NameServer = "http://192.168.1.11/nguyenvanluc_PH29191/student_Get.php";
    Button btn_get;
    EditText ed_name,ed_score;
    TextView tv_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_get = findViewById(R.id.btn_get);
        ed_name = findViewById(R.id.ed_name);
        ed_score = findViewById(R.id.ed_score);
        tv_result = findViewById(R.id.tv_result);
        btn_get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = ed_name.getText().toString();
                String score = ed_score.getText().toString();
                BackgoundTask_GET backgoundTask_get = new BackgoundTask_GET(MainActivity.this,tv_result,name,score);
                backgoundTask_get.execute();
            }
        });

    }
}