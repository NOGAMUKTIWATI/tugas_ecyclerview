package com.example.nogacoding;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
//buat class adapter yang extends RecyclerView dan buat View Holder
public class MoviesRecyclerViewAdapter extends RecyclerView.Adapter<MoviesRecyclerViewAdapter.MovieViewHolder> {
    ArrayList<Movies> arrayListMovies;
    //Buat kelas Array List
    public MoviesRecyclerViewAdapter(ArrayList<Movies> arrayListMovies) {
        this.arrayListMovies = arrayListMovies;
    }

    @NonNull
    @Override
    //OnCreateHolder buat inflate, di sini adaq parameter parent dan viewType
    public MoviesRecyclerViewAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent,false);
        //munculkan view holder (view)
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesRecyclerViewAdapter.MovieViewHolder holder, int position) {
        final Movies movies = arrayListMovies.get(position);
        //setText TextView setiap item beserta tipe datanya
        holder.textViewTittle.setText(movies.getTittle());
        holder.textViewRating.setText(String.valueOf(movies.getRating()));
        holder.textViewReleaseDate.setText(movies.getReleasedate());
        //memberikan action klik yang akan dibawa ke halaman isian pada main activity.java
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            //membuat deklarasi class onClick
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailMovieActivity.class);
                intent.putExtra("MOVIES",movies);//nama sesuai pada DetaiilMovieActivity.java dan var movies
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return  arrayListMovies.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTittle, textViewRating, textViewReleaseDate;
        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTittle = itemView.findViewById(R.id.tvTittle);
            textViewRating =itemView.findViewById(R.id.tvRating);
            textViewReleaseDate = itemView.findViewById(R.id.tvReleaseDate);
        }
    }
}
