package com.example.mysignup;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.button.MaterialButton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        EditText username=(EditText)  findViewById(R.id.username);
        EditText useremail=(EditText)  findViewById(R.id.email);
        EditText userpassword=(EditText)  findViewById(R.id.password);
        MaterialButton regbtn=(MaterialButton)  findViewById(R.id.signupbtn);
        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=username.getText().toString();
                String email=useremail.getText().toString();
                String password=userpassword.getText().toString();
                OpenActivity2();

            }
        });
    }

    public void OpenActivity2()
    {
        Intent intent= new Intent(Activity1.this,Activity2.class);
        startActivity(intent);
    }
    private void Postdetails(String name,String email,String password)
    {
        Register register = new Register(name,email,password);
        ApiInterface apiInterface=RetrofitClient.getRetrofitInstance().create(ApiInterface.class);

        Call<Register> call = apiInterface.getUserInformation(register);
        call.enqueue(new Callback<Register>() {
            @Override
            public void onResponse(Call<Register> call, Response<Register> response) {
                Log.e(TAG, "onResponse: "+response.code());
                Log.e(TAG, "onResponse: "+response.body().getName());
                Log.e(TAG, "onResponse: "+response.body().getEmail());
                Log.e(TAG, "onResponse: "+response.body().getPassword());
            }

            @Override
            public void onFailure(Call<Register> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage());


            }
        });
    }
}