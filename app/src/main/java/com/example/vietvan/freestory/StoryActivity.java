package com.example.vietvan.freestory;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class StoryActivity extends AppCompatActivity {

    private static final String TAG = "1";
    TextView title, content ,author;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Story story = (Story) getIntent().getSerializableExtra("topic");

        title = findViewById(R.id.title);
        content = findViewById(R.id.content);
        author = findViewById(R.id.author);
        Typeface typeface1
                = Typeface.createFromAsset(
                getAssets(), "SouthernAire_Personal_Use_Only.ttf");
        title.setTypeface(typeface1);
        Typeface typeface2
                = Typeface.createFromAsset(
                getAssets(), "ahsley.ttf");
        content.setTypeface(typeface2);

//        Html.fromHtml(story.title);
        title.setText(story.title);
        content.setText(story.content.replaceAll("\\\\n", "\n"));
        author.setText(story.author);

    }

}
