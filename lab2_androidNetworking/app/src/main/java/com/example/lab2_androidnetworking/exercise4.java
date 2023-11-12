package com.example.lab2_androidnetworking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class exercise4 extends AppCompatActivity {
    public  static final String NameServer = "http://192.168.1.11/nguyenvanluc_PH29191/giaipt2_Post.php";
    Button btn_postPT2;
    EditText ed_a,ed_b, ed_c;
    TextView tv_resultPT2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise4);
        btn_postPT2 = findViewById(R.id.btn_postPT2);
        ed_a = findViewById(R.id.ed_a);
        ed_b = findViewById(R.id.ed_b);
        ed_c = findViewById(R.id.ed_c);
        tv_resultPT2 = findViewById(R.id.tv_resultPT2);
        btn_postPT2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = ed_a.getText().toString();
                String b = ed_b.getText().toString();
                String c = ed_c.getText().toString();
                    backgroundTask_POSTPT2 backgroundTask_postpt2 = new backgroundTask_POSTPT2(exercise4.this , tv_resultPT2);
                    backgroundTask_postpt2.execute(a,b,c);
            }
        });
    }
}