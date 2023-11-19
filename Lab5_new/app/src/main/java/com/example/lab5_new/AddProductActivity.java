package com.example.lab5_new;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddProductActivity extends AppCompatActivity {


    private List<SPModel> lst;
    private EditText edtName, edtPrice, edtDescription;
    private Button btnAdd;
    String strName,strPrice,strDes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        edtName = (EditText)findViewById(R.id.edtProductName);
        edtPrice = (EditText)findViewById(R.id.edtProductPrice);
        edtDescription = (EditText)findViewById(R.id.edtProductDes);
        btnAdd = (Button)findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override


            public void onClick(View view) {
                strName = edtName.getText().toString();
                strPrice = edtPrice.getText().toString();
                strDes = edtDescription.getText().toString();


                callApAddSP(strName,strPrice,strDes);
            }
        });



    }


    private void callApAddSP(String edtten, String edtgia, String edtdex){

        AddSp addSp = new AddSp(edtten,edtgia,edtdex);
        APISERVICE.Apiservicee.addSP(addSp).enqueue(new Callback<AddSp>() {
            @Override
            public void onResponse(Call<AddSp> call, Response<AddSp> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(AddProductActivity.this, "Oke", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(AddProductActivity.this,
                            MainActivity.class);
                    startActivity(intent);
                } else {
                    Log.e("API_CALL_ERROR", "Error code: " + response.code());
                    Toast.makeText(AddProductActivity.this, "Thất Bại", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AddSp> call, Throwable t) {
                Log.e("API_CALL_ERROR", "Error: " + t.getMessage());

                Toast.makeText(AddProductActivity.this,"Thất Bại",Toast.LENGTH_SHORT).show();
            }
        });
    }
}