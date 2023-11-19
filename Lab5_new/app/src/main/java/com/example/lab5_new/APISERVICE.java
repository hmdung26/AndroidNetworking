package com.example.lab5_new;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APISERVICE {
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    APISERVICE Apiservicee = new Retrofit.Builder().baseUrl("http://192.168.0.103/Lab5_ph18450_android/").addConverterFactory(GsonConverterFactory.create(gson)).build().create(APISERVICE.class);


 @GET("get_all_producs.php")
    Call<List<SPModel>> getallSP();


 @POST("create_product.php")
    Call<AddSp> addSP(@Body AddSp addSp);


}
