package com.binar.movielistingchallenge.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.binar.movielistingchallenge.databinding.MovieItemBinding
import com.binar.movielistingchallenge.data.movies.MovieDetails
import com.binar.movielistingchallenge.data.movies.Movies
import com.bumptech.glide.Glide

class MainAdapter(private val data:List<Movies>) : RecyclerView.Adapter<MainAdapter.MovieViewHolder>() {

    inner class MovieViewHolder(val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        with(holder.binding) {
            tvTitle.text = data[position].title
            tvRating.text = data[position].voteAverage.toString()
            tvDescription.text = data[position].overview

            viewMovie.setOnClickListener {
                val title = data[position].title
                val poster = data[position].backdropPath
                val date = data[position].releaseDate
                val overview = data[position].overview

                val movieDetails = MovieDetails(
                    title,
                    poster,
                    date,
                    overview
                )

                it.findNavController().navigate(MainFragmentDirections.actionMainFragmentToSecondFragment(movieDetails))
            }
        }

        Glide.with(holder.itemView.context)
            .load("https://image.tmdb.org/t/p/w780/"+data[position].backdropPath)
            .into(holder.binding.ivMovie)


    }

    override fun getItemCount(): Int {
        return data.size
    }
}

