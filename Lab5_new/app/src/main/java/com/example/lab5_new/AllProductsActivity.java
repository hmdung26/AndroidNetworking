package com.example.lab5_new;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllProductsActivity extends AppCompatActivity {
  private ListView lstview;
  private List<SPModel> lst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_products);

        lstview = findViewById(R.id.listProducts);


        callApiGetSP();
    }


    private void callApiGetSP(){
        APISERVICE.Apiservicee.getallSP().enqueue(new Callback<List<SPModel>>() {
            @Override
            public void onResponse(Call<List<SPModel>> call, Response<List<SPModel>> response) {

                if (response.isSuccessful()) {
                    lst = response.body();
                    lst = response.body();
                    AdapterProduct adapterProduct = new AdapterProduct(AllProductsActivity.this,lst);
                    lstview.setAdapter(adapterProduct);
                } else {
                    Log.e("API_CALL_ERROR", "Error code: " + response.code());
                    Toast.makeText(AllProductsActivity.this, "Thất Bại", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<SPModel>> call, Throwable t) {
                Log.e("API_CALL_ERROR", "Error code: "  + t.getMessage());
                Toast.makeText(AllProductsActivity.this, "Thất Bại Quá Thất bại", Toast.LENGTH_SHORT).show();
            }
        });
    }


}