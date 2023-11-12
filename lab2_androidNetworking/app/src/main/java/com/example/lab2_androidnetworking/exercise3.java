package com.example.lab2_androidnetworking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class exercise3 extends AppCompatActivity {
    public  static final String NameServer = "http://192.168.1.11/nguyenvanluc_PH29191/canh_Post.php";
    Button btn_postC;
    EditText ed_canh;
    TextView tv_resultTT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise3);
        btn_postC = findViewById(R.id.btn_postC);
        ed_canh = findViewById(R.id.ed_canh);
        tv_resultTT = findViewById(R.id.tv_resultTT);
        btn_postC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String canh = ed_canh.getText().toString();
                backgoundTask_POSTC backgoundTask_postc = new backgoundTask_POSTC(exercise3.this, canh , tv_resultTT);
                backgoundTask_postc.execute();
            }
        });
    }
}