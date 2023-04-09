package com.example.mysignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Activity2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Button lifeButton = (Button) findViewById(R.id.life);
        Button womenButton = (Button) findViewById(R.id.women);
        Button motivationalButton = (Button) findViewById(R.id.motivational);
        Button wisdomButton  = (Button) findViewById(R.id.wisdom);
        Button emotionalButton = (Button) findViewById(R.id.emotional);

        //life button
        lifeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fetchQuotes("Life");

            }
        });

        //women button
        womenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fetchQuotes("Women");

            }
        });

        // wisdom button

        wisdomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fetchQuotes("Wisdom");

            }
        });

        // emotional button

        emotionalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetchQuotes("Emotional");
            }
        });


        // motivational button
        motivationalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fetchQuotes("Motivational");

            }
        });



    }


    // fetchQuotes method
    public void fetchQuotes(String endpoint)
    {
        ApiInterface apiInterface = RetrofitClient.getRetrofitInstance().create(ApiInterface.class);
        Call<ArrayList<Quotes>> call = null;
        switch(endpoint) {
            case "Life":
                call = apiInterface.getLifeQuotes();
                break;

            case "Women":
                call = apiInterface.getWomenQuotes();
                break;

            case "Motivational":
                call = apiInterface.getMotivationalQuotes();
                break;

            case "Emotional":
                call = apiInterface.getEmotionalQuotes();
                break;

            case "Wisdom":
                call = apiInterface.getWisdomQuotes();
                break;

        }
        List<Quotes> quotesList = new ArrayList<Quotes>();

        if(call != null)
        {
            call.enqueue(new Callback<ArrayList<Quotes>>() {
                @Override
                public void onResponse(Call<ArrayList<Quotes>> call, Response<ArrayList<Quotes>> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        quotesList.addAll(response.body());
                        // print the quotes list in the console
                        ArrayList<String> Quotes = new ArrayList<>();
                        ArrayList<String> author = new ArrayList<>();
                        ArrayList<String> title = new ArrayList<>();
                        ArrayList<String> story = new ArrayList<>();
                        for (Quotes quote : quotesList) {
                            Quotes.add(quote.getQuotes());
                            author.add(quote.getAuthor());
                            title.add(quote.getTitle());
                            story.add(quote.getStory());
                        }
                        openLifeActivity(Quotes,author,title,story,endpoint);
                    }
                    else {
                        Log.e("Quote", "Failed to get quotes");
                    }
                }

                @Override
                public void onFailure(Call<ArrayList<Quotes>> call, Throwable t) {
                    Log.e("Quote", "Failed to get quotes", t);
                }
            });
        }



    }

    // open Activity
    public void openLifeActivity(ArrayList<String> Quotes,ArrayList<String> Author,ArrayList<String> Title,ArrayList<String> Story,String endpoint)
    {
        Intent intent = new Intent(this, LifeActivity.class);
        intent.putStringArrayListExtra("Quotes", Quotes);
        intent.putStringArrayListExtra("author", Author);
        intent.putStringArrayListExtra("title",Title);
        intent.putStringArrayListExtra("story",Story);
        intent.putExtra("head",endpoint);
        startActivity(intent);
    }
}