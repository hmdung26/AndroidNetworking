package com.example.lab2_androidnetworking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class exercise2 extends AppCompatActivity {
    public  static final String NameServer = "http://192.168.1.11/nguyenvanluc_PH29191/rectangle_Post.php";
    Button btn_post;
    EditText ed_cdai,ed_crong;
    TextView tv_resultDTCV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise2);
        btn_post = findViewById(R.id.btn_post);
        ed_cdai = findViewById(R.id.ed_cdai);
        ed_crong = findViewById(R.id.ed_crong);
        tv_resultDTCV = findViewById(R.id.tv_resultDTCV);
        btn_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cdai = ed_cdai.getText().toString();
                String crong = ed_crong.getText().toString();
                BackgroundTask_POST backgroundTask_post = new BackgroundTask_POST(exercise2.this , tv_resultDTCV , crong, cdai );
                backgroundTask_post.execute();
            }
        });
    }
}