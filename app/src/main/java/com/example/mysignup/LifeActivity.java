package com.example.mysignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class LifeActivity extends AppCompatActivity {
    private int currentIndex = 0;
    private TextView quoteTextView;
    private TextView authorTextView;
    private Button previousButton;
    private Button nextButton;

    private Button story;

    private Button back;
    private ArrayList<String> quotesList = new ArrayList<>();

    private ArrayList<String> authorList = new ArrayList<>();

    private ArrayList<String> titleList = new ArrayList<>();

    private ArrayList<String> storyList = new ArrayList<>();
    private TextView quoteHead;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life);

        quoteHead = findViewById(R.id.quoteHead);
        Intent intent = getIntent();
        if (intent != null) {
            quotesList = intent.getStringArrayListExtra("Quotes");
            authorList = intent.getStringArrayListExtra("author");
            titleList = intent.getStringArrayListExtra("title");
            storyList = intent.getStringArrayListExtra("story");
            quoteHead.setText(intent.getStringExtra("head"));
        }



        // initializing
        quoteTextView = findViewById(R.id.quoteText);
        authorTextView = findViewById(R.id.authorName);
        previousButton = findViewById(R.id.previousButton);
        nextButton = findViewById(R.id.nextButton);
        back =  findViewById(R.id.goToActivity2);
        story = findViewById(R.id.storyButton);

        // Show the first quote
        quoteTextView.setText(quotesList.get(currentIndex));
        authorTextView.setText(authorList.get(currentIndex));

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentIndex != 0)
                {
                    currentIndex--;
                    quoteTextView.setText(quotesList.get(currentIndex));
                    authorTextView.setText(authorList.get(currentIndex));
                }

            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentIndex < quotesList.size() - 1)
                {
                    currentIndex++;
                    quoteTextView.setText(quotesList.get(currentIndex));
                    authorTextView.setText(authorList.get(currentIndex));
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LifeActivity.this, Activity2.class);
                startActivity(intent);
            }
        });

        story.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LifeActivity.this,StoryActivity.class);
                intent.putExtra("title",titleList.get(currentIndex));
                intent.putExtra("story",storyList.get(currentIndex));
                startActivity(intent);
            }
        });

    }

}
