package com.example.mysignup;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("/api/v1/quotes/add")
    Call<Register> getUserInformation(@Body Register register);

    @GET("/api/v1/quotes/life")
    Call<ArrayList<Quotes>> getLifeQuotes();

    @GET("/api/v1/quotes/women")
    Call<ArrayList<Quotes>> getWomenQuotes();

    @GET("/api/v1/quotes/motivational")
    Call<ArrayList<Quotes>> getMotivationalQuotes();

    @GET("/api/v1/quotes/wisdom")
    Call<ArrayList<Quotes>> getWisdomQuotes();

    @GET("/api/v1/quotes/emotional")
    Call<ArrayList<Quotes>> getEmotionalQuotes();

}
