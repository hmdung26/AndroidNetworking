package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lab4.api.ApiService;
import com.example.lab4.model.auth;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class login extends AppCompatActivity {

    TextInputEditText edtUser, edtPass;
    Button btnSignIn;
    String edtuser,edtpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUser = findViewById(R.id.edtUsername_frame2);
        edtPass = findViewById(R.id.edtPassword_frame2);
        btnSignIn = findViewById(R.id.btnNext_frame2);


        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtpass = edtPass.getText().toString();
                edtuser = edtUser.getText().toString();

                SignIn(edtuser,edtpass);


            }
        });

    }



        private void SignIn(String userN, String passW){

            auth Auth = new auth(userN,null,passW);

            ApiService.api.checkSignIn(Auth).enqueue(new Callback<auth>() {
                @Override
                public void onResponse(Call<auth> call, Response<auth> response) {
                    Intent intent = new Intent(login.this,
                            MainActivity.class);
                    startActivity(intent);
                }

                @Override
                public void onFailure(Call<auth> call, Throwable t) {
                    Log.e("API_CALL_ERROR", "Error code: " + t.getMessage());
                    Toast.makeText(login.this, "Sign In Thất Bại", Toast.LENGTH_SHORT).show();
                }
            });


        }
}