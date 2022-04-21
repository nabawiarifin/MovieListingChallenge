package com.binar.movielistingchallenge.adapter

import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.binar.movielistingchallenge.databinding.MovieItemBinding
import com.binar.movielistingchallenge.model.Movies
import com.bumptech.glide.Glide
import kotlin.coroutines.coroutineContext

////Binar Adapter
//class MainAdapter(private val onItemClick: OnClickListener) : RecyclerView.Adapter<MainAdapter.MovieViewHolder>() {
//
//    private val diffCallback = object : DiffUtil.ItemCallback<Movies>() {
//        override fun areItemsTheSame(oldItem: Movies, newItem: Movies): Boolean =
//            oldItem.id == newItem.id
//
//
//        override fun areContentsTheSame(oldItem: Movies, newItem: Movies): Boolean =
//            oldItem.hashCode() == newItem.hashCode()
//
//    }
//
//    private val differ = AsyncListDiffer(this, diffCallback)
//
//    fun submitData(value: List<Movies>?) = differ.submitList(value)
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.MovieViewHolder {
//        val inflater = LayoutInflater.from(parent.context)
//        return MovieViewHolder(MovieItemBinding.inflate(inflater, parent, false))
//    }
//
//    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
//        val data = differ.currentList[position]
//        data.let { holder.bind(data) }
//    }
//
//    override fun getItemCount(): Int = differ.currentList.size
//
//    inner class MovieViewHolder(private val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {
//        fun bind(data: Movies) {
//            binding.apply {
//                tvTitle.text = data.title
//                tvRating.text = data.voteAverage.toString()
//                tvDescription.text = data.overview
//
//                Glide.with(itemView.context)
//                    .load(data.posterPath)
//                    .into(ivMovie)
//
//                root.setOnClickListener {
//                    onItemClick.onClickItem(data)
//                }
//            }
//        }
//    }
//
//    interface OnClickListener {
//        fun onClickItem(data: Movies)
//    }
//}
//
//Andre Adapter
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

        }

        Glide.with(holder.itemView.context)
            .load("https://image.tmdb.org/t/p/w780/"+data[position].backdropPath)
            .into(holder.binding.ivMovie)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}

