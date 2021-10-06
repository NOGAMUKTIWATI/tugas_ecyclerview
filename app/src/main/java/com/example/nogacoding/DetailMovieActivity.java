package com.example.nogacoding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailMovieActivity extends AppCompatActivity {
    //Deklarasi TextView
    TextView textViewTittle, textViewRating, textViewGenre, textViewReleaseDate, textViewDirector, textViewDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        //Pemanggilan masing masing item by ID
        textViewTittle = findViewById(R.id.tvTittle);
        textViewRating = findViewById(R.id.tvRating);
        textViewDescription = findViewById(R.id.tvDescription);
        textViewDirector = findViewById(R.id.tvDirector);
        textViewGenre = findViewById(R.id.tvGenre);
        textViewReleaseDate = findViewById(R.id.tvReleaseDate);
        //SetText
        Movies movies = getIntent().getParcelableExtra("MOVIES");
        textViewTittle.setText(movies.getTittle());
        textViewGenre.setText(movies.getGenre());
        textViewReleaseDate.setText(movies.getReleasedate());
        textViewDirector.setText(movies.getDirector());
        textViewDescription.setText(movies.getDescription());
        textViewRating.setText(String.valueOf(movies.getRating()));
    }
}