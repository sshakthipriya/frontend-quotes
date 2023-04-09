package com.example.mysignup;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public static Retrofit retrofit;


    public static Retrofit getRetrofitInstance()
    {
        if(retrofit==null)
        {
            retrofit = new Retrofit.Builder().baseUrl("https://33e6-49-205-83-112.ngrok-free.app/").addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
