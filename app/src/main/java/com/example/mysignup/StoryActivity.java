package com.example.mysignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StoryActivity extends AppCompatActivity {


    private TextView story;
    private TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        story = findViewById(R.id.storyTextView);
        title = findViewById(R.id.titleTextView);

        Intent intent = getIntent();
        if(intent != null)
        {
            story.setText(intent.getStringExtra("story"));
            title.setText(intent.getStringExtra("title"));
        }


    }
}