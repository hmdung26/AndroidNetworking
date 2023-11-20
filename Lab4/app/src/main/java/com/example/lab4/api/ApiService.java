package com.example.lab4.api;

import com.example.lab4.model.auth;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {


    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

ApiService api = new Retrofit.Builder().baseUrl("http://192.168.0.101:3000/").addConverterFactory(GsonConverterFactory.create(gson)).build().create(ApiService.class);



    @POST("signin")
    Call<auth> checkSignIn(@Body auth Auth);

    @POST("reg")
    Call<auth> postU(@Body auth Auth);


}
