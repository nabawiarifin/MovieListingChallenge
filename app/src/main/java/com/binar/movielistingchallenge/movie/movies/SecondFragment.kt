package com.binar.movielistingchallenge.movie.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.binar.movielistingchallenge.R
import com.binar.movielistingchallenge.databinding.FragmentMainBinding
import com.binar.movielistingchallenge.databinding.FragmentSecondBinding
import com.bumptech.glide.Glide

class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding
    private val args: SecondFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(requireContext())
            .load("https://image.tmdb.org/t/p/w780/"+args.movieDetails.poster)
            .into(binding.ivMovie)

        binding.tvTitle.text = args.movieDetails.title
        binding.tvDate.text = args.movieDetails.date
        binding.tvOverview.text = args.movieDetails.overview

    }
}