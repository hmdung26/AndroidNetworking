package com.example.sidle4_mob403;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.sidle4_mob403.adapter.adapterPhoto;
import com.example.sidle4_mob403.asnycTask.AsnycTask_PhotoHTTP;

public class MainActivity extends AppCompatActivity {
    public  static final String NameServer = "http://10.24.33.7/silde4_androidNetworking/photo.json";
    RecyclerView rcv_photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcv_photo = findViewById(R.id.rcv_photo);
        AsnycTask_PhotoHTTP asnycTask_photoHTTP =  new AsnycTask_PhotoHTTP(MainActivity.this,rcv_photo);
        asnycTask_photoHTTP.execute();
    }
}