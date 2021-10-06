package com.example.nogacoding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //deklarasi RecyclerView
    RecyclerView recyclerView;
    //Deklarasi adapter
    MoviesRecyclerViewAdapter adapter;
    //Deklarasi ArrayList
    ArrayList<Movies> objMovies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Pemanggilan recycleView by ID
        recyclerView = findViewById(R.id.recyclerView);
        //Pengisian data, Urut sesuai yang ada di object Movies"title,genre,director,rating,description"
        objMovies.add(new Movies("The Suicide Squad","Action,Adventure,Comedy","James Gunn",7.3,"Supervillains Harley Quinn, Bloodsport, Peacemaker and a collection of nutty cons at Belle Reve prison join the super-secret, super-shady Task Force X as they are dropped off at the remote, enemy-infused island of Corto Maltese.","6 Agustus 2021"));
        objMovies.add(new Movies("Curse Of The Dragon","Full Fantasy Movie","V Movie",7.4,"A brave knight returns to his homeland to find a powerful dragon terrorizing his village. After many unsuccessful attempts to defeat the monster, he makes a sword which has magical powers that should do the trick.With a storyline right out of Dungeons & Dragons, this dark fantasy of elves, orcs, and dragons is the perfect thing to fill your LOTR void.","28 Agu 2020" ));
        //set adapter
        adapter = new MoviesRecyclerViewAdapter(objMovies);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }
}