package com.example.vietvan.freestory;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class DescriptionActivity extends AppCompatActivity {

    ImageView image, back, mark;
    TextView title, author, des, start;
    public boolean ismark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        setupUI();

        final Story story = (Story) getIntent().getSerializableExtra("topic");

        title.setText(story.title);
        author.setText(story.author);
        des.setText(story.description);
        ismark = (story.bookmark == 0);
        if(story.bookmark == 1)
            mark.setImageResource(R.drawable.ic_bookmark_black_24dp);
        else
            mark.setImageResource(R.drawable.ic_bookmark_border_black_24dp);

        // Set layoutParams
        image.getLayoutParams().width = height * 20 / 100;
        image.requestLayout();

        Picasso.with(this).load(story.image).into(image);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        mark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ismark){
                    DataBaseManager.get(DescriptionActivity.this).updateMark(story, 1);
                    mark.setImageResource(R.drawable.ic_bookmark_black_24dp);
                }
                else{
                    DataBaseManager.get(DescriptionActivity.this).updateMark(story, 0);
                    mark.setImageResource(R.drawable.ic_bookmark_border_black_24dp);
                }
                ismark = !ismark;
            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DescriptionActivity.this, StoryActivity.class);
                intent.putExtra("topic", story);
                startActivity(intent);
            }
        });

    }

    private void setupUI() {
        image = findViewById(R.id.iv);
        back = findViewById(R.id.iv_back);
        mark = findViewById(R.id.iv_mark);
        title = findViewById(R.id.des_tv_title);
        author = findViewById(R.id.des_tv_author);
        des = findViewById(R.id.des_tv_descrip);
        start = findViewById(R.id.des_tv_start);
    }
}
