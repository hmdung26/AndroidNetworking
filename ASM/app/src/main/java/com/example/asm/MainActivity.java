package com.example.asm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    RecyclerView reyc;
    Button btnadd;
    TextView tensp,giasp,motasp,soluongsp;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screenn);


        reyc =findViewById(R.id.recyclerView);
        btnadd = findViewById(R.id.floatbtnSanPham);
        reyc =findViewById(R.id.recyclerView);
        btnadd = findViewById(R.id.floatbtnSanPham);
        tensp = findViewById(R.id.idTenSanPham);
        giasp = findViewById(R.id.idGiaSanPham);
        motasp = findViewById(R.id.idMoTaSanPham);
        soluongsp = findViewById(R.id.idSoLuongSanpham);
    }
}