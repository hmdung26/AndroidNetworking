package com.example.lab5_new;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnVieww, btnAddPro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnVieww = findViewById(R.id.btnview);
        btnAddPro = findViewById(R.id.btnADDNew);

        btnVieww.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,
                        AllProductsActivity.class);
                startActivity(intent);
            }
        });

        btnAddPro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,
                        AddProductActivity.class);
                startActivity(intent);
            }
        });


    }
}